package com.example.service;

import com.example.model.AddressRequest;
import com.example.dto.NominatimResult; // Import the new DTO

import com.fasterxml.jackson.core.JsonProcessingException; // For Jackson exceptions
import com.fasterxml.jackson.core.type.TypeReference; // For parsing lists
import com.fasterxml.jackson.databind.ObjectMapper; // Import ObjectMapper

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List; // Import List

@Service
public class NominatimGeocodingServiceImpl implements GeocodingService {

    private static final Logger log = LoggerFactory.getLogger(NominatimGeocodingServiceImpl.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper; // Inject ObjectMapper

    @Value("${geocoding.nominatim.api.url}")
    private String nominatimApiUrl;

    @Value("${geocoding.nominatim.user-agent:MyLogisticsApp/1.0 (Spring Boot App; contact@example.com)}")
    private String userAgent;

    // Updated constructor to inject ObjectMapper
    public NominatimGeocodingServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Coordinates geocode(AddressRequest address) {
        log.info("Attempting to geocode address: Street='{}', City='{}', State='{}', PinCode='{}'",
                address.getStreet(), address.getCity(), address.getState(), address.getPinCode());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(nominatimApiUrl);

        // ... (URL building code remains the same as in Step 3)
        if (address.getStreet() != null && !address.getStreet().isEmpty()) {
            builder.queryParam("street", address.getStreet());
        }
        if (address.getCity() != null && !address.getCity().isEmpty()) {
            builder.queryParam("city", address.getCity());
        }
        if (address.getState() != null && !address.getState().isEmpty()) {
            builder.queryParam("state", address.getState());
        }
        if (address.getPinCode() != null && !address.getPinCode().isEmpty()) {
            builder.queryParam("postalcode", address.getPinCode());
        }
        builder.queryParam("country", "India");

        builder.queryParam("format", "json");
        builder.queryParam("limit", 1);
        builder.queryParam("addressdetails", 1);
        // ... (URL building code ends)

        URI uri = builder.build().toUri();
        log.debug("Constructed Nominatim API URI: {}", uri);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", userAgent);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();
                log.debug("Nominatim API raw response: {}", responseBody);

                if (responseBody == null || responseBody.isEmpty()) {
                    log.warn("Nominatim API returned an empty response body for address: {}", address);
                    return null; // Or throw an exception / return default coordinates
                }

                // Parse the JSON response
                // Nominatim returns a JSON array, so we parse into a List<NominatimResult>
                List<NominatimResult> results = objectMapper.readValue(responseBody, new TypeReference<List<NominatimResult>>() {});

                if (results != null && !results.isEmpty()) {
                    NominatimResult firstResult = results.get(0); // We requested limit=1
                    log.debug("Parsed Nominatim result: {}", firstResult);

                    try {
                        double lat = Double.parseDouble(firstResult.getLatitude());
                        double lon = Double.parseDouble(firstResult.getLongitude());
                        return new Coordinates(lat, lon);
                    } catch (NumberFormatException e) {
                        log.error("Failed to parse latitude/longitude from Nominatim result: lat='{}', lon='{}' for address: {}",
                                firstResult.getLatitude(), firstResult.getLongitude(), address, e);
                        return null; // Or handle error appropriately
                    }
                } else {
                    log.warn("No geocoding results found for address: {}", address);
                    return null; // Or throw an exception / return default coordinates
                }

            } else {
                log.warn("Nominatim API call failed with status code: {} and body: {}", response.getStatusCode(), response.getBody());
            }

        } catch (JsonProcessingException e) {
            log.error("Failed to parse JSON response from Nominatim for address: {}. Response: {}", address, e.getMessage(), e);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Nominatim API call failed with HTTP error: {} - Response body: {}", e.getStatusCode(), e.getResponseBodyAsString(), e);
        } catch (RestClientException e) {
            log.error("Nominatim API call failed with RestClientException for address: {}: {}", address, e.getMessage(), e);
        } catch (Exception e) {
            log.error("An unexpected error occurred during geocoding for address: {}: {}", address, e.getMessage(), e);
        }

        // Fallback: return null or default coordinates if any step fails
        // Depending on your application's requirements, you might prefer to throw a custom exception.
        log.warn("Geocoding failed to produce coordinates for address: {}, returning null", address);
        return null; // Or new Coordinates(0.0, 0.0) or throw custom exception
    }
}
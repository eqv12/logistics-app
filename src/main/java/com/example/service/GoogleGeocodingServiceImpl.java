package com.example.service;

import com.example.model.AddressRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng; // Google's LatLng object
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary; // If you want this to be the default GeocodingService
import org.springframework.stereotype.Service;

@Service
@Qualifier("googleGeocodingService") // Give it a specific name
@Primary // Uncomment this if you want Spring to inject this implementation by default
// when autowiring GeocodingService. Remove @Primary from NominatimGeocodingServiceImpl if you do.
public class GoogleGeocodingServiceImpl implements GeocodingService {

    private static final Logger log = LoggerFactory.getLogger(GoogleGeocodingServiceImpl.class);

    private final GeoApiContext geoApiContext;

    public GoogleGeocodingServiceImpl(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    @Override
    public Coordinates geocode(AddressRequest address) {
        // Construct a readable address string for Google Geocoding API
        // Google generally prefers a single, well-formatted address string.
        StringBuilder addressBuilder = new StringBuilder();
        if (address.getStreet() != null && !address.getStreet().isEmpty()) {
            addressBuilder.append(address.getStreet());
        }
        if (address.getCity() != null && !address.getCity().isEmpty()) {
            if (addressBuilder.length() > 0) addressBuilder.append(", ");
            addressBuilder.append(address.getCity());
        }
        if (address.getState() != null && !address.getState().isEmpty()) {
            if (addressBuilder.length() > 0) addressBuilder.append(", ");
            addressBuilder.append(address.getState());
        }
        if (address.getPinCode() != null && !address.getPinCode().isEmpty()) {
            if (addressBuilder.length() > 0) addressBuilder.append(", ");
            addressBuilder.append(address.getPinCode());
        }
        // For Google, adding the country can be beneficial for accuracy if not implied by other fields.
        // Consider adding "India" or making country part of your AddressRequest
        if (addressBuilder.length() > 0) addressBuilder.append(", India"); // Assuming India context

        String fullAddress = addressBuilder.toString();
        if (fullAddress.isEmpty()) {
            log.warn("AddressRequest is empty, cannot geocode.");
            return null;
        }

        log.info("Attempting to geocode address with Google: '{}'", fullAddress);

        try {
            // Make the geocoding request
            GeocodingResult[] results = GeocodingApi.geocode(geoApiContext, fullAddress)
                    // You can add .components(...) or .bounds(...) for more specific searches
                    // e.g., .region("in") to bias results towards India
                    .region("in") // Bias results to India
                    .await(); // Executes the request synchronously

            if (results != null && results.length > 0) {
                // Get the first result (most relevant)
                GeocodingResult firstResult = results[0];
                LatLng location = firstResult.geometry.location;

                log.debug("Google Geocoding Result for '{}': Lat={}, Lng={}, Formatted Address='{}'",
                        fullAddress, location.lat, location.lng, firstResult.formattedAddress);

                return new Coordinates(location.lat, location.lng);
            } else {
                log.warn("No geocoding results found by Google for address: '{}'", fullAddress);
                return null;
            }

        } catch (Exception e) {
            // The google-maps-services library can throw various exceptions,
            // e.g., ApiException for API errors (OVER_QUERY_LIMIT, REQUEST_DENIED, ZERO_RESULTS),
            // IOException for network issues, InterruptedException.
            log.error("Error during Google geocoding for address '{}': {}", fullAddress, e.getMessage(), e);
            // You might want to inspect e more closely to handle specific cases like ZERO_RESULTS differently.
            // For example, ZERO_RESULTS is not strictly an "error" but means the address wasn't found.
            // The library throws com.google.maps.errors.ZeroResultsException in this case.
            if (e instanceof com.google.maps.errors.ZeroResultsException) {
                log.warn("Google Geocoding API returned ZERO_RESULTS for address: '{}'", fullAddress);
            }
            return null;
        }
    }
}
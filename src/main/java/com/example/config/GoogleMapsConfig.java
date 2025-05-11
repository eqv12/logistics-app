package com.example.config;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleMapsConfig {

    @Value("${google.maps.api.key}")
    private String googleApiKey;

    @Bean
    public GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(googleApiKey)
                // You can set other options here if needed:
                // .connectTimeout(10, TimeUnit.SECONDS)
                // .readTimeout(10, TimeUnit.SECONDS)
                // .queryRateLimit(50) // Default is 50 QPS for most Google Maps APIs
                .build();
    }
}
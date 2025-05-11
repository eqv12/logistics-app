package com.example.service;

import com.example.model.AddressRequest; // Your OpenAPI model

public interface GeocodingService {
    Coordinates geocode(AddressRequest address);

    class Coordinates {
        public final double latitude;
        public final double longitude;

        public Coordinates(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
        // Optional: equals, hashCode, toString for better usability/testing
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(latitude, longitude);
        }

        @Override
        public String toString() {
            return "Coordinates{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }
}
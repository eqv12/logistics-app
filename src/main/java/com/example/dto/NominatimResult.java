package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// This annotation tells Jackson to ignore any properties in the JSON
// that are not defined in this class. This makes your DTO more resilient
// to changes in the external API (e.g., if Nominatim adds new fields).
@JsonIgnoreProperties(ignoreUnknown = true)
public class NominatimResult {

    @JsonProperty("place_id")
    private long placeId;

    @JsonProperty("lat")
    private String latitude; // Nominatim returns lat/lon as strings in JSON

    @JsonProperty("lon")
    private String longitude; // Nominatim returns lat/lon as strings in JSON

    @JsonProperty("display_name")
    private String displayName;

    // We can also map the nested 'address' object if needed later
    // @JsonProperty("address")
    // private NominatimAddressDetails address;

    // Getters and Setters
    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    // If you decide to map the 'address' object, you'd create a NominatimAddressDetails class
    // and add its getter/setter here.

    @Override
    public String toString() {
        return "NominatimResult{" +
                "placeId=" + placeId +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
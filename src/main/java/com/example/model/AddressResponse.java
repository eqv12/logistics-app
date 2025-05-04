package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * AddressResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class AddressResponse {

  private String street;

  private String city;

  private String state;

  private String pinCode;

  private Double latitude;

  private Double longitude;

  public AddressResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AddressResponse(String street, String city, String state, String pinCode, Double latitude, Double longitude) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.pinCode = pinCode;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public AddressResponse street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Street address line 1 (and 2 if needed).
   * @return street
   */
  @NotNull 
  @Schema(name = "street", example = "15, Race Course Road", description = "Street address line 1 (and 2 if needed).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("street")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public AddressResponse city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
   */
  @NotNull 
  @Schema(name = "city", example = "Coimbatore", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public AddressResponse state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   */
  @NotNull 
  @Schema(name = "state", example = "Tamil Nadu", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AddressResponse pinCode(String pinCode) {
    this.pinCode = pinCode;
    return this;
  }

  /**
   * Indian Postal Index Number (PIN Code).
   * @return pinCode
   */
  @NotNull 
  @Schema(name = "pinCode", example = "641018", description = "Indian Postal Index Number (PIN Code).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pinCode")
  public String getPinCode() {
    return pinCode;
  }

  public void setPinCode(String pinCode) {
    this.pinCode = pinCode;
  }

  public AddressResponse latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Latitude coordinate.
   * @return latitude
   */
  @NotNull 
  @Schema(name = "latitude", example = "11.0168", description = "Latitude coordinate.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("latitude")
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public AddressResponse longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Longitude coordinate.
   * @return longitude
   */
  @NotNull 
  @Schema(name = "longitude", example = "76.9558", description = "Longitude coordinate.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("longitude")
  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressResponse addressResponse = (AddressResponse) o;
    return Objects.equals(this.street, addressResponse.street) &&
        Objects.equals(this.city, addressResponse.city) &&
        Objects.equals(this.state, addressResponse.state) &&
        Objects.equals(this.pinCode, addressResponse.pinCode) &&
        Objects.equals(this.latitude, addressResponse.latitude) &&
        Objects.equals(this.longitude, addressResponse.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, pinCode, latitude, longitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressResponse {\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    pinCode: ").append(toIndentedString(pinCode)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


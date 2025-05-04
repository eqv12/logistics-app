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
 * AddressRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class AddressRequest {

  private String street;

  private String city;

  private String state;

  private String pinCode;

  public AddressRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AddressRequest(String street, String city, String state, String pinCode) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.pinCode = pinCode;
  }

  public AddressRequest street(String street) {
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

  public AddressRequest city(String city) {
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

  public AddressRequest state(String state) {
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

  public AddressRequest pinCode(String pinCode) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressRequest addressRequest = (AddressRequest) o;
    return Objects.equals(this.street, addressRequest.street) &&
        Objects.equals(this.city, addressRequest.city) &&
        Objects.equals(this.state, addressRequest.state) &&
        Objects.equals(this.pinCode, addressRequest.pinCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, pinCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressRequest {\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    pinCode: ").append(toIndentedString(pinCode)).append("\n");
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


package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.AddressRequest;
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
 * CustomerRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class CustomerRequest {

  private String name;

  private String phoneNumber;

  private AddressRequest deliveryAddress;

  public CustomerRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CustomerRequest(String name, String phoneNumber, AddressRequest deliveryAddress) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.deliveryAddress = deliveryAddress;
  }

  public CustomerRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Ravi Kumar", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerRequest phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
   */
  @NotNull 
  @Schema(name = "phoneNumber", example = "+919876543210", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public CustomerRequest deliveryAddress(AddressRequest deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
    return this;
  }

  /**
   * Get deliveryAddress
   * @return deliveryAddress
   */
  @NotNull @Valid 
  @Schema(name = "deliveryAddress", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deliveryAddress")
  public AddressRequest getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(AddressRequest deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerRequest customerRequest = (CustomerRequest) o;
    return Objects.equals(this.name, customerRequest.name) &&
        Objects.equals(this.phoneNumber, customerRequest.phoneNumber) &&
        Objects.equals(this.deliveryAddress, customerRequest.deliveryAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, phoneNumber, deliveryAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
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


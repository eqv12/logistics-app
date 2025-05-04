package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.AddressRequest;
import com.example.model.CustomerRequest;
import com.example.model.ParcelDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class OrderRequest {

  private CustomerRequest customerRequest;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime orderDate;

  private Integer deliveryType;

  private ParcelDetails parcelDetails;

  private AddressRequest sourceLocation;

  public OrderRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderRequest(CustomerRequest customerRequest, OffsetDateTime orderDate, Integer deliveryType, ParcelDetails parcelDetails, AddressRequest sourceLocation) {
    this.customerRequest = customerRequest;
    this.orderDate = orderDate;
    this.deliveryType = deliveryType;
    this.parcelDetails = parcelDetails;
    this.sourceLocation = sourceLocation;
  }

  public OrderRequest customerRequest(CustomerRequest customerRequest) {
    this.customerRequest = customerRequest;
    return this;
  }

  /**
   * Get customerRequest
   * @return customerRequest
   */
  @NotNull @Valid 
  @Schema(name = "customerRequest", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerRequest")
  public CustomerRequest getCustomerRequest() {
    return customerRequest;
  }

  public void setCustomerRequest(CustomerRequest customerRequest) {
    this.customerRequest = customerRequest;
  }

  public OrderRequest orderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
    return this;
  }

  /**
   * Timestamp when the order was placed (ISO 8601). Server should default if not provided?
   * @return orderDate
   */
  @NotNull @Valid 
  @Schema(name = "orderDate", example = "2025-05-04T11:00Z", description = "Timestamp when the order was placed (ISO 8601). Server should default if not provided?", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderDate")
  public OffsetDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public OrderRequest deliveryType(Integer deliveryType) {
    this.deliveryType = deliveryType;
    return this;
  }

  /**
   * Delivery service level (0: Same Day, 1: Next Day, etc.). Determines priority.
   * @return deliveryType
   */
  @NotNull 
  @Schema(name = "deliveryType", example = "0", description = "Delivery service level (0: Same Day, 1: Next Day, etc.). Determines priority.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deliveryType")
  public Integer getDeliveryType() {
    return deliveryType;
  }

  public void setDeliveryType(Integer deliveryType) {
    this.deliveryType = deliveryType;
  }

  public OrderRequest parcelDetails(ParcelDetails parcelDetails) {
    this.parcelDetails = parcelDetails;
    return this;
  }

  /**
   * Get parcelDetails
   * @return parcelDetails
   */
  @NotNull @Valid 
  @Schema(name = "parcelDetails", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parcelDetails")
  public ParcelDetails getParcelDetails() {
    return parcelDetails;
  }

  public void setParcelDetails(ParcelDetails parcelDetails) {
    this.parcelDetails = parcelDetails;
  }

  public OrderRequest sourceLocation(AddressRequest sourceLocation) {
    this.sourceLocation = sourceLocation;
    return this;
  }

  /**
   * Get sourceLocation
   * @return sourceLocation
   */
  @NotNull @Valid 
  @Schema(name = "sourceLocation", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sourceLocation")
  public AddressRequest getSourceLocation() {
    return sourceLocation;
  }

  public void setSourceLocation(AddressRequest sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderRequest orderRequest = (OrderRequest) o;
    return Objects.equals(this.customerRequest, orderRequest.customerRequest) &&
        Objects.equals(this.orderDate, orderRequest.orderDate) &&
        Objects.equals(this.deliveryType, orderRequest.deliveryType) &&
        Objects.equals(this.parcelDetails, orderRequest.parcelDetails) &&
        Objects.equals(this.sourceLocation, orderRequest.sourceLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerRequest, orderDate, deliveryType, parcelDetails, sourceLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderRequest {\n");
    sb.append("    customerRequest: ").append(toIndentedString(customerRequest)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
    sb.append("    deliveryType: ").append(toIndentedString(deliveryType)).append("\n");
    sb.append("    parcelDetails: ").append(toIndentedString(parcelDetails)).append("\n");
    sb.append("    sourceLocation: ").append(toIndentedString(sourceLocation)).append("\n");
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


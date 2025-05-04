package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.AddressResponse;
import com.example.model.CustomerResponse;
import com.example.model.InternalProcessingStatus;
import com.example.model.OrderStatus;
import com.example.model.ParcelDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class OrderResponse {

  private UUID id;

  private CustomerResponse customerResponse;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime orderDate;

  private Integer deliveryType;

  private ParcelDetails parcelDetails;

  private AddressResponse sourceLocation;

  private OrderStatus status;

  private InternalProcessingStatus internalProcessingStatus;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private JsonNullable<OffsetDateTime> deliveryDate = JsonNullable.<OffsetDateTime>undefined();

  private JsonNullable<String> assignedVehicleId = JsonNullable.<String>undefined();

  public OrderResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderResponse(UUID id, CustomerResponse customerResponse, OffsetDateTime orderDate, Integer deliveryType, ParcelDetails parcelDetails, AddressResponse sourceLocation, OrderStatus status, InternalProcessingStatus internalProcessingStatus) {
    this.id = id;
    this.customerResponse = customerResponse;
    this.orderDate = orderDate;
    this.deliveryType = deliveryType;
    this.parcelDetails = parcelDetails;
    this.sourceLocation = sourceLocation;
    this.status = status;
    this.internalProcessingStatus = internalProcessingStatus;
  }

  public OrderResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the order.
   * @return id
   */
  @NotNull @Valid 
  @Schema(name = "id", description = "Unique identifier for the order.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public OrderResponse customerResponse(CustomerResponse customerResponse) {
    this.customerResponse = customerResponse;
    return this;
  }

  /**
   * Get customerResponse
   * @return customerResponse
   */
  @NotNull @Valid 
  @Schema(name = "customerResponse", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerResponse")
  public CustomerResponse getCustomerResponse() {
    return customerResponse;
  }

  public void setCustomerResponse(CustomerResponse customerResponse) {
    this.customerResponse = customerResponse;
  }

  public OrderResponse orderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
    return this;
  }

  /**
   * Timestamp when the order was placed (ISO 8601).
   * @return orderDate
   */
  @NotNull @Valid 
  @Schema(name = "orderDate", example = "2025-05-04T11:00Z", description = "Timestamp when the order was placed (ISO 8601).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderDate")
  public OffsetDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public OrderResponse deliveryType(Integer deliveryType) {
    this.deliveryType = deliveryType;
    return this;
  }

  /**
   * Delivery service level (0: Same Day, 1: Next Day, etc.).
   * @return deliveryType
   */
  @NotNull 
  @Schema(name = "deliveryType", example = "0", description = "Delivery service level (0: Same Day, 1: Next Day, etc.).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deliveryType")
  public Integer getDeliveryType() {
    return deliveryType;
  }

  public void setDeliveryType(Integer deliveryType) {
    this.deliveryType = deliveryType;
  }

  public OrderResponse parcelDetails(ParcelDetails parcelDetails) {
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

  public OrderResponse sourceLocation(AddressResponse sourceLocation) {
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
  public AddressResponse getSourceLocation() {
    return sourceLocation;
  }

  public void setSourceLocation(AddressResponse sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  public OrderResponse status(OrderStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public OrderResponse internalProcessingStatus(InternalProcessingStatus internalProcessingStatus) {
    this.internalProcessingStatus = internalProcessingStatus;
    return this;
  }

  /**
   * Get internalProcessingStatus
   * @return internalProcessingStatus
   */
  @NotNull @Valid 
  @Schema(name = "internalProcessingStatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("internalProcessingStatus")
  public InternalProcessingStatus getInternalProcessingStatus() {
    return internalProcessingStatus;
  }

  public void setInternalProcessingStatus(InternalProcessingStatus internalProcessingStatus) {
    this.internalProcessingStatus = internalProcessingStatus;
  }

  public OrderResponse deliveryDate(OffsetDateTime deliveryDate) {
    this.deliveryDate = JsonNullable.of(deliveryDate);
    return this;
  }

  /**
   * Timestamp when the order was actually delivered (ISO 8601). Null if not delivered.
   * @return deliveryDate
   */
  @Valid 
  @Schema(name = "deliveryDate", example = "2025-05-04T15:30Z", description = "Timestamp when the order was actually delivered (ISO 8601). Null if not delivered.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deliveryDate")
  public JsonNullable<OffsetDateTime> getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(JsonNullable<OffsetDateTime> deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public OrderResponse assignedVehicleId(String assignedVehicleId) {
    this.assignedVehicleId = JsonNullable.of(assignedVehicleId);
    return this;
  }

  /**
   * Registration number of the assigned vehicle. Null if not assigned.
   * @return assignedVehicleId
   */
  
  @Schema(name = "assignedVehicleId", example = "TN38AB1234", description = "Registration number of the assigned vehicle. Null if not assigned.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assignedVehicleId")
  public JsonNullable<String> getAssignedVehicleId() {
    return assignedVehicleId;
  }

  public void setAssignedVehicleId(JsonNullable<String> assignedVehicleId) {
    this.assignedVehicleId = assignedVehicleId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderResponse orderResponse = (OrderResponse) o;
    return Objects.equals(this.id, orderResponse.id) &&
        Objects.equals(this.customerResponse, orderResponse.customerResponse) &&
        Objects.equals(this.orderDate, orderResponse.orderDate) &&
        Objects.equals(this.deliveryType, orderResponse.deliveryType) &&
        Objects.equals(this.parcelDetails, orderResponse.parcelDetails) &&
        Objects.equals(this.sourceLocation, orderResponse.sourceLocation) &&
        Objects.equals(this.status, orderResponse.status) &&
        Objects.equals(this.internalProcessingStatus, orderResponse.internalProcessingStatus) &&
        equalsNullable(this.deliveryDate, orderResponse.deliveryDate) &&
        equalsNullable(this.assignedVehicleId, orderResponse.assignedVehicleId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerResponse, orderDate, deliveryType, parcelDetails, sourceLocation, status, internalProcessingStatus, hashCodeNullable(deliveryDate), hashCodeNullable(assignedVehicleId));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customerResponse: ").append(toIndentedString(customerResponse)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
    sb.append("    deliveryType: ").append(toIndentedString(deliveryType)).append("\n");
    sb.append("    parcelDetails: ").append(toIndentedString(parcelDetails)).append("\n");
    sb.append("    sourceLocation: ").append(toIndentedString(sourceLocation)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    internalProcessingStatus: ").append(toIndentedString(internalProcessingStatus)).append("\n");
    sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
    sb.append("    assignedVehicleId: ").append(toIndentedString(assignedVehicleId)).append("\n");
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


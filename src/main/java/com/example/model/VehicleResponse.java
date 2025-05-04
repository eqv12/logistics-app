package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.VehicleStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * VehicleResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class VehicleResponse {

  private String registrationNumber;

  private String vehicleType;

  private Float capacity;

  private Float availableCapacity;

  private VehicleStatus vehicleStatus;

  public VehicleResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VehicleResponse(String registrationNumber, String vehicleType, Float capacity, Float availableCapacity, VehicleStatus vehicleStatus) {
    this.registrationNumber = registrationNumber;
    this.vehicleType = vehicleType;
    this.capacity = capacity;
    this.availableCapacity = availableCapacity;
    this.vehicleStatus = vehicleStatus;
  }

  public VehicleResponse registrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

  /**
   * Get registrationNumber
   * @return registrationNumber
   */
  @NotNull 
  @Schema(name = "registrationNumber", example = "TN38AB1234", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("registrationNumber")
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public VehicleResponse vehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
    return this;
  }

  /**
   * Get vehicleType
   * @return vehicleType
   */
  @NotNull 
  @Schema(name = "vehicleType", example = "Van", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vehicleType")
  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public VehicleResponse capacity(Float capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Total carrying capacity (e.g., in kg).
   * @return capacity
   */
  @NotNull 
  @Schema(name = "capacity", example = "500.0", description = "Total carrying capacity (e.g., in kg).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("capacity")
  public Float getCapacity() {
    return capacity;
  }

  public void setCapacity(Float capacity) {
    this.capacity = capacity;
  }

  public VehicleResponse availableCapacity(Float availableCapacity) {
    this.availableCapacity = availableCapacity;
    return this;
  }

  /**
   * Current available capacity (server-calculated, e.g., in kg).
   * @return availableCapacity
   */
  
  @Schema(name = "availableCapacity", accessMode = Schema.AccessMode.READ_ONLY, example = "350.5", description = "Current available capacity (server-calculated, e.g., in kg).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("availableCapacity")
  public Float getAvailableCapacity() {
    return availableCapacity;
  }

  public void setAvailableCapacity(Float availableCapacity) {
    this.availableCapacity = availableCapacity;
  }

  public VehicleResponse vehicleStatus(VehicleStatus vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
    return this;
  }

  /**
   * Get vehicleStatus
   * @return vehicleStatus
   */
  @NotNull @Valid 
  @Schema(name = "vehicleStatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vehicleStatus")
  public VehicleStatus getVehicleStatus() {
    return vehicleStatus;
  }

  public void setVehicleStatus(VehicleStatus vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleResponse vehicleResponse = (VehicleResponse) o;
    return Objects.equals(this.registrationNumber, vehicleResponse.registrationNumber) &&
        Objects.equals(this.vehicleType, vehicleResponse.vehicleType) &&
        Objects.equals(this.capacity, vehicleResponse.capacity) &&
        Objects.equals(this.availableCapacity, vehicleResponse.availableCapacity) &&
        Objects.equals(this.vehicleStatus, vehicleResponse.vehicleStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registrationNumber, vehicleType, capacity, availableCapacity, vehicleStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleResponse {\n");
    sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
    sb.append("    vehicleStatus: ").append(toIndentedString(vehicleStatus)).append("\n");
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


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
 * VehicleRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class VehicleRequest {

  private String registrationNumber;

  private String vehicleType;

  private Float capacity;

  public VehicleRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VehicleRequest(String registrationNumber, String vehicleType, Float capacity) {
    this.registrationNumber = registrationNumber;
    this.vehicleType = vehicleType;
    this.capacity = capacity;
  }

  public VehicleRequest registrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

  /**
   * Unique vehicle registration number (e.g., license plate).
   * @return registrationNumber
   */
  @NotNull 
  @Schema(name = "registrationNumber", example = "TN38AB1234", description = "Unique vehicle registration number (e.g., license plate).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("registrationNumber")
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public VehicleRequest vehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
    return this;
  }

  /**
   * Type of vehicle (e.g., Van, Truck, Bike).
   * @return vehicleType
   */
  @NotNull 
  @Schema(name = "vehicleType", example = "Van", description = "Type of vehicle (e.g., Van, Truck, Bike).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vehicleType")
  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public VehicleRequest capacity(Float capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Total carrying capacity of the vehicle (e.g., in kilograms or cubic meters - specify unit).
   * minimum: 0
   * @return capacity
   */
  @NotNull @DecimalMin("0") 
  @Schema(name = "capacity", example = "500.0", description = "Total carrying capacity of the vehicle (e.g., in kilograms or cubic meters - specify unit).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("capacity")
  public Float getCapacity() {
    return capacity;
  }

  public void setCapacity(Float capacity) {
    this.capacity = capacity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleRequest vehicleRequest = (VehicleRequest) o;
    return Objects.equals(this.registrationNumber, vehicleRequest.registrationNumber) &&
        Objects.equals(this.vehicleType, vehicleRequest.vehicleType) &&
        Objects.equals(this.capacity, vehicleRequest.capacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registrationNumber, vehicleType, capacity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleRequest {\n");
    sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
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


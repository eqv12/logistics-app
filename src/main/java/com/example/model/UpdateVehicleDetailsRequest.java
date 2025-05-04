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
 * UpdateVehicleDetailsRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class UpdateVehicleDetailsRequest {

  private Float capacity;

  private VehicleStatus vehicleStatus;

  public UpdateVehicleDetailsRequest capacity(Float capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * New total carrying capacity of the vehicle (e.g., in kg).
   * minimum: 0
   * @return capacity
   */
  @DecimalMin("0") 
  @Schema(name = "capacity", example = "550.0", description = "New total carrying capacity of the vehicle (e.g., in kg).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("capacity")
  public Float getCapacity() {
    return capacity;
  }

  public void setCapacity(Float capacity) {
    this.capacity = capacity;
  }

  public UpdateVehicleDetailsRequest vehicleStatus(VehicleStatus vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
    return this;
  }

  /**
   * Get vehicleStatus
   * @return vehicleStatus
   */
  @Valid 
  @Schema(name = "vehicleStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    UpdateVehicleDetailsRequest updateVehicleDetailsRequest = (UpdateVehicleDetailsRequest) o;
    return Objects.equals(this.capacity, updateVehicleDetailsRequest.capacity) &&
        Objects.equals(this.vehicleStatus, updateVehicleDetailsRequest.vehicleStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(capacity, vehicleStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateVehicleDetailsRequest {\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
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


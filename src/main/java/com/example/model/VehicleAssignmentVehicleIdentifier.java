package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * VehicleAssignmentVehicleIdentifier
 */

@JsonTypeName("VehicleAssignment_vehicleIdentifier")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class VehicleAssignmentVehicleIdentifier {

  private String registrationNumber;

  private String vehicleType;

  public VehicleAssignmentVehicleIdentifier() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VehicleAssignmentVehicleIdentifier(String registrationNumber, String vehicleType) {
    this.registrationNumber = registrationNumber;
    this.vehicleType = vehicleType;
  }

  public VehicleAssignmentVehicleIdentifier registrationNumber(String registrationNumber) {
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

  public VehicleAssignmentVehicleIdentifier vehicleType(String vehicleType) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleAssignmentVehicleIdentifier vehicleAssignmentVehicleIdentifier = (VehicleAssignmentVehicleIdentifier) o;
    return Objects.equals(this.registrationNumber, vehicleAssignmentVehicleIdentifier.registrationNumber) &&
        Objects.equals(this.vehicleType, vehicleAssignmentVehicleIdentifier.vehicleType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registrationNumber, vehicleType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleAssignmentVehicleIdentifier {\n");
    sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
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


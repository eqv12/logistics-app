package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.OrderResponse;
import com.example.model.VehicleAssignmentVehicleIdentifier;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * VehicleAssignment
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class VehicleAssignment {

  private VehicleAssignmentVehicleIdentifier vehicleIdentifier;

  @Valid
  private List<@Valid OrderResponse> assignedOrders = new ArrayList<>();

  public VehicleAssignment() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VehicleAssignment(VehicleAssignmentVehicleIdentifier vehicleIdentifier, List<@Valid OrderResponse> assignedOrders) {
    this.vehicleIdentifier = vehicleIdentifier;
    this.assignedOrders = assignedOrders;
  }

  public VehicleAssignment vehicleIdentifier(VehicleAssignmentVehicleIdentifier vehicleIdentifier) {
    this.vehicleIdentifier = vehicleIdentifier;
    return this;
  }

  /**
   * Get vehicleIdentifier
   * @return vehicleIdentifier
   */
  @NotNull @Valid 
  @Schema(name = "vehicleIdentifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vehicleIdentifier")
  public VehicleAssignmentVehicleIdentifier getVehicleIdentifier() {
    return vehicleIdentifier;
  }

  public void setVehicleIdentifier(VehicleAssignmentVehicleIdentifier vehicleIdentifier) {
    this.vehicleIdentifier = vehicleIdentifier;
  }

  public VehicleAssignment assignedOrders(List<@Valid OrderResponse> assignedOrders) {
    this.assignedOrders = assignedOrders;
    return this;
  }

  public VehicleAssignment addAssignedOrdersItem(OrderResponse assignedOrdersItem) {
    if (this.assignedOrders == null) {
      this.assignedOrders = new ArrayList<>();
    }
    this.assignedOrders.add(assignedOrdersItem);
    return this;
  }

  /**
   * List of orders currently assigned to this vehicle. (Consider adding pagination info here if this list can be very long)
   * @return assignedOrders
   */
  @NotNull @Valid 
  @Schema(name = "assignedOrders", description = "List of orders currently assigned to this vehicle. (Consider adding pagination info here if this list can be very long)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("assignedOrders")
  public List<@Valid OrderResponse> getAssignedOrders() {
    return assignedOrders;
  }

  public void setAssignedOrders(List<@Valid OrderResponse> assignedOrders) {
    this.assignedOrders = assignedOrders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleAssignment vehicleAssignment = (VehicleAssignment) o;
    return Objects.equals(this.vehicleIdentifier, vehicleAssignment.vehicleIdentifier) &&
        Objects.equals(this.assignedOrders, vehicleAssignment.assignedOrders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleIdentifier, assignedOrders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleAssignment {\n");
    sb.append("    vehicleIdentifier: ").append(toIndentedString(vehicleIdentifier)).append("\n");
    sb.append("    assignedOrders: ").append(toIndentedString(assignedOrders)).append("\n");
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


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
 * AssignmentSummaryResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class AssignmentSummaryResponse {

  private Integer assignmentsCreated;

  private Integer vehiclesUtilized;

  private String message;

  public AssignmentSummaryResponse assignmentsCreated(Integer assignmentsCreated) {
    this.assignmentsCreated = assignmentsCreated;
    return this;
  }

  /**
   * Number of new order assignments made in this run.
   * @return assignmentsCreated
   */
  
  @Schema(name = "assignmentsCreated", example = "15", description = "Number of new order assignments made in this run.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assignmentsCreated")
  public Integer getAssignmentsCreated() {
    return assignmentsCreated;
  }

  public void setAssignmentsCreated(Integer assignmentsCreated) {
    this.assignmentsCreated = assignmentsCreated;
  }

  public AssignmentSummaryResponse vehiclesUtilized(Integer vehiclesUtilized) {
    this.vehiclesUtilized = vehiclesUtilized;
    return this;
  }

  /**
   * Number of distinct vehicles assigned orders in this run.
   * @return vehiclesUtilized
   */
  
  @Schema(name = "vehiclesUtilized", example = "3", description = "Number of distinct vehicles assigned orders in this run.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("vehiclesUtilized")
  public Integer getVehiclesUtilized() {
    return vehiclesUtilized;
  }

  public void setVehiclesUtilized(Integer vehiclesUtilized) {
    this.vehiclesUtilized = vehiclesUtilized;
  }

  public AssignmentSummaryResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Optional status message.
   * @return message
   */
  
  @Schema(name = "message", example = "Assignment process completed.", description = "Optional status message.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssignmentSummaryResponse assignmentSummaryResponse = (AssignmentSummaryResponse) o;
    return Objects.equals(this.assignmentsCreated, assignmentSummaryResponse.assignmentsCreated) &&
        Objects.equals(this.vehiclesUtilized, assignmentSummaryResponse.vehiclesUtilized) &&
        Objects.equals(this.message, assignmentSummaryResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignmentsCreated, vehiclesUtilized, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssignmentSummaryResponse {\n");
    sb.append("    assignmentsCreated: ").append(toIndentedString(assignmentsCreated)).append("\n");
    sb.append("    vehiclesUtilized: ").append(toIndentedString(vehiclesUtilized)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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


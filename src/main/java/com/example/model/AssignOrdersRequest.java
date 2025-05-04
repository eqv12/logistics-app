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
 * AssignOrdersRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class AssignOrdersRequest {

  private Float maxDistanceKm;

  public AssignOrdersRequest maxDistanceKm(Float maxDistanceKm) {
    this.maxDistanceKm = maxDistanceKm;
    return this;
  }

  /**
   * Optional maximum distance constraint for assignments.
   * @return maxDistanceKm
   */
  
  @Schema(name = "maxDistanceKm", example = "15.0", description = "Optional maximum distance constraint for assignments.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxDistanceKm")
  public Float getMaxDistanceKm() {
    return maxDistanceKm;
  }

  public void setMaxDistanceKm(Float maxDistanceKm) {
    this.maxDistanceKm = maxDistanceKm;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssignOrdersRequest assignOrdersRequest = (AssignOrdersRequest) o;
    return Objects.equals(this.maxDistanceKm, assignOrdersRequest.maxDistanceKm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxDistanceKm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssignOrdersRequest {\n");
    sb.append("    maxDistanceKm: ").append(toIndentedString(maxDistanceKm)).append("\n");
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


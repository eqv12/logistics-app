package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.PaginationMetadata;
import com.example.model.VehicleAssignment;
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
 * PaginatedVehicleAssignmentResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class PaginatedVehicleAssignmentResponse {

  private PaginationMetadata metadata;

  @Valid
  private List<@Valid VehicleAssignment> data = new ArrayList<>();

  public PaginatedVehicleAssignmentResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaginatedVehicleAssignmentResponse(PaginationMetadata metadata, List<@Valid VehicleAssignment> data) {
    this.metadata = metadata;
    this.data = data;
  }

  public PaginatedVehicleAssignmentResponse metadata(PaginationMetadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   */
  @NotNull @Valid 
  @Schema(name = "metadata", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("metadata")
  public PaginationMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(PaginationMetadata metadata) {
    this.metadata = metadata;
  }

  public PaginatedVehicleAssignmentResponse data(List<@Valid VehicleAssignment> data) {
    this.data = data;
    return this;
  }

  public PaginatedVehicleAssignmentResponse addDataItem(VehicleAssignment dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public List<@Valid VehicleAssignment> getData() {
    return data;
  }

  public void setData(List<@Valid VehicleAssignment> data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginatedVehicleAssignmentResponse paginatedVehicleAssignmentResponse = (PaginatedVehicleAssignmentResponse) o;
    return Objects.equals(this.metadata, paginatedVehicleAssignmentResponse.metadata) &&
        Objects.equals(this.data, paginatedVehicleAssignmentResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginatedVehicleAssignmentResponse {\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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


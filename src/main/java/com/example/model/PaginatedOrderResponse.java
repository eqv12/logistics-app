package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.OrderResponse;
import com.example.model.PaginationMetadata;
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
 * PaginatedOrderResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class PaginatedOrderResponse {

  private PaginationMetadata metadata;

  @Valid
  private List<@Valid OrderResponse> data = new ArrayList<>();

  public PaginatedOrderResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaginatedOrderResponse(PaginationMetadata metadata, List<@Valid OrderResponse> data) {
    this.metadata = metadata;
    this.data = data;
  }

  public PaginatedOrderResponse metadata(PaginationMetadata metadata) {
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

  public PaginatedOrderResponse data(List<@Valid OrderResponse> data) {
    this.data = data;
    return this;
  }

  public PaginatedOrderResponse addDataItem(OrderResponse dataItem) {
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
  public List<@Valid OrderResponse> getData() {
    return data;
  }

  public void setData(List<@Valid OrderResponse> data) {
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
    PaginatedOrderResponse paginatedOrderResponse = (PaginatedOrderResponse) o;
    return Objects.equals(this.metadata, paginatedOrderResponse.metadata) &&
        Objects.equals(this.data, paginatedOrderResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginatedOrderResponse {\n");
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


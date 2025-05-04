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
 * PaginationMetadata
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class PaginationMetadata {

  private Integer totalItems;

  private Integer limit;

  private Integer offset;

  public PaginationMetadata() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaginationMetadata(Integer totalItems, Integer limit, Integer offset) {
    this.totalItems = totalItems;
    this.limit = limit;
    this.offset = offset;
  }

  public PaginationMetadata totalItems(Integer totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  /**
   * Total number of items available matching the query.
   * @return totalItems
   */
  @NotNull 
  @Schema(name = "totalItems", example = "153", description = "Total number of items available matching the query.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalItems")
  public Integer getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(Integer totalItems) {
    this.totalItems = totalItems;
  }

  public PaginationMetadata limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * The limit parameter used for this page.
   * @return limit
   */
  @NotNull 
  @Schema(name = "limit", example = "20", description = "The limit parameter used for this page.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public PaginationMetadata offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * The offset parameter used for this page.
   * @return offset
   */
  @NotNull 
  @Schema(name = "offset", example = "40", description = "The offset parameter used for this page.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offset")
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationMetadata paginationMetadata = (PaginationMetadata) o;
    return Objects.equals(this.totalItems, paginationMetadata.totalItems) &&
        Objects.equals(this.limit, paginationMetadata.limit) &&
        Objects.equals(this.offset, paginationMetadata.offset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalItems, limit, offset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationMetadata {\n");
    sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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


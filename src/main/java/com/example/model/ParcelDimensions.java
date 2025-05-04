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
 * ParcelDimensions
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class ParcelDimensions {

  private Float length;

  private Float width;

  private Float height;

  public ParcelDimensions() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ParcelDimensions(Float length, Float width, Float height) {
    this.length = length;
    this.width = width;
    this.height = height;
  }

  public ParcelDimensions length(Float length) {
    this.length = length;
    return this;
  }

  /**
   * Length of the parcel in centimeters (cm).
   * @return length
   */
  @NotNull 
  @Schema(name = "length", example = "30.5", description = "Length of the parcel in centimeters (cm).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("length")
  public Float getLength() {
    return length;
  }

  public void setLength(Float length) {
    this.length = length;
  }

  public ParcelDimensions width(Float width) {
    this.width = width;
    return this;
  }

  /**
   * Width of the parcel in centimeters (cm).
   * @return width
   */
  @NotNull 
  @Schema(name = "width", example = "20.0", description = "Width of the parcel in centimeters (cm).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("width")
  public Float getWidth() {
    return width;
  }

  public void setWidth(Float width) {
    this.width = width;
  }

  public ParcelDimensions height(Float height) {
    this.height = height;
    return this;
  }

  /**
   * Height of the parcel in centimeters (cm).
   * @return height
   */
  @NotNull 
  @Schema(name = "height", example = "15.0", description = "Height of the parcel in centimeters (cm).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("height")
  public Float getHeight() {
    return height;
  }

  public void setHeight(Float height) {
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParcelDimensions parcelDimensions = (ParcelDimensions) o;
    return Objects.equals(this.length, parcelDimensions.length) &&
        Objects.equals(this.width, parcelDimensions.width) &&
        Objects.equals(this.height, parcelDimensions.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(length, width, height);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParcelDimensions {\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
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


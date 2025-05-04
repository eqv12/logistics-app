package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.ParcelDimensions;
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
 * ParcelDetails
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class ParcelDetails {

  private Float weight;

  private ParcelDimensions dimensions;

  private Float volume;

  public ParcelDetails() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ParcelDetails(Float weight, ParcelDimensions dimensions) {
    this.weight = weight;
    this.dimensions = dimensions;
  }

  public ParcelDetails weight(Float weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Weight of the parcel in kilograms (kg).
   * minimum: 0
   * @return weight
   */
  @NotNull @DecimalMin("0") 
  @Schema(name = "weight", example = "4.5", description = "Weight of the parcel in kilograms (kg).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("weight")
  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public ParcelDetails dimensions(ParcelDimensions dimensions) {
    this.dimensions = dimensions;
    return this;
  }

  /**
   * Get dimensions
   * @return dimensions
   */
  @NotNull @Valid 
  @Schema(name = "dimensions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dimensions")
  public ParcelDimensions getDimensions() {
    return dimensions;
  }

  public void setDimensions(ParcelDimensions dimensions) {
    this.dimensions = dimensions;
  }

  public ParcelDetails volume(Float volume) {
    this.volume = volume;
    return this;
  }

  /**
   * Calculated volume of the parcel in cubic meters (m^3). Read-only.
   * @return volume
   */
  
  @Schema(name = "volume", accessMode = Schema.AccessMode.READ_ONLY, example = "0.00915", description = "Calculated volume of the parcel in cubic meters (m^3). Read-only.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("volume")
  public Float getVolume() {
    return volume;
  }

  public void setVolume(Float volume) {
    this.volume = volume;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParcelDetails parcelDetails = (ParcelDetails) o;
    return Objects.equals(this.weight, parcelDetails.weight) &&
        Objects.equals(this.dimensions, parcelDetails.dimensions) &&
        Objects.equals(this.volume, parcelDetails.volume);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, dimensions, volume);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParcelDetails {\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    dimensions: ").append(toIndentedString(dimensions)).append("\n");
    sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
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


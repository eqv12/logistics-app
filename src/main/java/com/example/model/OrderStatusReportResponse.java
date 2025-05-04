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
 * OrderStatusReportResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class OrderStatusReportResponse {

  private Integer totalOrders;

  private Integer pendingOrders;

  private Integer outForDeliveryOrders;

  private Integer inProgressOrders;

  private Integer deliveredOrders;

  private Integer failedOrders;

  private Integer cancelledOrders;

  public OrderStatusReportResponse totalOrders(Integer totalOrders) {
    this.totalOrders = totalOrders;
    return this;
  }

  /**
   * Total number of orders considered in the report (e.g., within a time range if filters added).
   * @return totalOrders
   */
  
  @Schema(name = "totalOrders", description = "Total number of orders considered in the report (e.g., within a time range if filters added).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalOrders")
  public Integer getTotalOrders() {
    return totalOrders;
  }

  public void setTotalOrders(Integer totalOrders) {
    this.totalOrders = totalOrders;
  }

  public OrderStatusReportResponse pendingOrders(Integer pendingOrders) {
    this.pendingOrders = pendingOrders;
    return this;
  }

  /**
   * Get pendingOrders
   * @return pendingOrders
   */
  
  @Schema(name = "pendingOrders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pendingOrders")
  public Integer getPendingOrders() {
    return pendingOrders;
  }

  public void setPendingOrders(Integer pendingOrders) {
    this.pendingOrders = pendingOrders;
  }

  public OrderStatusReportResponse outForDeliveryOrders(Integer outForDeliveryOrders) {
    this.outForDeliveryOrders = outForDeliveryOrders;
    return this;
  }

  /**
   * Get outForDeliveryOrders
   * @return outForDeliveryOrders
   */
  
  @Schema(name = "outForDeliveryOrders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("outForDeliveryOrders")
  public Integer getOutForDeliveryOrders() {
    return outForDeliveryOrders;
  }

  public void setOutForDeliveryOrders(Integer outForDeliveryOrders) {
    this.outForDeliveryOrders = outForDeliveryOrders;
  }

  public OrderStatusReportResponse inProgressOrders(Integer inProgressOrders) {
    this.inProgressOrders = inProgressOrders;
    return this;
  }

  /**
   * Get inProgressOrders
   * @return inProgressOrders
   */
  
  @Schema(name = "inProgressOrders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("inProgressOrders")
  public Integer getInProgressOrders() {
    return inProgressOrders;
  }

  public void setInProgressOrders(Integer inProgressOrders) {
    this.inProgressOrders = inProgressOrders;
  }

  public OrderStatusReportResponse deliveredOrders(Integer deliveredOrders) {
    this.deliveredOrders = deliveredOrders;
    return this;
  }

  /**
   * Get deliveredOrders
   * @return deliveredOrders
   */
  
  @Schema(name = "deliveredOrders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deliveredOrders")
  public Integer getDeliveredOrders() {
    return deliveredOrders;
  }

  public void setDeliveredOrders(Integer deliveredOrders) {
    this.deliveredOrders = deliveredOrders;
  }

  public OrderStatusReportResponse failedOrders(Integer failedOrders) {
    this.failedOrders = failedOrders;
    return this;
  }

  /**
   * Get failedOrders
   * @return failedOrders
   */
  
  @Schema(name = "failedOrders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("failedOrders")
  public Integer getFailedOrders() {
    return failedOrders;
  }

  public void setFailedOrders(Integer failedOrders) {
    this.failedOrders = failedOrders;
  }

  public OrderStatusReportResponse cancelledOrders(Integer cancelledOrders) {
    this.cancelledOrders = cancelledOrders;
    return this;
  }

  /**
   * Get cancelledOrders
   * @return cancelledOrders
   */
  
  @Schema(name = "cancelledOrders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cancelledOrders")
  public Integer getCancelledOrders() {
    return cancelledOrders;
  }

  public void setCancelledOrders(Integer cancelledOrders) {
    this.cancelledOrders = cancelledOrders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderStatusReportResponse orderStatusReportResponse = (OrderStatusReportResponse) o;
    return Objects.equals(this.totalOrders, orderStatusReportResponse.totalOrders) &&
        Objects.equals(this.pendingOrders, orderStatusReportResponse.pendingOrders) &&
        Objects.equals(this.outForDeliveryOrders, orderStatusReportResponse.outForDeliveryOrders) &&
        Objects.equals(this.inProgressOrders, orderStatusReportResponse.inProgressOrders) &&
        Objects.equals(this.deliveredOrders, orderStatusReportResponse.deliveredOrders) &&
        Objects.equals(this.failedOrders, orderStatusReportResponse.failedOrders) &&
        Objects.equals(this.cancelledOrders, orderStatusReportResponse.cancelledOrders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalOrders, pendingOrders, outForDeliveryOrders, inProgressOrders, deliveredOrders, failedOrders, cancelledOrders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderStatusReportResponse {\n");
    sb.append("    totalOrders: ").append(toIndentedString(totalOrders)).append("\n");
    sb.append("    pendingOrders: ").append(toIndentedString(pendingOrders)).append("\n");
    sb.append("    outForDeliveryOrders: ").append(toIndentedString(outForDeliveryOrders)).append("\n");
    sb.append("    inProgressOrders: ").append(toIndentedString(inProgressOrders)).append("\n");
    sb.append("    deliveredOrders: ").append(toIndentedString(deliveredOrders)).append("\n");
    sb.append("    failedOrders: ").append(toIndentedString(failedOrders)).append("\n");
    sb.append("    cancelledOrders: ").append(toIndentedString(cancelledOrders)).append("\n");
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


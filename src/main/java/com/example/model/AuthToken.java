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
 * AuthToken
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:16:19.844067600+05:30[Asia/Calcutta]", comments = "Generator version: 7.9.0")
public class AuthToken {

  private String token;

  private Integer expiresIn;

  private String tokenType = "Bearer";

  public AuthToken() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AuthToken(String token, Integer expiresIn, String tokenType) {
    this.token = token;
    this.expiresIn = expiresIn;
    this.tokenType = tokenType;
  }

  public AuthToken token(String token) {
    this.token = token;
    return this;
  }

  /**
   * JWT authentication token.
   * @return token
   */
  @NotNull 
  @Schema(name = "token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...", description = "JWT authentication token.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public AuthToken expiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

  /**
   * Token expiry time in seconds from issue time.
   * @return expiresIn
   */
  @NotNull 
  @Schema(name = "expiresIn", example = "3600", description = "Token expiry time in seconds from issue time.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("expiresIn")
  public Integer getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }

  public AuthToken tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Token type.
   * @return tokenType
   */
  @NotNull 
  @Schema(name = "tokenType", example = "Bearer", description = "Token type.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tokenType")
  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthToken authToken = (AuthToken) o;
    return Objects.equals(this.token, authToken.token) &&
        Objects.equals(this.expiresIn, authToken.expiresIn) &&
        Objects.equals(this.tokenType, authToken.tokenType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, expiresIn, tokenType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthToken {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
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


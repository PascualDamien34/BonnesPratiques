/*
 * Mines - address app
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Address
 */
@JsonPropertyOrder({
  Address.JSON_PROPERTY_NUMBER,
  Address.JSON_PROPERTY_STREET
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-04-15T11:54:28.117022606+02:00[Europe/Paris]")
public class Address {
  public static final String JSON_PROPERTY_NUMBER = "number";
  private Long number;

  public static final String JSON_PROPERTY_STREET = "street";
  private String street;

  public Address() { 
  }

  public Address number(Long number) {
    this.number = number;
    return this;
  }

   /**
   * Get number
   * @return number
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNumber() {
    return number;
  }


  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumber(Long number) {
    this.number = number;
  }


  public Address street(String street) {
    this.street = street;
    return this;
  }

   /**
   * Get street
   * @return street
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStreet() {
    return street;
  }


  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStreet(String street) {
    this.street = street;
  }


  /**
   * Return true if this Address object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.number, address.number) &&
        Objects.equals(this.street, address.street);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, street);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
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

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `number` to the URL query string
    if (getNumber() != null) {
      joiner.add(String.format("%snumber%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNumber()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `street` to the URL query string
    if (getStreet() != null) {
      joiner.add(String.format("%sstreet%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStreet()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}


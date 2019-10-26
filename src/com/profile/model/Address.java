package com.profile.model;

import javax.validation.constraints.*;

public class Address {
  @NotEmpty
  private long id;
  @NotEmpty
  private String streetAddress;
  @NotEmpty
  @Pattern(regexp = "\\d{5}")
  private String zipCode;
  @NotEmpty
  private String city;
  @NotEmpty
  @Pattern(regexp = "[A-Z] {2}")
  private String state;
  
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getStreetAddress() {
    return streetAddress;
  }
  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  
  
}

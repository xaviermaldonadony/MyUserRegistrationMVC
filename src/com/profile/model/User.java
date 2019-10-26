package com.profile.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

public class User {
    @NotEmpty
    private long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;
    
    @Past(message = "Date of Birth can not be in future")
    private Date dateofBirth;
    @CreationTimestamp
    private Date memberSince;
    @Valid
    @NotNull
    private Address address;
    @Pattern(regexp = "\\d{10}")
    @NotEmpty
    private String phone;
    
    
    public long getId() {
      return id;
    }
    public void setId(long id) {
      this.id = id;
    }
    public String getFirstName() {
      return firstName;
    }
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
    public String getLastName() {
      return lastName;
    }
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public Date getDateofBirth() {
      return dateofBirth;
    }
    public void setDateofBirth(Date dateofBirth) {
      this.dateofBirth = dateofBirth;
    }
    public Date getMemberSince() {
      return memberSince;
    }
    public void setMemeberSince(Date memberSince) {
      this.memberSince = memberSince;
    }
    public Address getAddress() {
      return address;
    }
    public void setAddress(Address address) {
      this.address = address;
    }
    public String getPhone() {
      return phone;
    }
    public void setPhone(String phone) {
      this.phone = phone;
    }
    
    
}

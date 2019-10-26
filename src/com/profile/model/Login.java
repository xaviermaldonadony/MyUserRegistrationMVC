package com.profile.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Login {

  private static long count = 0;
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotEmpty(message="required, cant be empty")
	@Column(name = "FULL_NAME")
	private String name;
	
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column(name = "USER_PASSWORD")

	private String password;
	
	@Valid
//	@NotNull
	private String user;
	
//	@Past
//	@NotEmpty
//	private Date dateofBirth;

	public Login() {
		// TODO Auto-generated constructor stub
	}

//	public Login(String name, String email, String password, Date dateOfBirth) {
//		this.id = count++;
//	  this.name = name;
//	  this.email = email;
//		this.password = password;
////		this.dateofBirth = dateOfBirth;
//	}
	
	 public Login(String name, String email, String password) {
	    this.id = count++;
	    this.name = name;
	    this.email = email;
	    this.password = password;
	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
	  this.email = email;
	}
	
	public String getEmail() {
	  return email;
	}
	
	public void setId() {
	  this.id = count++;
	}
	
	public long getId() {
	  return id;
	}
	 public String getUser() {
	    return user;
	  }

	  public void setUser(String user) {
	    this.user = user;
	  }

//	  public void setDateOfBirth(Date dateOfBirth) {
//	    this.dateofBirth = dateOfBirth;
//	  }
//	  
//	  public Date getDateOfBirth(){
//	    return this.dateofBirth;
//	  }
  @Override
  public String toString() {
    return "Login [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", user=" + user
        + "]";
  }
	

}

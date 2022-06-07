package com.sportyshoes.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User 
{
 
  @Id
  @GeneratedValue
  @Column(name="user_id")
  private int id; 
  
  @Column(name="user_fname")
  private String fname; 
  
  @Column(name="user_lname")
  private String lname;
  
  @Column(name="user_number")
  private double number;
  
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  @Column(name="user_dob")
  private Date  dob;
  
  @Column(name="user_username")
  private String username;
  
  @Column(name="user_password")
  private String password;
  
  
  
  public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public double getNumber() {
	return number;
}
public void setNumber(double number) {
	this.number = number;
}

public void setDob(Date dob) {
	this.dob = dob;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}

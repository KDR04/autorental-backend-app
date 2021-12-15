package com.autorentalapp.models;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5514101677350063911L;
	
	
	private String firstname;
	private String lastname;
	private String email;
	private String drivinglicense;
	private String password;
	private int id;
	private int age;
	private String phonenumber;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDrivinglicense() {
		return drivinglicense;
	}
	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [first name=" + firstname + ", last name=" + lastname  + ", Email=" + email  + ", password=" + password + ", "
				+ "Phone number" + phonenumber  + ", Age=" + age  + ", Driving license=" + drivinglicense  + ", id=" + id + "]";
	}
	
	
	

}

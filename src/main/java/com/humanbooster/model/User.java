package com.humanbooster.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {

	private int user_id;
	private String login;
	private String password;
	private boolean isAdmin;
	private String profilePicture;
	private String firstName;
	private String lastName;
	private Date hireDate;
	private String phoneNumber;
	
	// ------------------------------------
	// Constructeur avec ID
	// ------------------------------------
	
	public User(int user_id, String login, String password, boolean isAdmin, String profilePicture, String firstName,
			String lastName, Date hireDate, String phoneNumber) {
		super();
		this.user_id = user_id;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
		this.profilePicture = profilePicture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.phoneNumber = phoneNumber;
	}

	
	// ------------------------------------
	// Constructeur sans ID
	// ------------------------------------
	
	public User(String login, String password, boolean isAdmin, String profilePicture, String firstName,
			String lastName, Date hireDate, String phoneNumber) {
		super();
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
		this.profilePicture = profilePicture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.phoneNumber = phoneNumber;
	}
	
	// ------------------------------------
	// Constructeur check login
	// ------------------------------------
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}


	
	// ------------------------------------
	// Constructeur vide
	// ------------------------------------
	
	public User() {
	}
	
	// ------------------------------------
	// Getters / Setters
	// ------------------------------------
	
	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
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


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}



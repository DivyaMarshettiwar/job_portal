package com.niit.bean;

public class Member {

	private String username, password, email, contact, gender;
	
	public Member() {
		super();
	}

	public Member(String username, String password, String email, String contact, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
}

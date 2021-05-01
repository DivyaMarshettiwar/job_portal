package com.niit.project_bean;

public class Jobseeker {
	
	private String username, password, email_id, contact_no, gender;

	public Jobseeker() {
		super();
	}

	public Jobseeker(String username, String password, String email_id, String contact_no, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.email_id = email_id;
		this.contact_no = contact_no;
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
		return email_id;
	}

	public void setEmail(String email) {
		this.email_id = email_id;
	}

	public String getContact() {
		return contact_no;
	}

	public void setContact(String contact) {
		this.contact_no = contact_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

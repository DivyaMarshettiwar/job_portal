package com.niit.project_bean;

public class Recruiter {
	
	private String username, password, company_name, email_id, contact_no;

	public Recruiter() {
		super();
	}

	public Recruiter(String username, String password, String company_name, String email_id, String contact_no) {
		super();
		this.username = username;
		this.password = password;
		this.company_name = company_name;
		this.email_id = email_id;
		this.contact_no = contact_no;
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

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	
}

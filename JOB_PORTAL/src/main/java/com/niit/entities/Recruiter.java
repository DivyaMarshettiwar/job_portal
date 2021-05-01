package com.niit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recruiterId;
	private String recruiterName;
	private String recuiterPassword;
	private String recuiterEmail;
	private String recuiterContact;
	private String recuiterCompanyName;
	
	//no parameter constructor
	public Recruiter() {
		super();
	}

	
	//constructor without id
	public Recruiter(String recruiterName, String recuiterPassword, String recuiterEmail, String recuiterContact,
			String recuiterCompanyName) {
		super();
		this.recruiterName = recruiterName;
		this.recuiterPassword = recuiterPassword;
		this.recuiterEmail = recuiterEmail;
		this.recuiterContact = recuiterContact;
		this.recuiterCompanyName = recuiterCompanyName;
	}

	
	//constructor of all attributes
	public Recruiter(int recruiterId, String recruiterName, String recuiterPassword, String recuiterEmail,
			String recuiterContact, String recuiterCompanyName) {
		super();
		this.recruiterId = recruiterId;
		this.recruiterName = recruiterName;
		this.recuiterPassword = recuiterPassword;
		this.recuiterEmail = recuiterEmail;
		this.recuiterContact = recuiterContact;
		this.recuiterCompanyName = recuiterCompanyName;
	}

	
	//getter and setter 
	public int getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getRecuiterPassword() {
		return recuiterPassword;
	}

	public void setRecuiterPassword(String recuiterPassword) {
		this.recuiterPassword = recuiterPassword;
	}

	public String getRecuiterEmail() {
		return recuiterEmail;
	}

	public void setRecuiterEmail(String recuiterEmail) {
		this.recuiterEmail = recuiterEmail;
	}

	public String getRecuiterContact() {
		return recuiterContact;
	}

	public void setRecuiterContact(String recuiterContact) {
		this.recuiterContact = recuiterContact;
	}

	public String getRecuiterCompanyName() {
		return recuiterCompanyName;
	}

	public void setRecuiterCompanyName(String recuiterCompanyName) {
		this.recuiterCompanyName = recuiterCompanyName;
	}

	//toString 
	@Override
	public String toString() {
		return "Recruiter [recruiterId=" + recruiterId + ", recruiterName=" + recruiterName + ", recuiterPassword="
				+ recuiterPassword + ", recuiterEmail=" + recuiterEmail + ", recuiterContact=" + recuiterContact
				+ ", recuiterCompanyName=" + recuiterCompanyName + "]";
	}
	
	
	
	
	
	

}

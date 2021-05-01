package com.niit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jobseeker implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobseekerId;
	private String jobseekerName;
	private String jobseekerPassword;
	private String jobseekerEmail;
	private String jobseekerContact;
	private String jobseekerGender;
	
	
	
	//constructor with no parameter
	public Jobseeker() {
		super();
	}


	//constructor without id
	public Jobseeker(String jobseekerName, String jobseekerPassword, String jobseekerEmail, String jobseekerContact,
			String jobseekerGender) {
		super();
		this.jobseekerName = jobseekerName;
		this.jobseekerPassword = jobseekerPassword;
		this.jobseekerEmail = jobseekerEmail;
		this.jobseekerContact = jobseekerContact;
		this.jobseekerGender = jobseekerGender;
	}

	//constructor with all parameters
	public Jobseeker(int jobseekerId, String jobseekerName, String jobseekerPassword, String jobseekerEmail,
			String jobseekerContact, String jobseekerGender) {
		super();
		this.jobseekerId = jobseekerId;
		this.jobseekerName = jobseekerName;
		this.jobseekerPassword = jobseekerPassword;
		this.jobseekerEmail = jobseekerEmail;
		this.jobseekerContact = jobseekerContact;
		this.jobseekerGender = jobseekerGender;
	}


	
	//getter and setter
	public int getJobseekerId() {
		return jobseekerId;
	}


	public void setJobseekerId(int jobseekerId) {
		this.jobseekerId = jobseekerId;
	}


	public String getJobseekerName() {
		return jobseekerName;
	}


	public void setJobseekerName(String jobseekerName) {
		this.jobseekerName = jobseekerName;
	}


	public String getJobseekerPassword() {
		return jobseekerPassword;
	}


	public void setJobseekerPassword(String jobseekerPassword) {
		this.jobseekerPassword = jobseekerPassword;
	}


	public String getJobseekerEmail() {
		return jobseekerEmail;
	}


	public void setJobseekerEmail(String jobseekerEmail) {
		this.jobseekerEmail = jobseekerEmail;
	}


	public String getJobseekerContact() {
		return jobseekerContact;
	}


	public void setJobseekerContact(String jobseekerContact) {
		this.jobseekerContact = jobseekerContact;
	}


	public String getJobseekerGender() {
		return jobseekerGender;
	}


	public void setJobseekerGender(String jobseekerGender) {
		this.jobseekerGender = jobseekerGender;
	}


	//toString method
	@Override
	public String toString() {
		return "Jobseeker [jobseekerId=" + jobseekerId + ", jobseekerName=" + jobseekerName + ", jobseekerPassword="
				+ jobseekerPassword + ", jobseekerEmail=" + jobseekerEmail + ", jobseekerContact=" + jobseekerContact
				+ ", jobseekerGender=" + jobseekerGender + "]";
	}
	
	

}

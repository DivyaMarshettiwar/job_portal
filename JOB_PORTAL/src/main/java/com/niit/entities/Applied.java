package com.niit.entities;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.connection.FactoryProvider;
import com.niit.dao.JobseekerDao;

public class Applied {
	
	private SessionFactory factory;

	public Applied(SessionFactory factory) {
		super();
		this.factory = factory;
	}



	public JobseekerDao getDetails() {
		JobseekerDao jobseekerdao = new JobseekerDao(FactoryProvider.getFactory());
		jobseekerdao.getAllJobseekerlist();
	
			
		return jobseekerdao;
	}
}

package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.niit.entities.JobDescription;

public class JobsDao {

	private SessionFactory factory;

	public JobsDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveJob(JobDescription jobs) {
		boolean status = false;
		
		try {
			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(jobs);
			
			tx.commit();
			session.close();
			
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	//get all jobs
	public List<JobDescription> getAllJobs(){
		Session session = this.factory.openSession();
		Query query = session.createQuery("from JobDescription");
		List<JobDescription> list = query.list();
		
		return list;
	}
}

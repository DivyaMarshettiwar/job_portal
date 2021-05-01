package com.niit.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.entities.JobDescription;
import com.niit.entities.Jobseeker;

public class JobseekerDao {
	
	private SessionFactory factory;

	public JobseekerDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	//get jobseeker by email and password

	public Jobseeker getEmailAndPassword(String email, String password) {
		Jobseeker jobseeker = null;
		
		
		try {
			
			String query="from Jobseeker where jobseekerEmail =: e and jobseekerPassword=: p";
            Session session = this.factory.openSession();
            Query q = session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p",password);
            
            System.out.println(email);         
            System.out.println(password);
            
            jobseeker=(Jobseeker)q.uniqueResult();
            System.out.println(jobseeker);
            session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return jobseeker;
		/*
		 * Query query = session.createQuery( hql ); query.setParameter("login", login);
		 * query.setParameter("password", password); aUser =
		 * (UserAccount)query.list().get(0);
		 */
	}
	
	//get all jobseeker list
	public List<Jobseeker> getAllJobseekerlist(){
		Session session = this.factory.openSession();
		Query query = session.createQuery("from Jobseeker");
		List<Jobseeker> jobseekerlist = query.list();
		
		return jobseekerlist;
	}
	
	//by using another method
	/*
	public boolean validate(String jobseekerEmail, String jobseekerPassword) {
		
		Transaction tx = null;
		Jobseeker jobseeker = null;
		
		try {
			Session session = this.factory.openSession();
			tx = session.beginTransaction();
			jobseeker = (Jobseeker)session.createQuery("from Jobseeker j where j.jobseekerEmail=:e").setParameter("e", jobseekerEmail).uniqueResult();
			
			if(jobseeker!=null && jobseeker.getJobseekerPassword().equals(jobseekerPassword))
			{
				System.out.println(jobseeker.getJobseekerPassword());
				return true;
			}
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		return false;
	}
	*/
}	
	
	

	
	
	
	/*
	 * String query =
	 * " from jobseeker where jobseekerEmail =: e and jobseekerPassword =: p";
	 * Session session = this.factory.openSession(); Query q =
	 * session.createQuery(query); String email = q.setParameter("e",
	 * j_email).toString(); System.out.println(email); String password =
	 * q.setParameter("p", j_password).toString(); System.out.println(password);
	 * 
	 * q.uniqueResult();
	 * 
	 * 
	 * 
	 * //this will validate the email and password and return true or false
	 * accordingly if(j_email.equals(email) && j_password.equals(password)) { status
	 * = true; } else { status = false; }
	 * 
	 * 
	 * session.close();
	 */
	


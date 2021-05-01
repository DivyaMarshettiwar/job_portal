package com.niit.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.entities.Recruiter;

public class RecruiterDao {

	private SessionFactory factory;

	public RecruiterDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public Recruiter authenticate(String email, String password) {
		
		Recruiter recruiter = null;;
		
		try {
			
			String query = "from Recruiter where recuiterEmail =: e and recuiterPassword =: p";
			Session session = this.factory.openSession();
			Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			recruiter = (Recruiter)q.uniqueResult();
			
			session.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return recruiter;
	}
}

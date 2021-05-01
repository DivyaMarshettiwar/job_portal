package com.niit.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.connection.FactoryProvider;
import com.niit.entities.Jobseeker;

//mapping is done through xml file in WEB-INF
public class JobseekerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JobseekerRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			// fetching the data from the jobseeker register form
			String jobseekerName = request.getParameter("username");
			String jobseekerEmail = request.getParameter("email");
			String jobseekerPassword = request.getParameter("password");
			String jobseekerContact = request.getParameter("contact");
			String jobseekerGender = request.getParameter("gender");

			// creating object of Jobseeker entity class and passing the details
			Jobseeker jobseeker = new Jobseeker(jobseekerName, jobseekerPassword, jobseekerEmail, jobseekerContact,	jobseekerGender);
			
			//creating hibernate session
			Session hibernatesession = FactoryProvider.getFactory().openSession();
			Transaction transaction = (Transaction) hibernatesession.beginTransaction();
			
			int userId = (Integer) hibernatesession.save(jobseeker);
			
			transaction.commit();
			hibernatesession.close();
			

			//this will hold the message 
			HttpSession session = request.getSession();
			session.setAttribute("messsage", "Registration Successful !!!");
			response.sendRedirect("jobseekerRegister.jsp");
			
			//return because it should not execute after this
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}

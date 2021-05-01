package com.niit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.niit.connection.FactoryProvider;
import com.niit.entities.Jobseeker;

@WebServlet("/JobseekerRegisterController")
public class JobseekerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JobseekerRegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			PrintWriter out = response.getWriter();
			out.println("data saved successfully !!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

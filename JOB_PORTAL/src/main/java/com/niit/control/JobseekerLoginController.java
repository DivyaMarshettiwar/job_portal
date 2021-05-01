package com.niit.control;

import com.niit.entities.Jobseeker;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.connection.FactoryProvider;
import com.niit.dao.JobseekerDao;

public class JobseekerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JobseekerLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// authentication
			JobseekerDao jobseekerdao = new JobseekerDao(FactoryProvider.getFactory());
			
			/*
			boolean status=jobseekerdao.validate(email, password);
			System.out.println(status);
			if (status == false) {
				out.println("<h1> Invalid details </h1>");
			} else {
				out.println("<h1>Welcome " + jobseeker.getJobseekerName() + " </h1>");
			}
			*/
			
			
		    Jobseeker jobseeker = jobseekerdao.getEmailAndPassword(email, password);
			System.out.println(jobseeker);
			/*
			 * boolean status = jobseekerdao.getEmailAndPassword(email, password);
			 * System.out.println(status);
			 */

			

			// if the email and password does not match it will return null and if it
			// matches then prints welcome message
			
			HttpSession httpSession = request.getSession();
			if (jobseeker == null) {
				httpSession.setAttribute("message", "Invalid details, try with another one !!!");
				response.sendRedirect("jobseekerLogin.jsp");
			} else {
				httpSession.setAttribute("current-user", jobseeker);
				response.sendRedirect("jobseekerPage.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

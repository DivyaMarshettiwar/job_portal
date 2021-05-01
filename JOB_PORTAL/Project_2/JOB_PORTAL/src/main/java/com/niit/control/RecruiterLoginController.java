package com.niit.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.connection.FactoryProvider;
import com.niit.dao.JobseekerDao;
import com.niit.dao.RecruiterDao;
import com.niit.entities.Jobseeker;
import com.niit.entities.Recruiter;

public class RecruiterLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecruiterLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// authentication
			RecruiterDao recruiterdao = new RecruiterDao(FactoryProvider.getFactory());
						
		    Recruiter recruiter = recruiterdao.authenticate(email, password);
			System.out.println(recruiter);
			
			

			// if the email and password does not match it will return null and if it
			// matches then prints welcome message
			
			HttpSession httpSession = request.getSession();
			if (recruiter == null) {
				httpSession.setAttribute("message", "Invalid details, try with another one !!!");
				response.sendRedirect("recruiterLogin.jsp");
			} else {
				httpSession.setAttribute("current-admin", recruiter);
				response.sendRedirect("recruiterPage.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

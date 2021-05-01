package com.niit.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.connection.FactoryProvider;
import com.niit.entities.Recruiter;


public class RecruiterRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RecruiterRegisterController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// this will fetch the data from recruiterRegisterr.jsp page
			String recruiterName = request.getParameter("username");
			String recuiterPassword = request.getParameter("password");
			String recuiterEmail = request.getParameter("email");
			String recuiterContact = request.getParameter("contact");
			String recuiterCompanyName = request.getParameter("companyName");

			// creating object of Recruiter entity class and passing the details
			Recruiter recruiter = new Recruiter(recruiterName, recuiterPassword, recuiterEmail, recuiterContact,
					recuiterCompanyName);

			// creating hibernate session
			Session hibernatesession = FactoryProvider.getFactory().openSession();
			Transaction transaction = (Transaction) hibernatesession.beginTransaction();

			int recruiterId = (Integer) hibernatesession.save(recruiter);

			transaction.commit();
			hibernatesession.close();

			// this will hold the message
			HttpSession session = request.getSession();
			session.setAttribute("messsage", "Registration Successful !!!");
			response.sendRedirect("recruiterRegister.jsp");

			// return because it should not execute after this
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

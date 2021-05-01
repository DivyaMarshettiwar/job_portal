package com.niit.project_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.project_bean.Recruiter;
import com.niit.project_dao.RecruiterDao;

/**
 * Servlet implementation class RecruiterRegisterPageController
 */
@WebServlet("/RecruiterRegisterPageController")
public class RecruiterRegisterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruiterRegisterPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rec_username = request.getParameter("username");
		String rec_password = request.getParameter("password");
		String rec_comapny_name = request.getParameter("company_name");
		String rec_email_id = request.getParameter("email_id");
		String rec_contact_no = request.getParameter("contact_no");
		
		//this will take the details and store it in the Recruiter bean class
		Recruiter recruiter = new Recruiter(rec_username, rec_password, rec_comapny_name, rec_email_id, rec_contact_no);
		
		RecruiterDao rec_dao = new RecruiterDao();
		String result = rec_dao.Rec_loadDriver(recruiter);
		response.getWriter().print(result);
	}

}

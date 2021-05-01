package com.niit.project_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.project_bean.Jobseeker;
import com.niit.project_dao.Dao_class;

/**
 * Servlet implementation class RegisterPageController
 */
@WebServlet("/RegisterPageController")
public class RegisterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPageController() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email_id = request.getParameter("email_id");
		String contact_no = request.getParameter("contact_no");
		String gender = request.getParameter("gender");
		
		//this will take the details and store it in the Jobseeker bean class
		Jobseeker jobseeker = new Jobseeker(username, password, email_id, contact_no, gender);
		
		Dao_class dao = new Dao_class();
		String result = dao.loadDriver(jobseeker);
		response.getWriter().print(result);
	}
}
























/*
Connection con;
PreparedStatement ps;

String username = request.getParameter("username");
String password = request.getParameter("password");
String email_id = request.getParameter("email_id");
String contact_no = request.getParameter("contact_no");
String gender = request.getParameter("gender");

PrintWriter out = response.getWriter();

try {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	con=DriverManager.getConnection("jdbc:sqlserver://LENOVO;databaseName=job_hunt;user=sa;password=niit@123");
	ps=con.prepareStatement("insert into user_details(username,password, email_id, contact_no, gender) values(?,?,?,?,?)");
	
	ps.setString(1, username);
	ps.setString(2, password);
	ps.setString(3, email_id);
	ps.setString(4, contact_no);
	ps.setString(5, gender);
	ps.executeUpdate();
	
	PreparedStatement ps1 = con.prepareStatement("select * from user_details");
	ResultSet rs = ps1.executeQuery();
	
	
	String u_name, u_mob, u_email;
	while(rs.next()) {
		u_name = rs.getString(1);
		u_email = rs.getString(3);
		u_mob = rs.getString(4);
		out.println("UserName : " + u_name + " email_id: " + u_email + " contact_no: " + u_mob);
	}
	
	
	response.sendRedirect("LoginPage.jsp");
	
	con.close();		
}
catch(Exception e) {
	out.println(e);
}
*/

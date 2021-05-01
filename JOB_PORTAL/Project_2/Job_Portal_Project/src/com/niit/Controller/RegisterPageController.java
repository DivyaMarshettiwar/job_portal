package com.niit.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Member;
import com.niit.dao.RegisterDao;


@WebServlet("/RegisterPageController")
public class RegisterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterPageController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email_id");
		String contact = request.getParameter("contact");
		String gender = request.getParameter("gender");
		
		Member member = new Member(username, password, email, contact, gender);
		
		RegisterDao rDao = new RegisterDao();
		String result = rDao.insert(member);
		response.getWriter().print(result);
	}

}

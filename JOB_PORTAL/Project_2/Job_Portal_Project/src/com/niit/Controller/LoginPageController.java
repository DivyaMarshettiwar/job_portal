package com.niit.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.LoginBean;
import com.niit.dao.LoginDao;

/**
 * Servlet implementation class LoginPageController
 */
@WebServlet("/LoginPageController")
public class LoginPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageController() {
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
		
		LoginBean loginbean = new LoginBean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
		
		LoginDao logindao = new LoginDao();
		
		if(logindao.validate(loginbean)) {
			response.sendRedirect("loginSuccess.jsp");
		}
		else {
			response.sendRedirect("LoginPage.jsp");
		}
	}

}

package com.niit.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.connection.FactoryProvider;
import com.niit.dao.CategoryDao;
import com.niit.dao.JobsDao;
import com.niit.entities.Category;
import com.niit.entities.JobDescription;

public class JobOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JobOperationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		
		String op = request.getParameter("operation");
		
		if(op.trim().equals("addcategory")) {
			
			//add category
			String title = request.getParameter("catTitle");
			
			Category category1 = new Category();
			category1.setCategoryTitle(title);
			
			//to save category data in database
			CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
			
			int categoryId = categoryDao.saveCategory(category1);
			
			//out.println("Category Saved");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Category added : " + categoryId);
			response.sendRedirect("recruiterPage.jsp");
			
			return;
			
		}else if(op.trim().equals("addjob")) {
			
			int jobcategoryId = Integer.parseInt(request.getParameter("jobCategory"));
			String jobTitle = request.getParameter("jobTitle");
			String jobCompanyName = request.getParameter("jobCompanyName");
			String jobExp = request.getParameter("jobExp");
			String jobSalary = request.getParameter("jobSalary");
			String jobLocation = request.getParameter("jobLocation");
			
			//get category by id
			CategoryDao categorydao = new CategoryDao(FactoryProvider.getFactory());
			Category categoryById = categorydao.getCategoryById(jobcategoryId);
			
			JobDescription jobdescription = new JobDescription();
			jobdescription.setJobDesignation(jobTitle);
			jobdescription.setJobCompanyName(jobCompanyName);
			jobdescription.setJobExperience(jobExp);
			jobdescription.setJobSalary(jobSalary);
			jobdescription.setJobLocation(jobLocation);
			//get category by id
			jobdescription.setCategory(categoryById);
			
			JobsDao jobsdao = new JobsDao(FactoryProvider.getFactory());
			jobsdao.saveJob(jobdescription);
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Job added successfully !!!");
			response.sendRedirect("recruiterPage.jsp");
			
		}
	}

}

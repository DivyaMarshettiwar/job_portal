package com.niit.project_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.niit.project_bean.Jobseeker;
import com.niit.project_bean.Recruiter;

public class RecruiterDao {
	
	Connection con;
	PreparedStatement ps;
	
	public String Rec_loadDriver(Recruiter recruiter) {
		String result = "Data inserted successfully!!!";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://LENOVO;databaseName=job_hunt;user=sa;password=niit@123");
			ps=con.prepareStatement("insert into recruiter_details(username,password,company_name, email_id, contact_no) values(?,?,?,?,?)");
			
			ps.setString(1, recruiter.getUsername());
			ps.setString(2, recruiter.getPassword());
			ps.setString(3, recruiter.getCompany_name());
			ps.setString(4, recruiter.getEmail_id());
			ps.setString(5, recruiter.getContact_no());
			ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("select * from recruiter_details");
			ResultSet rs = ps1.executeQuery();
			
		
			
			con.close();		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
}

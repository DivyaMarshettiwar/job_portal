package com.niit.project_dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.niit.project_bean.Jobseeker;

public class Dao_class {
	
	Connection con;
	PreparedStatement ps;
	
	public String loadDriver(Jobseeker jobseeker) {
		String result = "Data inserted successfully!!!";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://LENOVO;databaseName=job_hunt;user=sa;password=niit@123");
			ps=con.prepareStatement("insert into user_details(username,password, email_id, contact_no, gender) values(?,?,?,?,?)");
			
			ps.setString(1, jobseeker.getUsername());
			ps.setString(2, jobseeker.getPassword());
			ps.setString(3, jobseeker.getEmail());
			ps.setString(4, jobseeker.getContact());
			ps.setString(5, jobseeker.getGender());
			ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("select * from user_details");
			ResultSet rs = ps1.executeQuery();
			
		
			
			con.close();		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
}

package com.niit.project_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.project_bean.Jobseeker;


public class LoginDao_class {
	Connection con;
	PreparedStatement ps;

	public boolean validate(Jobseeker jobseeker) {

		boolean status = false;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://LENOVO;databaseName=job_hunt;user=sa;password=niit@123");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		String sql = "select * from user_detail where username = ? and password = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, jobseeker.getUsername() );
			ps.setString(2, jobseeker.getPassword() );
			
			ResultSet rs= ps.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}

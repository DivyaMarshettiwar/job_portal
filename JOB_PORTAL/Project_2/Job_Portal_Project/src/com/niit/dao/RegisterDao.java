package com.niit.dao;

import com.niit.Controller.*;
import com.niit.bean.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/job_hunt";
	private String dbUname = "root";
	private String dbPassword = "niit@123";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	public void loadDriver(String dbDriver) {
		
		try{
			Class.forName(dbDriver);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public String insert(Member member) {
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "insert into user_details(username,password,email,contact,gender) values (?,?,?,?,?)";
		String result = "Data inserted successfully!!!";
		
		
		try {
				
				PreparedStatement ps;
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getUsername());
				ps.setString(2, member.getPassword());
				ps.setString(3, member.getEmail());
				ps.setString(4, member.getContact());
				ps.setString(5, member.getGender());
				ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data NOT inserted";
		}
		
		return result;
	}
}

package com.niit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.bean.LoginBean;
import com.niit.dao.RegisterDao;
public class LoginDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/job_hunt";
	private String dbUname = "root";
	private String dbPassword = "niit@123";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void login_loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean validate(LoginBean loginbean) {

		login_loadDriver(dbDriver);
		Connection con = getConnection();
		
		boolean status = false;
		
		String sql = "select * from user_detail where username = ? and password = ? ";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginbean.getUsername() );
			ps.setString(2, loginbean.getPassword() );
			
			ResultSet rs= ps.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}


}

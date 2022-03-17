package com.springMVC.controller.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

	public boolean check(String uname, String pass) {
		String url="jdbc:mysql://localhost:3306/Credentials";
		String sql="select * from login where name=? and password=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","root");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
}

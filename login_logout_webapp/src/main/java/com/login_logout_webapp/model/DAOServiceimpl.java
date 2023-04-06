 package com.login_logout_webapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceimpl implements DAOService {
	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentreg","root","alam123");
			stmnt=con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifycredentials(String email, String password) {
		try {
			ResultSet result=stmnt.executeQuery("SELECT *from  login WHERE email='"+email+"' AND password='"+password+"'");
			return result.next();
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			stmnt.executeUpdate("delete  from registration where email='"+email+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveRegistration(String email, String password) {

	}

	@Override
	public ResultSet listReg() {
		try {
			ResultSet result=stmnt.executeQuery("select *from registration");
			return  result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("update registration set mobile='"+mobile+"' where email='"+email+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

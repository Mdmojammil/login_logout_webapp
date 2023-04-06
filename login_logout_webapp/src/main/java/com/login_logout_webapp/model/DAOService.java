package com.login_logout_webapp.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifycredentials(String email,String password);
	public void saveRegistration(String name, String city,String email,String mobile);
	public void deleteRegistration(String email);
	public void saveRegistration(String email, String password);
	public void updateRegistration(String email, String mobile);
	public ResultSet listReg();
	

}

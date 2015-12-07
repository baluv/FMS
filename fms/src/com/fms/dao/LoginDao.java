package com.fms.dao;

public interface LoginDao {
	
	public int checkLogin(String organization, String userid, String password);
	public int changepassword(String organization,String oldPassword, String newPassword );

}

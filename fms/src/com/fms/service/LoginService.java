package com.fms.service;

public interface LoginService {

	public int checkLogin(String organization, String userid, String password);
	public int changepassword(String orgName,String oldPwd, String newPwd);
}

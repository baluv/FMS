package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.dao.LoginDao;




@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired(required=true)
	private LoginDao loginDao;
	
	public int checkLogin(String organization, String userid, String password){
		
		return loginDao.checkLogin(organization, userid, password);
		
		
	}
	public int changepassword(String orgName,String oldPwd, String newPwd )
	{
		System.out.println("hello");
		return loginDao.changepassword(orgName, oldPwd, newPwd);
	}
}

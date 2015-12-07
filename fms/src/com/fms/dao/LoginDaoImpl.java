package com.fms.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.domain.Login;
import com.fms.exception.FMSGenericException;



@Repository("LoginDao")
@Transactional
public class LoginDaoImpl implements LoginDao{
	
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public int checkLogin(String organization, String userid, String password)throws FMSGenericException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();
			
			

			Login existingUser = (Login) session.get(Login.class, organization);
			
			if(organization.equals("AECS Administrative Office") && userid.equals(existingUser.getUserid()) && password.equals(existingUser.getPassword()) ){
				return 1;
			}else if(organization.equals(existingUser.getOrganization()) && userid.equals(existingUser.getUserid()) && password.equals(existingUser.getPassword()) ){
				return 2;
			}else
			{
				return 0;
			}
		}
		catch (HibernateException he) {
			throw new FMSGenericException(he+"");
	}


}
	public int changepassword(String organization,String oldPwd, String newPwd )throws FMSGenericException
	{
		try {
			System.out.println("begining");
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
       
	
		
		Login existingUser = (Login) session.get(Login.class, organization);
	
     
      if(organization.equals(existingUser.getOrganization())&& oldPwd.equals(existingUser.getPassword()))
      {
    	  String hql = 
  "UPDATE Login i set i.password ='"+ newPwd +"' WHERE i.organization = '" +organization+ "' ";
	session.createQuery(hql).executeUpdate();
    	  return 1;
      }
      else
      {
    	  return 0;
      
      }
      }catch (HibernateException he) {
			throw new FMSGenericException(he+"");
  	}
	}
	
}

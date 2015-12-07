package com.fms.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.domain.Day2dayVehicleDetails;
import com.fms.domain.ExistingVehicle;
import com.fms.domain.RefillingFuel;
import com.fms.domain.Vehicle;
import com.fms.exception.FMSGenericException;


@Repository("VehicleDao")
@Transactional
public class VehicleDaoImpl implements VehicleDao{
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public void insertNewVehicle(Vehicle vehicle)throws FMSGenericException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();
		session.save(vehicle);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
		
	}
@SuppressWarnings("unchecked")
public List<Vehicle> getVehicles(){
	return (List<Vehicle>) sessionFactory.getCurrentSession().createCriteria(
			Vehicle.class).list();
}
public void insertExistingVehicle(ExistingVehicle existingvehicle){
	try {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
	session.save(existingvehicle);
	} catch (HibernateException he) {
		throw new FMSGenericException(he + "");
	}
}
@SuppressWarnings("unchecked")
public List<ExistingVehicle> getVehicleServiceList()
{
	return (List<ExistingVehicle>) sessionFactory.getCurrentSession().createCriteria(
			ExistingVehicle.class).list();
}


public void insertDailyVehicleDetails(Day2dayVehicleDetails day2day)throws FMSGenericException{
	org.hibernate.classic.Session session = sessionFactory
	.getCurrentSession();	
	try{
		session.save(day2day);
	}catch(FMSGenericException ex)
	{
		throw new FMSGenericException(ex+"");
	}
	
}
public void updateVehicle(String vehiclename,String vehiclenumber,String vehicletype)
{
	org.hibernate.classic.Session session = sessionFactory
	.getCurrentSession();
	String hql="update Vehicle i set i.vehiclename='"+vehiclename+"',i.vehicletype='"+vehicletype+"' where i.vehiclenumber='"+vehiclenumber+"'";
session.createQuery(hql).executeUpdate();
}
public void deleteVehicle(String vehiclenumber)
{
	org.hibernate.classic.Session session = sessionFactory
	.getCurrentSession();
	String hql="delete Vehicle i where i.vehiclenumber='"+vehiclenumber+"'";
	session.createQuery(hql).executeUpdate();
}


@SuppressWarnings("unchecked")
public List<Day2dayVehicleDetails> getDailyVehicleList()
{
	return (List<Day2dayVehicleDetails>) sessionFactory.getCurrentSession().createCriteria(
			Day2dayVehicleDetails.class).list();
}


@SuppressWarnings("unchecked")
public List<Day2dayVehicleDetails> getDailyVehicles(String startdate,String enddate)
{
	org.hibernate.classic.Session session = sessionFactory
	.getCurrentSession();
	Criteria criteria = session.createCriteria(Day2dayVehicleDetails.class);
	//criteria.add(Restrictions.between("date",startdate,enddate));

	 criteria.add(Restrictions.ge("date",startdate));
	 criteria.add(Restrictions.le("date",enddate));
	//criteria.add(Expression.ge("date",startdate));
	//criteria.add(Expression.le("date",enddate));
	criteria.addOrder(Order.asc("date"));
	return criteria.list();
}

public void insertRefiilngFuel(RefillingFuel refillingFuel)
{
	org.hibernate.classic.Session session = sessionFactory
	.getCurrentSession();
	
	session.save(refillingFuel);
}

}

package com.fms.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.dao.VehicleDao;
import com.fms.domain.Day2dayVehicleDetails;
import com.fms.domain.ExistingVehicle;
import com.fms.domain.RefillingFuel;
import com.fms.domain.Vehicle;
import com.fms.exception.FMSGenericException;
@Service("VehicleService")
@Transactional
public class VehicleServiceImpl implements VehicleService{
	@Autowired(required = true)
	public VehicleDao vehicleDao;
	public void insertNewVehicle(Vehicle vehicle)throws FMSGenericException {
		try {
			vehicleDao.insertNewVehicle(vehicle);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
		
	}
	
	public List<Vehicle> getVehicles(){
		return vehicleDao.getVehicles();
	}
	public void insertExistingVehicle(ExistingVehicle existingvehicle)throws FMSGenericException{
		try{
			vehicleDao.insertExistingVehicle(existingvehicle);
		}catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
	}
	
	public void insertDailyVehicleDetails(Day2dayVehicleDetails day2day)throws FMSGenericException{
		try{
			vehicleDao.insertDailyVehicleDetails(day2day);
		}catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
	}
	public List<ExistingVehicle> getVehicleServiceList()
	{
		return vehicleDao.getVehicleServiceList();
	}
	public void updateVehicle(String vehiclename,String vehiclenumber,String vehicletype)
	{
		vehicleDao.updateVehicle(vehiclename, vehiclenumber, vehicletype);
	}
	public void deleteVehicle(String vehiclenumber)
	{
		vehicleDao.deleteVehicle(vehiclenumber);
	}
	public List<Day2dayVehicleDetails> getDailyVehicleList()
	{
		return vehicleDao.getDailyVehicleList();
	}
	
	public List<Day2dayVehicleDetails> getDailyVehicles(String startdate,String enddate)
	{
		return vehicleDao.getDailyVehicles(startdate, enddate);
	}
	
	public void insertRefiilngFuel(RefillingFuel refillingFuel)
	{
		vehicleDao.insertRefiilngFuel(refillingFuel);
	}
	}


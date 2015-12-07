package com.fms.service;

import java.util.List;

import com.fms.domain.Day2dayVehicleDetails;
import com.fms.domain.ExistingVehicle;
import com.fms.domain.RefillingFuel;
import com.fms.domain.Vehicle;

public interface VehicleService {
	public void insertNewVehicle(Vehicle vehicle);
	public void insertExistingVehicle(ExistingVehicle existingvehicle);
	public void insertDailyVehicleDetails(Day2dayVehicleDetails day2day);
	public List<Vehicle> getVehicles();
	public List<ExistingVehicle> getVehicleServiceList();
	public List<Day2dayVehicleDetails> getDailyVehicleList();
	public void updateVehicle(String vehiclename,String vehiclenumber,String vehicletype);
	public void deleteVehicle(String vehiclenumber);
	
	public List<Day2dayVehicleDetails> getDailyVehicles(String startdate,String enddate);
	public void insertRefiilngFuel(RefillingFuel refillingFuel);
}

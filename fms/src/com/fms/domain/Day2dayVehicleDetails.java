package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
//Defines the Day2dayVehicleDetails class as an entity
@SuppressWarnings("serial")
@Entity
//Defines the table name in the database
@Table(name="daily_vehicle_details")

public class Day2dayVehicleDetails implements java.io.Serializable{
	//Specifies the identifier of an entity
	@Id
	//Specifies the primary key generation
	@GeneratedValue
	//dailyvehicleid property is mapped to daily_vehicle_id column in the daily_vehicle_details table
	@Column(name="daily_vehicle_id")
    private int dailyvehicleid;
	
	@Column(name="date")
	private String date;
	
	@Column(name="vehicle_number")
	private String vehiclenumber;
	
	@Column(name="driver_name")
	private String drivername;
	
	@Column(name="organization")
	private String organization;
	
	@Column(name="to_where")
	private String towhere;
	
	
	@Column(name="in_km")
	private double inkm;
	
	@Column(name="out_km")
	private double outkm;
	
	@Column(name="in_time")
	private String intime;
	
	@Column(name="out_time")
	private String outtime;
	
	@Column(name="refilling_fuel")
	private int refillingfuel;
	
	
	@Column(name="repair")
	private String repair;
	
	@Column(name="amount")
	private double amount;
	//Generating setters and getters for all the properties
	public int getDailyvehicleid(){
		return dailyvehicleid;
	}
	
	public void setDailyvehicleid(int dailyvehicleid){
		this.dailyvehicleid=dailyvehicleid;
	}
	
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date=date;
	}
	
	public String getVehiclenumber(){
		return vehiclenumber;
    }
	public void setVehiclenumber(String vehiclenumber){
		this.vehiclenumber=vehiclenumber;
	}
	
	public String getDrivername(){
		return drivername;
	}
	public void setDrivername(String drivername){
		this.drivername=drivername;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getTowhere() {
		return towhere;
	}

	public void setTowhere(String towhere) {
		this.towhere = towhere;
	}

	
	
	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	

	public double getInkm() {
		return inkm;
	}

	public void setInkm(double inkm) {
		this.inkm = inkm;
	}

	public double getOutkm() {
		return outkm;
	}

	public void setOutkm(double outkm) {
		this.outkm = outkm;
	}

	

	public String getRepair() {
		return repair;
	}

	public void setRepair(String repair) {
		this.repair = repair;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getRefillingfuel() {
		return refillingfuel;
	}

	public void setRefillingfuel(int refillingfuel) {
		this.refillingfuel = refillingfuel;
	}
	
	 
	
	
	
	
	
	
	
	
}

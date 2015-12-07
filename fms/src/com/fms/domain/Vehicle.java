package com.fms.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//Defines the Vehicle class as an entity
@SuppressWarnings("serial")
@Entity
//Defines the vehicle table in the database
@Table(name = "vehicle")
public class Vehicle implements java.io.Serializable{
	

	//Specifies the identifier of an entity
	@Id
	//vehiclenumber property is mapped to vehicle_number column in vehicle table
	@Column(name="vehicle_number")
	private String vehiclenumber;
	
	@Column(name="vhehicle_name")
	private String vehiclename;
	
	@Column(name="vehicle_type")
	private String vehicletype;
	
	
	
	//Generating setters and getters for all the properties

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	

	
	
	
}


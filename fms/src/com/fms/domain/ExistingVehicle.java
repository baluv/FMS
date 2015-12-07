package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Defines the ExistingVehicle class as an entity
@SuppressWarnings("serial")
@Entity
//Defines the table name in the database
@Table(name="vehicle_service")

public class ExistingVehicle implements java.io.Serializable{
	//Specifies the identifier of an entity
	@Id
	//Specifies the primary key generation
	@GeneratedValue
	//serviceid property is mapped to service_id column in the vehicle_service table
	@Column(name="service_id")
	private int serviceid;
	
	@Column(name="service_date")
	private String servicedate;
	
	@Column(name="vehicle_number")
	private String vehiclenumber;
	
	@Column(name="person")
	private String person;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="comments")
	private String comments;
	
	//Generating setters and getters for all the properties
	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public String getServicedate() {
		return servicedate;
	}

	public void setServicedate(String servicedate) {
		this.servicedate = servicedate;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}

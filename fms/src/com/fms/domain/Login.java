package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//Defines the Login class as an entity
@SuppressWarnings("serial")
@Entity
//Defines the login table in the database
@Table(name = "login")
public class Login implements java.io.Serializable{
    //Specifies the identifier of an entity
	@Id
	//organization property is mapped to organization column in the login table
	@Column(name = "organization")
	private String organization;
	
	@Column(name = "userid")
	private String userid;
	
	@Column(name = "password")
	private String password;

//Generating setters and getters for all the properties
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

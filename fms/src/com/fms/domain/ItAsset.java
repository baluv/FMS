package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="it_assets")
public class ItAsset implements java.io.Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="itasset_id")
	private int itassetid;
	
	@Column(name="organization")
	private String organization;
	
	@Column(name="room_number")
	private String roomNumber;
	
	@Column(name="machine")
	private String machine;
	
	@Column(name="description")
	private String description;
	
	@Column(name="machine_type")
	private String machinetype;

	public int getItassetid() {
		return itassetid;
	}

	public void setItassetid(int itassetid) {
		this.itassetid = itassetid;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMachinetype() {
		return machinetype;
	}

	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	
	
	

}

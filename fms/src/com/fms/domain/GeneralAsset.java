package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "general_assets")
public class GeneralAsset implements java.io.Serializable {

	@Id
	@Column(name = "generalasset_id")
	private int generalassetid;

	@Column(name = "organization")
	private String organization;

	@Column(name = "room_number")
	private String roomNumber;

	public int getGeneralassetid() {
		return generalassetid;
	}

	public void setGeneralassetid(int generalassetid) {
		this.generalassetid = generalassetid;
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

}

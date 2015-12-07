package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="outward")

public class Outward {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="date")
	private String date;
	
	@Column(name="gatepass")
	private String gatepass;
	
	
	
	@Column(name="authorized_by")
	private String authorizedby;
	
	@Column(name="edate")
	private String edate;
	
	@Column(name="rdate")
	private String rdate;
	
	@Column(name="from_where")
	private String fromwhere;
	
	@Column(name="to_where")
	private String towhere;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGatepass() {
		return gatepass;
	}

	public void setGatepass(String gatepass) {
		this.gatepass = gatepass;
	}

	
	public String getAuthorizedby() {
		return authorizedby;
	}

	public void setAuthorizedby(String authorizedby) {
		this.authorizedby = authorizedby;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getFromwhere() {
		return fromwhere;
	}

	public void setFromwhere(String fromwhere) {
		this.fromwhere = fromwhere;
	}

	public String getTowhere() {
		return towhere;
	}

	public void setTowhere(String towhere) {
		this.towhere = towhere;
	}
	
	
	

}

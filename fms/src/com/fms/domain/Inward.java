package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inward")
public class Inward {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="date")
	private String date;
	
	@Column(name="invoice_number")
	private String invoicenumber;
	
	
	
	@Column(name="edate")
	private String edate;
	
	@Column(name="rdate")
	private String rdate;
	
	@Column(name="from_where")
	private String fromwhere;
	
	@Column(name="to_where")
	private String towhere;
	
	@Column(name="taken_by")
	private String takenby;

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

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
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

	public String getTakenby() {
		return takenby;
	}

	public void setTakenby(String takenby) {
		this.takenby = takenby;
	}
	

}

package com.fms.domain;

public class OutwardDTO {
	
	private int id;
	private String type;
	private String date;
	private String gatepass;
	private String fromwhere;
	private String towhere;
	private String edate;
	private String rdate;
	private String authorizedby;
	private String itemname;
	private int quantity;
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
	public String getAuthorizedby() {
		return authorizedby;
	}
	public void setAuthorizedby(String authorizedby) {
		this.authorizedby = authorizedby;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OutwardDTO(int id, String type, String date, String gatepass,
			String fromwhere, String towhere, String edate, String rdate,
			String authorizedby, String itemname, int quantity) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.gatepass = gatepass;
		this.fromwhere = fromwhere;
		this.towhere = towhere;
		this.edate = edate;
		this.rdate = rdate;
		this.authorizedby = authorizedby;
		this.itemname = itemname;
		this.quantity = quantity;
	}

}

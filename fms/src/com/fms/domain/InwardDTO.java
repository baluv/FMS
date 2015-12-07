package com.fms.domain;

public class InwardDTO {
	
	private int id;
	private String type;
	private String date;
	private String invoicenumber;
	
	private String fromwhere;
	private String towhere;
	private String edate;
	private String rdate;
	private String takenby;
	private String itemname;
	private int quantity;
	


	public InwardDTO(int id, String type, String date, String invoicenumber,
			String fromwhere, String towhere, String edate, String rdate,
			String takenby, String itemname, int quantity) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.invoicenumber = invoicenumber;
		this.fromwhere = fromwhere;
		this.towhere = towhere;
		this.edate = edate;
		this.rdate = rdate;
		this.takenby = takenby;
		this.itemname = itemname;
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTakenby() {
		return takenby;
	}
	public void setTakenby(String takenby) {
		this.takenby = takenby;
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
	
}

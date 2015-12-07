package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//Defines the ComplaintVoucher class as an entity 
@SuppressWarnings("serial")
@Entity
//Defines the table name in the database
@Table(name = "complaint_voucher")
public class ComplaintVoucher implements java.io.Serializable{
    //Specifies the identifier property of an entity
	@Id 
	//Specifies the primary key generation
	@GeneratedValue
	//voucherId property is mapped to vocher_id column in the complaint_voucher table
	@Column(name="voucher_id")
	private int voucherId;
	
	@Column(name="complaint_id")
	private int complaintId;
	
	@Column(name="cashmode")
	private String cashmode;
	
	@Column(name="voucher_date")
	private String voucherDate;
	
	@Column(name="towards")
	private String towards;
	
	@Column(name="sumofrupees")
	private String sumofrupees;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="paidPerson")
	private String paidPerson;
	
	@Column(name="receivedPerson")
	private String receivedPerson;
	
	@Column(name="receivedParty")
	private String receivedParty;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="issuedDate")
	private String issuedDate;
		
	
//Generating setters and getters for all properties
	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCashmode() {
		return cashmode;
	}

	public void setCashmode(String cashmode) {
		this.cashmode = cashmode;
	}

	public String getTowards() {
		return towards;
	}

	public void setTowards(String towards) {
		this.towards = towards;
	}

	public String getSumofrupees() {
		return sumofrupees;
	}

	public void setSumofrupees(String sumofrupees) {
		this.sumofrupees = sumofrupees;
	}

	public String getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
	}

	public String getPaidPerson() {
		return paidPerson;
	}

	public void setPaidPerson(String paidPerson) {
		this.paidPerson = paidPerson;
	}

	public String getReceivedPerson() {
		return receivedPerson;
	}

	public void setReceivedPerson(String receivedPerson) {
		this.receivedPerson = receivedPerson;
	}

	public String getReceivedParty() {
		return receivedParty;
	}

	public void setReceivedParty(String receivedParty) {
		this.receivedParty = receivedParty;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}
	
	
	
	
}

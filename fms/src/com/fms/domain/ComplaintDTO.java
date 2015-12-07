package com.fms.domain;

public class ComplaintDTO {

	
	private String complaint;
	private String organization;
	private String roomNumber;
	private String category;
	private String status;
	private String createdDate;
	private int amount;
	
	public ComplaintDTO(String complaint,String organization,
			String roomNumber,String category,String status,
			String createdDate,int amount) {
		super();
		this.complaint = complaint;
		this.organization = organization;
		this.roomNumber = roomNumber;
		this.category = category;
		this.status = status;
		this.createdDate = createdDate;
		this.amount = amount;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}

package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "complaint_archive")
public class ComplaintArchive implements java.io.Serializable {
	
	
		@Id 
		//Specifies the primary key generation
		@GeneratedValue
		//complaintId property is mapped to complaint_id column in the complaints table
		@Column(name="complaint_id")
		private int complaintId;
		//complaint property is mapped to complaint column in the complaints table
		@Column(name="complaint")
	    private String complaint;
		//organization property is mapped to organization column in the complaints table
		@Column(name = "organization")
		private String organization;
		//roomNumber property is mapped to room_number column in the complaints table
		@Column(name="room_number")
		private String roomNumber;
		//category property is mapped to category column in the complaints table
		@Column(name="category")
		private String category;
		
		@Column(name="status")
		private String status;
		
		@Column(name="priority")
		private String priority;
		
		@Column (name="created_date")
		private String createdDate;
		
		@Column(name="updated_date")
		private String updatedDate;
		
		@Column(name="comments")
		private String comments;
		
		@Column(name="machine_name")
		private String machine;
		
		@Column(name="assignedto")
		private String assignedto;

		public int getComplaintId() {
			return complaintId;
		}

		public void setComplaintId(int complaintId) {
			this.complaintId = complaintId;
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

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

		public String getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}

		public String getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public String getMachine() {
			return machine;
		}

		public void setMachine(String machine) {
			this.machine = machine;
		}

		public String getAssignedto() {
			return assignedto;
		}

		public void setAssignedto(String assignedto) {
			this.assignedto = assignedto;
		}

		public ComplaintArchive(int complaintId, String complaint,
				String organization, String roomNumber, String category,
				String status, String priority, String createdDate,
				String updatedDate, String comments, String machine,
				String assignedto) {
			super();
			this.complaintId = complaintId;
			this.complaint = complaint;
			this.organization = organization;
			this.roomNumber = roomNumber;
			this.category = category;
			this.status = status;
			this.priority = priority;
			this.createdDate = createdDate;
			this.updatedDate = updatedDate;
			this.comments = comments;
			this.machine = machine;
			this.assignedto = assignedto;
		}
		

}

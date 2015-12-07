package com.fms.service;

import java.util.List;

import com.fms.domain.Complaint;
import com.fms.domain.ComplaintDTO;
import com.fms.domain.ComplaintVoucher;

public interface ComplaintService {

	public void saveComplaint(Complaint complaint);
	public List<Complaint> getAllComplaintList();
	public List<Complaint> searchComplaints(String organization);
	public void updateComplaint(int complaintId, String complaint, String roomNumber, String category,String machine, String assignedto,String status, String priority, String comments, String updatedDate);
	public List<ComplaintVoucher> getVoucherList(int complaintId);
	public void saveVocuher(ComplaintVoucher vocuher);
	public void updateVoucher(int complaintId, String cashmode, String vdate,int amount, String towards, String sumofrupees,String idate,
			String pperson, String rperson, String rparty, String pnumber);
	public List<ComplaintVoucher> getAllVouchersList();
	public List<Complaint> getComplaint(int complaintId);
	public List<Complaint> getClosedComplaint();
	public List<Complaint> getRoomHistoryComplaintList(String organization, String roomNumber);
	public List getComplaintStatus();
	public List getComplaintsByCategory();
	public List getComplaintsByOrganization();
	public List<ComplaintDTO> getComplaintsReportByOrganization(
			String organization, String status, String month, String year);
	public List<ComplaintDTO> getComplaintsReportByCategory(String category, String status, String month, String year);
	public List<ComplaintDTO> getRoomComplaintHistory(String organization, String roomNumber, String month, String year);
	public List<ComplaintVoucher> getVouchersReport(String month, String year);
	
	public List<Complaint> getOpenCategoryComplaints(String category, String status, String month, String year);
	public List<Complaint> getOpenOrganizationComplaints(String organization, String status, String month, String year);
	public List<Complaint> getdailycomplaintsreport(String organization,String status,String currentDate);
	public List getAmount(ComplaintVoucher voucher);
}

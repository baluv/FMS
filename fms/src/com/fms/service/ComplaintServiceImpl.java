package com.fms.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.domain.Complaint;
import com.fms.domain.ComplaintDTO;
import com.fms.domain.ComplaintVoucher;
import com.fms.dao.AssetDao;
import com.fms.dao.ComplaintDao;
import com.fms.exception.FMSGenericException;

@Service("ComplaintService")
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired(required = true)
	public ComplaintDao complaintDao;
	@Autowired(required = true)
	public AssetDao assetDao;

	public void saveComplaint(Complaint complaint) throws FMSGenericException {
		try {
			complaintDao.saveComplaint(complaint);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
	}
	
	public List<Complaint> getAllComplaintList(){
		
		return complaintDao.getAllComplaintList();
	}
	
	public List<Complaint> searchComplaints(String organization){
		
		return complaintDao.searchComplaints(organization);
	}
		
	public void updateComplaint(int complaintId, String complaint, String roomNumber, String category,String machine,String assignedto, String status, String priority, String comments, String updatedDate){
		
		complaintDao.updateComplaint(complaintId, complaint, roomNumber, category,machine,assignedto, status, priority, comments, updatedDate);
	}
	
	public List<ComplaintVoucher> getVoucherList(int complaintId){
		
		return complaintDao.getVoucherList(complaintId);
	}
	
	public void saveVocuher(ComplaintVoucher vocuher){
		
		complaintDao.saveVocuher(vocuher);
	}
	
	public void updateVoucher(int complaintId, String cashmode, String vdate,int amount, String towards, String sumofrupees,String idate,
			String pperson, String rperson, String rparty, String pnumber){
		
		complaintDao.updateVoucher(complaintId, cashmode, vdate, amount, towards, sumofrupees, idate, pperson, rperson, rparty, pnumber);
	}
	public List<ComplaintVoucher> getAllVouchersList(){
		
		return complaintDao.getAllVouchersList();
		
	}
	public List<Complaint> getComplaint(int complaintId){
		
		return complaintDao.getComplaint(complaintId);
	}
	public List<Complaint> getClosedComplaint(){
		
		return complaintDao.getClosedComplaint();
	}
	public List<Complaint> getRoomHistoryComplaintList(String organization, String roomNumber){
		
		return complaintDao.getRoomHistoryComplaintList(organization, roomNumber);
	}
	public List getComplaintStatus()
	{
		return complaintDao.getComplaintStatus();
	}
	public List getComplaintsByCategory()
	{
		return complaintDao.getComplaintsByCategory();
	}
	public List getComplaintsByOrganization()
	{
		return complaintDao.getComplaintsByOrganization();
	}
	
	public List<ComplaintDTO> getComplaintsReportByOrganization(
			String organization, String status, String month, String year){
		
		return complaintDao.getComplaintsReportByOrganization(organization, status, month, year);
	}
	
	public List<ComplaintDTO> getComplaintsReportByCategory(String category, String status, String month, String year){
		
		return complaintDao.getComplaintsReportByCategory(category, status, month, year);
	}
	public List<ComplaintDTO> getRoomComplaintHistory(String organization, String roomNumber, String month, String year){
		
		return complaintDao.getRoomComplaintHistory(organization, roomNumber, month, year);
	}
	
	public List<ComplaintVoucher> getVouchersReport(String month, String year){
		
		return complaintDao.getVouchersReport(month, year);
	}
	
public List<Complaint> getOpenCategoryComplaints(String category, String status, String month, String year){
		
		return complaintDao.getOpenCategoryComplaints(category, status, month, year);
	}
	public List<Complaint> getOpenOrganizationComplaints(String organization, String status, String month, String year){
		
		return complaintDao.getOpenOrganizationComplaints(organization, status, month, year);
	}
	public List<Complaint> getdailycomplaintsreport(String organization,String status,String currentDate)
	{
		return complaintDao.getdailycomplaintsreport(organization, status, currentDate);
	}
	public List getAmount(ComplaintVoucher voucher)
	{
		return complaintDao.getAmount(voucher);
	}
}

package com.fms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fms.domain.Complaint;
import com.fms.domain.ComplaintVoucher;
import com.fms.domain.ItAsset;
import com.fms.domain.Login;
import com.fms.exception.FMSGenericException;
import com.fms.service.AssetService;
import com.fms.service.ComplaintService;
import com.fms.utils.originalNumToLetter;

//Defines The ComplaintController Class as a Controller Class 
@Controller
//Mapping the web request path to ComplaintController class
@RequestMapping("/complaints")
public class ComplaintController {

	private static final Logger log = Logger
			.getLogger(ComplaintController.class);
	
	//Defining object for ComplaintService class
	@Autowired(required = true)
	public ComplaintService complaintService;
	@Autowired(required = true)
	public AssetService assetService;
	
    //Mapping web request path to getNewComplaintForm method
	@RequestMapping(value = "/newComplaint")
	//Method to get new complaint form
	public String getNewComplaintFrom(@RequestParam("organization")
			String organization,Map<String, Object> model) {

		Complaint complaintsForm = new Complaint();
		
		model.put("complaintsForm", complaintsForm);
		model.put("rooms",assetService.getRoomNumber(organization));
		model.put("machines", assetService.getMachinename(organization));
		return "new_complaint";
	}
    //Mapping web request path to saveNewComplaint method
	@RequestMapping(value = "/saveComplaint")
	//Method to save the complaint in database
	public String saveNewComplaint(@ModelAttribute("complaint")
	Complaint complaint, Map<String, Object> model) throws FMSGenericException {

		Complaint complaintsForm = new Complaint();
		ItAsset itAsset=new ItAsset();

		Complaint newComplaintsForm = new Complaint();
		/* Get current Date here */
		DateFormat dateFormat = new SimpleDateFormat("MMMMM dd,yyyy hh:mm aaa");
		Date date = new Date();
		String currentDate = dateFormat.format(date);

		newComplaintsForm.setComplaint(complaint.getComplaint());
		newComplaintsForm.setOrganization(complaint.getOrganization());
		newComplaintsForm.setRoomNumber(complaint.getRoomNumber());
		newComplaintsForm.setCategory(complaint.getCategory());
		newComplaintsForm.setStatus(complaint.getStatus());
		newComplaintsForm.setPriority(complaint.getPriority());
		newComplaintsForm.setComments(complaint.getComments());
		newComplaintsForm.setCreatedDate(currentDate);
		newComplaintsForm.setUpdatedDate(currentDate);
		newComplaintsForm.setMachine(complaint.getMachine());
		newComplaintsForm.setAssignedto(complaint.getAssignedto());
		try {
			
			complaintService.saveComplaint(newComplaintsForm);
			//model.put("machines", assetService.getMachinename(itAsset.getOrganization()));
			// System.out.println("hai"+assetService.getMachinename(itAsset.getOrganization()));
			model.put("successMessage", "Complaint Saved Successfully..");
			
		} catch (Exception he) {
			throw new FMSGenericException(he + "");
		}

		model.put("complaintsForm", complaintsForm);
		model.put("rooms",assetService.getRoomNumber(complaint.getOrganization()));
		model.put("machines", assetService.getMachinename(complaint.getOrganization()));
		return "new_complaint";
	}
    
	//Mapping web request path to method
	@RequestMapping(value = "/adminNewComplaint")
	//Method to get admin new complaint form
	public String getAdminNewComplaintFrom(Map<String, Object> model,@RequestParam("organization") String organization) {

		Complaint complaintsForm = new Complaint();
		model.put("complaintsForm", complaintsForm);
		model.put("rooms",assetService.getRoomNumber(organization));
		model.put("machines", assetService.getMachinename(organization));
		return "admin_newcomplaint";
	}

	//Mapping web request path to method
	@RequestMapping(value = "/saveAdminComplaint")
	//Method to save admin new complaint
	public String saveAdminNewComplaint(@ModelAttribute("complaint")
	Complaint complaint, Map<String, Object> model) throws FMSGenericException {

		Complaint complaintsForm = new Complaint();

		Complaint newComplaintsForm = new Complaint();
		/* Get current Date here */
		DateFormat dateFormat = new SimpleDateFormat("MMMMM dd,yyyy hh:mm aaa");
		Date date = new Date();
		String currentDate = dateFormat.format(date);

		newComplaintsForm.setComplaint(complaint.getComplaint());
		newComplaintsForm.setOrganization(complaint.getOrganization());
		newComplaintsForm.setRoomNumber(complaint.getRoomNumber());
		newComplaintsForm.setCategory(complaint.getCategory());
		newComplaintsForm.setStatus(complaint.getStatus());
		newComplaintsForm.setPriority(complaint.getPriority());
		newComplaintsForm.setComments(complaint.getComments());
		newComplaintsForm.setAssignedto(complaint.getAssignedto());
		newComplaintsForm.setCreatedDate(currentDate);
		newComplaintsForm.setUpdatedDate(currentDate);
		newComplaintsForm.setMachine(complaint.getMachine());
		try {
			complaintService.saveComplaint(newComplaintsForm);
			model.put("successMessage", "Complaint Saved Successfully..");
		} catch (Exception he) {
			throw new FMSGenericException(he + "");
		}

		model.put("complaintsForm", complaintsForm);

		return "admin_newcomplaint";
	}

	//Mapping web request path to method
	@RequestMapping(value = "/allComplaintList")
	//Method to get all complaints list
	public String getAllComplaints(Map<String, Object> model) {

		model.put("complaintList", complaintService.getAllComplaintList());

		return "all_complaint_list";

	}
    
	//Mapping web request path to method
	@RequestMapping(value = "/allComplaintbyOrganization")
	//Method to get complaints by organization form
	public String getComplaintListFrom(Map<String, Object> model) {

		Login orgForm = new Login();
		model.put("orgForm", orgForm);

		return "compalints_by_organization";
	}
	
    //Mapping web request path to method
	@RequestMapping(value = "/searchComplaintsbyOrganization")
	//Method to search complaint list by organization using request parameters
	public String searchComplaintListByOrganization(
			@RequestParam("organization")
			String organization, Map<String, Object> model) {

		Login orgForm = new Login();
		model.put("orgForm", orgForm);
		orgForm.setOrganization(organization);

		model.put("orgcomplaintList", complaintService
				.searchComplaints(organization));
		return "compalints_by_organization";
	}
 
	//Mapping web request path to method
	@RequestMapping(value = "/updateComplaint")
	//Method to get update complaint form using request parameters
	public String getUpdateComplaintFrom(@RequestParam("complaintId")
	Integer complaintId, @RequestParam("complaint")
	String complaint, @RequestParam("roomNumber")
	String roomNumber, @RequestParam("comments")
	String comments, @RequestParam("category")
	String category, @RequestParam("status")
	String status, @RequestParam("priority")
	String priority,@RequestParam("machine")
	String machine,@RequestParam("assignedto")String assignedto, Map<String, Object> model) {

		Complaint complaintsForm = new Complaint();

		complaintsForm.setComplaintId(complaintId);
		complaintsForm.setComplaint(complaint);
		complaintsForm.setRoomNumber(roomNumber);
		complaintsForm.setCategory(category);
		complaintsForm.setMachine(machine);
		complaintsForm.setAssignedto(assignedto);
		complaintsForm.setStatus(status);
		complaintsForm.setPriority(priority);
		complaintsForm.setComments(comments);
		
		
		model.put("complaintsForm", complaintsForm);

		return "update_complaint_form";
	}
	@RequestMapping(value = "/orgupdateComplaint")
	//Method to get update complaint form using request parameters
	public String getOrgUpdateComplaintFrom(@RequestParam("complaintId")
	Integer complaintId, @RequestParam("complaint")
	String complaint, @RequestParam("roomNumber")
	String roomNumber, @RequestParam("comments")
	String comments, @RequestParam("category")
	String category, @RequestParam("status")
	String status, @RequestParam("priority")
	String priority,@RequestParam("machine")
	String machine,@RequestParam("assignedto")String assignedto, Map<String, Object> model) {

		Complaint complaintsForm = new Complaint();

		complaintsForm.setComplaintId(complaintId);
		complaintsForm.setComplaint(complaint);
		complaintsForm.setRoomNumber(roomNumber);
		complaintsForm.setCategory(category);
		complaintsForm.setMachine(machine);
		complaintsForm.setStatus(status);
		complaintsForm.setPriority(priority);
		complaintsForm.setComments(comments);
		complaintsForm.setAssignedto(assignedto);
		
		
		model.put("complaintsForm", complaintsForm);

		return "orgupdate_complaint_form";
	}
	@RequestMapping(value = "/saveOrgUpadateComplaint")
	//Method to save the updated complaint
	public String OrgUpdateComplaintFrom(@ModelAttribute("complaint")
	Complaint complaint, Map<String, Object> model) {

		Complaint complaintsForm = new Complaint();

		complaintsForm.setComplaintId(complaint.getComplaintId());
		complaintsForm.setComplaint(complaint.getComplaint());
		complaintsForm.setRoomNumber(complaint.getRoomNumber());
		complaintsForm.setCategory(complaint.getCategory());
		complaintsForm.setMachine(complaint.getMachine());
		complaintsForm.setAssignedto(complaint.getAssignedto());
		complaintsForm.setStatus(complaint.getStatus());
		complaintsForm.setPriority(complaint.getPriority());
		complaintsForm.setComments(complaint.getComments());

		DateFormat dateFormat = new SimpleDateFormat("MMMMM dd,yyyy hh:mm aaa");
		Date date = new Date();
		String updatedDate = dateFormat.format(date);

		complaintService.updateComplaint(complaint.getComplaintId(), complaint
				.getComplaint(), complaint.getRoomNumber(), complaint
				.getCategory(),complaint.getMachine(),complaint.getAssignedto(), complaint.getStatus(), complaint.getPriority(),
				complaint.getComments(), updatedDate);
		model.put("complaintsForm", complaintsForm);
		model.put("successMessage", "Complaint Updated Successfully...");
		return "orgupdate_complaint_form";
	}
	//Mapping web request path to method
	@RequestMapping(value = "/saveUpadateComplaint")
	//Method to save the updated complaint
	public String UpdateComplaintFrom(@ModelAttribute("complaint")
	Complaint complaint, Map<String, Object> model) {

		Complaint complaintsForm = new Complaint();

		complaintsForm.setComplaintId(complaint.getComplaintId());
		complaintsForm.setComplaint(complaint.getComplaint());
		complaintsForm.setRoomNumber(complaint.getRoomNumber());
		complaintsForm.setCategory(complaint.getCategory());
		complaintsForm.setMachine(complaint.getMachine());
		complaintsForm.setAssignedto(complaint.getAssignedto());
		complaintsForm.setStatus(complaint.getStatus());
		complaintsForm.setPriority(complaint.getPriority());
		complaintsForm.setComments(complaint.getComments());

		DateFormat dateFormat = new SimpleDateFormat("MMMMM dd,yyyy hh:mm aaa");
		Date date = new Date();
		String updatedDate = dateFormat.format(date);

		complaintService.updateComplaint(complaint.getComplaintId(), complaint
				.getComplaint(), complaint.getRoomNumber(), complaint
				.getCategory(),complaint.getMachine(),complaint.getAssignedto(), complaint.getStatus(), complaint.getPriority(),
				complaint.getComments(), updatedDate);
		model.put("complaintsForm", complaintsForm);
		model.put("successMessage", "Complaint Updated Successfully...");
		return "update_complaint_form";
	}

	//Mapping web request path to method
	@RequestMapping(value = "/voucher")
	//Method to get the voucher form using request parameters
	public String getVoucherForm(@RequestParam("cid")
	int cid, Map<String, Object> model) {
		
		
		ComplaintVoucher voucherForm = new ComplaintVoucher();

		List<ComplaintVoucher> list = complaintService.getVoucherList(cid);
		log.debug("list:"+list.toString());

		if (!list.isEmpty()) {

			for (ComplaintVoucher list1 : list) {

				voucherForm.setComplaintId(list1.getComplaintId());
				voucherForm.setCashmode(list1.getCashmode());
				voucherForm.setAmount(list1.getAmount());
				voucherForm.setTowards(list1.getTowards());
				voucherForm.setVoucherDate(list1.getVoucherDate());
				voucherForm.setIssuedDate(list1.getIssuedDate());
				voucherForm.setPaidPerson(list1.getPaidPerson());
				voucherForm.setReceivedPerson(list1.getReceivedPerson());
				voucherForm.setReceivedParty(list1.getReceivedParty());
				voucherForm.setPhoneNumber(list1.getPhoneNumber());
				model.put("cid", list1.getComplaintId());
				
			}
			
			model.put("voucherForm", voucherForm);
			
			return "vocher_update_form";
		} else {

			model.put("voucherForm", voucherForm);
			model.put("cid", cid);
			return "voucher_entry_form";
		}
	}
	@RequestMapping(value = "/orgvoucher")
	//Method to get the voucher form using request parameters
	public String getOrgVoucherForm(@RequestParam("cid")
	int cid, Map<String, Object> model) {
		
		
		ComplaintVoucher voucherForm = new ComplaintVoucher();

		List<ComplaintVoucher> list = complaintService.getVoucherList(cid);
		log.debug("list:"+list.toString());

		if (!list.isEmpty()) {

			for (ComplaintVoucher list1 : list) {

				voucherForm.setComplaintId(list1.getComplaintId());
				voucherForm.setCashmode(list1.getCashmode());
				voucherForm.setAmount(list1.getAmount());
				voucherForm.setTowards(list1.getTowards());
				voucherForm.setVoucherDate(list1.getVoucherDate());
				voucherForm.setIssuedDate(list1.getIssuedDate());
				voucherForm.setPaidPerson(list1.getPaidPerson());
				voucherForm.setReceivedPerson(list1.getReceivedPerson());
				voucherForm.setReceivedParty(list1.getReceivedParty());
				voucherForm.setPhoneNumber(list1.getPhoneNumber());
				model.put("cid", list1.getComplaintId());
							
			}
			
			model.put("voucherForm", voucherForm);
			
			return "orgvoucher_update_form";
		} else {

			model.put("voucherForm", voucherForm);
			model.put("cid", cid);
			return "orgvoucher_entry_form";
		}
	}
	
	//Mapping web request path to method
	@RequestMapping(value = "/saveVoucher")
	//Method to save the voucher form details
	public String saveVoucherForm(@ModelAttribute("voucher")
			ComplaintVoucher voucher, Map<String, Object> model) {
		
		ComplaintVoucher voucherForm = new ComplaintVoucher();
		
		String rupessinwords = originalNumToLetter.numtowords(voucher.getAmount());
		
		voucherForm.setComplaintId(voucher.getComplaintId());
		voucherForm.setCashmode(voucher.getCashmode());
		voucherForm.setSumofrupees(rupessinwords);
		voucherForm.setVoucherDate(voucher.getVoucherDate());
		voucherForm.setAmount(voucher.getAmount());
		voucherForm.setTowards(voucher.getTowards());
		voucherForm.setPaidPerson(voucher.getPaidPerson());
		voucherForm.setPhoneNumber(voucher.getPhoneNumber());
		voucherForm.setReceivedPerson(voucher.getReceivedPerson());
		voucherForm.setReceivedParty(voucher.getReceivedParty());
		voucherForm.setIssuedDate(voucher.getIssuedDate());
		
		complaintService.saveVocuher(voucherForm);
		model.put("cid", voucher.getComplaintId());
		model.put("voucherForm", voucherForm);
		return "vocher_update_form";
	}
	@RequestMapping(value = "/saveOrgVoucher")
	//Method to save the voucher form details
	public String saveorgVoucherForm(@ModelAttribute("voucher")
			ComplaintVoucher voucher, Map<String, Object> model) {
		
		ComplaintVoucher voucherForm = new ComplaintVoucher();
		
		String rupessinwords = originalNumToLetter.numtowords(voucher.getAmount());
		
		voucherForm.setComplaintId(voucher.getComplaintId());
		voucherForm.setCashmode(voucher.getCashmode());
		voucherForm.setSumofrupees(rupessinwords);
		voucherForm.setVoucherDate(voucher.getVoucherDate());
		voucherForm.setAmount(voucher.getAmount());
		voucherForm.setTowards(voucher.getTowards());
		voucherForm.setPaidPerson(voucher.getPaidPerson());
		voucherForm.setPhoneNumber(voucher.getPhoneNumber());
		voucherForm.setReceivedPerson(voucher.getReceivedPerson());
		voucherForm.setReceivedParty(voucher.getReceivedParty());
		voucherForm.setIssuedDate(voucher.getIssuedDate());
		
		complaintService.saveVocuher(voucherForm);
		model.put("cid", voucher.getComplaintId());
		model.put("voucherForm", voucherForm);
		return "orgvoucher_update_form";
	}
	
	//Mapping Web request path to method
		@RequestMapping(value = "/orgupdateVoucher")
		//Method to update the voucher form details
		public String orgupdateVoucherForm(@ModelAttribute("voucher")
				ComplaintVoucher voucher, Map<String, Object> model) {
			
			ComplaintVoucher voucherForm = new ComplaintVoucher();
			
			String rupessinwords = originalNumToLetter.numtowords(voucher.getAmount());
			
			voucherForm.setComplaintId(voucher.getComplaintId());
			voucherForm.setCashmode(voucher.getCashmode());
			voucherForm.setSumofrupees(rupessinwords);
			voucherForm.setVoucherDate(voucher.getVoucherDate());
			voucherForm.setAmount(voucher.getAmount());
			voucherForm.setTowards(voucher.getTowards());
			voucherForm.setPaidPerson(voucher.getPaidPerson());
			voucherForm.setPhoneNumber(voucher.getPhoneNumber());
			voucherForm.setReceivedPerson(voucher.getReceivedPerson());
			voucherForm.setReceivedParty(voucher.getReceivedParty());
			voucherForm.setIssuedDate(voucher.getIssuedDate());
			
			complaintService.updateVoucher(voucher.getComplaintId(), voucher.getCashmode(),voucher.getVoucherDate(),voucher.getAmount(),voucher.getTowards(),rupessinwords,voucher.getIssuedDate(),voucher.getPaidPerson(),voucher.getReceivedPerson(),voucher.getReceivedParty(),voucher.getPhoneNumber());
			
			model.put("msg","Voucher Updated Successfully..");
			model.put("cid", voucher.getComplaintId());
			model.put("voucherForm", voucherForm);
			return "orgvoucher_update_form";
		}
	//Mapping Web request path to method
	@RequestMapping(value = "/updateVoucher")
	//Method to update the voucher form details
	public String updateVoucherForm(@ModelAttribute("voucher")
			ComplaintVoucher voucher, Map<String, Object> model) {
		
		ComplaintVoucher voucherForm = new ComplaintVoucher();
		
		String rupessinwords = originalNumToLetter.numtowords(voucher.getAmount());
		
		voucherForm.setComplaintId(voucher.getComplaintId());
		voucherForm.setCashmode(voucher.getCashmode());
		voucherForm.setSumofrupees(rupessinwords);
		voucherForm.setVoucherDate(voucher.getVoucherDate());
		voucherForm.setAmount(voucher.getAmount());
		voucherForm.setTowards(voucher.getTowards());
		voucherForm.setPaidPerson(voucher.getPaidPerson());
		voucherForm.setPhoneNumber(voucher.getPhoneNumber());
		voucherForm.setReceivedPerson(voucher.getReceivedPerson());
		voucherForm.setReceivedParty(voucher.getReceivedParty());
		voucherForm.setIssuedDate(voucher.getIssuedDate());
		
		complaintService.updateVoucher(voucher.getComplaintId(), voucher.getCashmode(),voucher.getVoucherDate(),voucher.getAmount(),voucher.getTowards(),rupessinwords,voucher.getIssuedDate(),voucher.getPaidPerson(),voucher.getReceivedPerson(),voucher.getReceivedParty(),voucher.getPhoneNumber());
		
		model.put("msg","Voucher Updated Successfully..");
		model.put("cid", voucher.getComplaintId());
		model.put("voucherForm", voucherForm);
		return "vocher_update_form";
	}
	
	@RequestMapping(value = "/allvouchersList")
	public String getAllVoucherList(Map<String, Object> model) {

		model.put("voucherList", complaintService.getAllVouchersList());
		
	
		
		
		return "all_voucher_list";
	}
	
	//Mapping web request path to method
	@RequestMapping(value = "/viewComplaint")
	//Method to get the complaint by voucher details using complaintId as a request parameter
	public String getCompalintByVocuher(@RequestParam("complaintId")
			Integer complaintId,Map<String, Object> model) {

		model.put("complaintList", complaintService.getComplaint(complaintId));

		return "complaint_by_voucher";
	}
	
	//Mapping web request path to method
	@RequestMapping(value = "/closedComplaints")
	//Method to get the closed complaints
	public String getAllClosedComplaints(Map<String, Object> model) {

		model.put("complaintList", complaintService.getClosedComplaint());

		return "all_complaint_history";
     }
	
	//Mapping web request path to method
	@RequestMapping(value = "/searchRoomHistory")
	//Method to search the room history by organization
	public String searchRoomHistoryComplaints(Map<String, Object> model) {

		Complaint complaintForm = new Complaint();
		model.put("complaintForm", complaintForm);

		return "room_history";
	}
	
	//Mapping web request path to method 
	@RequestMapping(value = "/getRoomHistory")
	//Method to get room history 
	public String getRoomHistoryComplaints(@ModelAttribute("complaint")
			Complaint complaint,Map<String, Object> model) {

		Complaint complaintForm = new Complaint();
		model.put("complaintForm", complaintForm);
		
		model.put("complaintList", complaintService.getRoomHistoryComplaintList(complaint.getOrganization(),complaint.getRoomNumber()));

		return "room_history";
	}
	
	@RequestMapping(value = "/orgcomplaints")
	//Method to search complaint list by organization using request parameters
	public String ComplaintListByOrganization(
			@RequestParam("organization")
			String organization, Map<String, Object> model) {


		model.put("orgcomplaintList", complaintService
				.searchComplaints(organization));
		return "organizationcomplaints";
	}
	
}


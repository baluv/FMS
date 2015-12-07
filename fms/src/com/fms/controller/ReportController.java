package com.fms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fms.domain.Complaint;
import com.fms.domain.ComplaintDTO;
import com.fms.domain.ComplaintVoucher;
import com.fms.domain.Day2dayVehicleDetails;
import com.fms.service.ComplaintService;
import com.fms.service.VehicleService;

@Controller
@RequestMapping("/complaints")
public class ReportController {

	private static final Logger log = Logger.getLogger(ReportController.class);

	@Autowired(required = true)
	public ComplaintService complaintService;

	@Autowired(required = true)
	public VehicleService vehicleService;

	// Mapping web request path to method
	@RequestMapping(value = "/voucherInfo")
	// Method to get the voucher report
	public ModelAndView getVoucherInfo(Map<String, Object> model,
			@RequestParam("cid")
			Integer complaintId) {

		// ComplaintVoucher voucherForm = new ComplaintVoucher();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<ComplaintVoucher> list = complaintService
				.getVoucherList(complaintId);

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(list);

		parameterMap.put("datasource", JRdataSource);

		// pdfReport bean has ben declared in the jasper-views.xml file
		ModelAndView modelAndView = new ModelAndView("complaintvoucher",
				parameterMap);

		return modelAndView;

	}// gener

	@RequestMapping(value = "/DailyVehicleReport")
	public ModelAndView generatePdfReport1(ModelAndView modelAndView,
			@RequestParam("fromDate")
			String startdate, @RequestParam("endDate")
			String enddate) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<Day2dayVehicleDetails> usersList = vehicleService
				.getDailyVehicles(startdate, enddate);

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);
		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("pdfReport", parameterMap);

		return modelAndView;

	}// generatePdfReport

	// Mapping web request path to method
	@RequestMapping(value = "/byCategory")
	public String byCategoryReports(Map<String, Object> model) {

		return "by_category_reports";
	}

	@RequestMapping(value = "/byOrganization")
	public String byOrganizationReports(Map<String, Object> model) {

		return "by_organization_reports";
	}

	@RequestMapping(value = "/roomHistoryReport")
	public String roomHistoryReport(Map<String, Object> model) {

		return "room_history_reports";
	}

	@RequestMapping(value = "/complaintsbyorganization")
	public ModelAndView getComplaintReportsByOrganization(
			ModelAndView modelAndView, @RequestParam("organization")
			String organization, @RequestParam("status")
			String status, @RequestParam("month")
			String month, @RequestParam("year")
			String year) {

		log.debug("list:o" + organization + status + month + year);
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<Complaint> usersList = complaintService
				.getOpenOrganizationComplaints(organization, status, month,
						year);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);
		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("organizationCR", parameterMap);

		return modelAndView;

	}// generatePdfReport

	@RequestMapping(value = "/complaintsbycategry")
	public ModelAndView getComplaintReportsByCategory(
			ModelAndView modelAndView, @RequestParam("category")
			String category, @RequestParam("status")
			String status, @RequestParam("month")
			String month, @RequestParam("year")
			String year) {
		log.debug("list:c" + category + status + month + year);

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<Complaint> usersList = complaintService.getOpenCategoryComplaints(
				category, status, month, year);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);
		// pdfReport bean has ben declared in the jasper-views.xml file

		parameterMap.put("datasource", JRdataSource);
		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("categoryCR", parameterMap);

		return modelAndView;

	}// generatePdfReport

	@RequestMapping(value = "/roomhistorycomplaintreport")
	public ModelAndView getRoomComplaintHistoryReport(
			ModelAndView modelAndView, @RequestParam("organization")
			String organization, @RequestParam("roomNumber")
			String roomNumber, @RequestParam("month")
			String month, @RequestParam("year")
			String year) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<ComplaintDTO> usersList = complaintService
				.getRoomComplaintHistory(organization, roomNumber, month, year);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);
		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("roomHistoryCR", parameterMap);

		return modelAndView;

	}// generatePdfReport

	@RequestMapping(value = "/voucherreports")
	public String getVoucherReport(Map<String, Object> model) {

		return "voucher_reports";
	}

	@RequestMapping(value = "/voucherreport")
	public ModelAndView getVouhcersReport(ModelAndView modelAndView,
			String roomNumber, @RequestParam("month")
			String month, @RequestParam("year")
			String year) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<ComplaintVoucher> usersList = complaintService.getVouchersReport(
				month, year);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);
		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("vocuherreport", parameterMap);

		return modelAndView;

	}// generatePdfReport

	@RequestMapping(value = "/dailycomplaintreports")
	public String getdailycomplaintreport(Map<String, Object> model) {
		return "daily_complaint_report";

	}

	@RequestMapping(value = "/dailycomplaintsreports")
	public ModelAndView dailycomplaintreport(ModelAndView modelAndView,
			@RequestParam("organization")
			String organization, @RequestParam("status")
			String status, @RequestParam("currentDate")
			String currentDate) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<Complaint> complaintlist = complaintService
				.getdailycomplaintsreport(organization, status, currentDate);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(
				complaintlist);
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("dailycomplaintreport", parameterMap);

		return modelAndView;
	}

}

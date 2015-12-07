package com.fms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fms.domain.Login;
import com.fms.service.ComplaintService;
import com.fms.service.LoginService;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;

@Controller
@RequestMapping("/complaints")
public class LoginController {

	@Autowired(required = true)
	private LoginService loginService;

	@Autowired(required = true)
	private ComplaintService complaintService;

	private static final Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public String getLogin(Map<String, Object> model) {

		Login loginForm = new Login();
		model.put("loginForm", loginForm);
		return "login";
	}

	@RequestMapping(value = "/ahome")
	public String getAdminHome(ModelMap model) {
		model.put("ComplaintsByStatus", complaintService.getComplaintStatus());
		model.put("ComplaintsByCategory", complaintService
				.getComplaintsByCategory());
		model.put("ComplaintsByOrganization", complaintService
				.getComplaintsByOrganization());
		return "admin_home";
	}

	@RequestMapping(value = "/orghome")
	public String getOrganizationHome() {

		return "org_home";
	}

	@RequestMapping(value = "/checkLogin")
	public String getHome(@ModelAttribute("login")
	Login login, BindingResult result, HttpServletRequest request,
	ModelMap model) {
		HttpSession session = request.getSession();

		Login loginForm = new Login();
		model.put("loginForm", loginForm);
		log.info("Login::");
		if (result.hasErrors()) {
			return "login";
		} else {
			int check = loginService.checkLogin(login.getOrganization(), login
					.getUserid(), login.getPassword());
			if (check == 1) {
				session.setAttribute("organization", login.getOrganization());

				// request.setAttribute("complaintStatus",
				// complaintService.getComplaintStatus());
				model.put("ComplaintsByStatus", complaintService
						.getComplaintStatus());
				model.put("ComplaintsByCategory", complaintService
						.getComplaintsByCategory());
				model.put("ComplaintsByOrganization", complaintService
						.getComplaintsByOrganization());
				return "admin_home";

			} else if (check == 2) {
				session.setAttribute("organization", login.getOrganization());
				return "org_home";
			} else {
			}
			return "login";
		}

	}

	@RequestMapping(value = "/changepassword")
	public ModelAndView getchangepassword() {

		Login changepasswordForm = new Login();
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("changepasswordForm", changepasswordForm);
		return new ModelAndView("change_password", model);

	}

	@RequestMapping(value = "/passwordchange")
	public String changepassword(Map<String, Object> model,
			@RequestParam("organization")
	String organization, @RequestParam("oldPwd")
	String oldPwd, @RequestParam("newPwd")
	String newPwd) {
		Login loginForm = new Login();

		int check = loginService.changepassword(organization, oldPwd, newPwd);
		model.put("loginForm", loginForm);
		if (check == 1) {

			return "login";
		} else {
			return "change_password";
		}
	}

}

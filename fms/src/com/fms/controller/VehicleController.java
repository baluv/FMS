package com.fms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fms.domain.Day2dayVehicleDetails;
import com.fms.domain.ExistingVehicle;
import com.fms.domain.RefillingFuel;
import com.fms.domain.Vehicle;
import com.fms.exception.FMSGenericException;
import com.fms.service.VehicleService;

@Controller
@RequestMapping("/complaints")
public class VehicleController {
	@Autowired(required = true)
	public VehicleService vehicleService;

	@RequestMapping(value = "/newVehicle")
	public String getNewVehicleFrom(Map<String, Object> model) {

		Vehicle vehicleForm = new Vehicle();

		model.put("vehicleForm", vehicleForm);

		return "new_vehicle";
	}

	@RequestMapping(value = "/existingVehicle")
	public String getexistingVehiclefrom(Map<String, Object> model) {

		ExistingVehicle existingvehicleform = new ExistingVehicle();

		model.put("vehiclelist", vehicleService.getVehicles());
		model.put("existingvehicleform", existingvehicleform);

		return "existed_vehicle_details";
	}

	@RequestMapping(value = "/vehicleUpdateForm")
	public String getvehicleUpdateForm(Map<String, Object> model,
			@RequestParam("vehiclename")
			String vehiclename, @RequestParam("vehiclenumber")
			String vehiclenumber, @RequestParam("vehicletype")
			String vehicletype) {

		Vehicle updatevehicleForm = new Vehicle();
		updatevehicleForm.setVehiclename(vehiclename);
		updatevehicleForm.setVehiclenumber(vehiclenumber);
		updatevehicleForm.setVehicletype(vehicletype);
		// updatevehicleForm.setMileage(mileage);

		model.put("updatevehicleForm", updatevehicleForm);

		return "vehicle_update_form";
	}

	@RequestMapping(value = "/vehicleUpdate")
	public String vehicleUpdate(@ModelAttribute("vehicle")
	Vehicle vehicle, Map<String, Object> model) {
		Vehicle vehicleUpdateForm = new Vehicle();
		vehicleUpdateForm.setVehiclename(vehicle.getVehiclename());
		vehicleUpdateForm.setVehiclenumber(vehicle.getVehiclenumber());
		vehicleUpdateForm.setVehicletype(vehicle.getVehicletype());
		// vehicleUpdateForm.setMileage(vehicle.getMileage());
		try {
			vehicleService.updateVehicle(vehicle.getVehiclename(), vehicle
					.getVehiclenumber(), vehicle.getVehicletype());

		} catch (Exception ex) {
			throw new FMSGenericException(ex + "");
		}
		model.put("vehicleUpdateForm", vehicleUpdateForm);
		model.put("vehicleList", vehicleService.getVehicles());
		return "existedvehicles";
	}

	@RequestMapping(value = "/deleteVehicle")
	public String deleteVehicle(@RequestParam("vehiclenumber")
	String vehiclenumber, Map<String, Object> model) {

		Vehicle vehicleUpdateForm = new Vehicle();
		try {
			vehicleService.deleteVehicle(vehiclenumber);

		} catch (Exception ex) {
			throw new FMSGenericException(ex + "");
		}
		model.put("vehicleUpdateForm", vehicleUpdateForm);
		model.put("vehicleList", vehicleService.getVehicles());
		return "existedvehicles";
	}

	@RequestMapping(value = "/day2dayVehicle")
	public String getday2dayvehicledetails(Map<String, Object> model) {

		Day2dayVehicleDetails day2dayvehicleForm = new Day2dayVehicleDetails();
		model.put("vehiclelist", vehicleService.getVehicles());
		model.put("day2dayvehicleForm", day2dayvehicleForm);

		return "day2day_vehicle_details";
	}

	@RequestMapping(value = "/saveVehicle")
	public String saveNewVehicleInfo(@ModelAttribute("vehicle")
	Vehicle vehicle, Map<String, Object> model) {

		Vehicle vehicleForm = new Vehicle();
		try {
			vehicleService.insertNewVehicle(vehicle);
			model.put("successMessage", "New Vehicle  Saved Successfully..");
		} catch (Exception ex) {
			throw new FMSGenericException(ex + "");
		}

		model.put("vehicleForm", vehicleForm);

		return "new_vehicle";
	}

	@RequestMapping(value = "/saveExistingVehicle")
	public String saveExistingVehicleInfo(@ModelAttribute("existingvehicle")
	ExistingVehicle existingvehicle, Map<String, Object> model) {

		ExistingVehicle existingvehicleform = new ExistingVehicle();
		try {
			vehicleService.insertExistingVehicle(existingvehicle);

			model.put("successMessage",
					"Existing Vehicle  Saved Successfully..");
		} catch (Exception ex) {
			throw new FMSGenericException(ex + "");
		}

		model.put("vehiclelist", vehicleService.getVehicles());
		model.put("existingvehicleform", existingvehicleform);

		return "existed_vehicle_details";
	}

	@RequestMapping(value = "/saveDay2dayVehicle")
	public String saveday2dayvehicledetails(@ModelAttribute("day2dayvehicle")
	Day2dayVehicleDetails day2dayvehicle, Map<String, Object> model)
			throws FMSGenericException {

		Day2dayVehicleDetails day2dayvehicleForm = new Day2dayVehicleDetails();

		try {

			vehicleService.insertDailyVehicleDetails(day2dayvehicle);

		} catch (Exception ex) {
			throw new FMSGenericException(ex + "");
		}
		model.put("successMessage", "Daily Vehicle  Saved Successfully..");

		model.put("vehiclelist", vehicleService.getVehicles());
		model.put("day2dayvehicleForm", day2dayvehicleForm);
		// model.put("consumedFuel",vehicleService.getConsumedFuel(day2dayvehicle.getVehiclenumber(),day2dayvehicle.getInkm(),day2dayvehicle.getOutkm()));
		return "day2day_vehicle_details";
	}

	@RequestMapping(value = "/refillingfuel")
	public String getRefillingFuelForm(Map<String, Object> model) {
		RefillingFuel refillingFuelForm = new RefillingFuel();
		model.put("refillingFuelForm", refillingFuelForm);
		model.put("vehiclelist", vehicleService.getVehicles());

		return "refilling_fuel";
	}

	@RequestMapping(value = "/saveRefillingFuel")
	public String saveRefillingFuel(Map<String, Object> model,
			@ModelAttribute("refillingFuel")
			RefillingFuel refillingFuel) {

		RefillingFuel refillingFuelForm = new RefillingFuel();

		vehicleService.insertRefiilngFuel(refillingFuel);
		model.put("refillingFuelForm", refillingFuelForm);
		model.put("vehiclelist", vehicleService.getVehicles());

		model.put("msg", "Record Added Succussfully");
		return "refilling_fuel";

	}

	@RequestMapping(value = "/existingVehicleDetails")
	public String getvehicles(Map<String, Object> model) {

		model.put("vehicleList", vehicleService.getVehicles());

		return "existedvehicles";
	}

	@RequestMapping(value = "/VehicleServiceDetails")
	public String getvehicleservicelist(Map<String, Object> model) {

		model.put("vehicleserviceList", vehicleService.getVehicleServiceList());

		return "vehicle_service_details";
	}

	@RequestMapping(value = "/dailyVehicleDetailsInfo")
	public String getdailyvehiclelist(Map<String, Object> model) {

		model.put("dailyVehicleList", vehicleService.getDailyVehicleList());

		return "daily_vehicledetails_info";
	}

	@RequestMapping(value = "/vehicleReport")
	public String getVehicleReportForm(Map<String, Object> model) {

		return "vehicle_daily_report";
	}

	@RequestMapping(value = "/getDailyVehicleReport1")
	public ModelAndView generatePdfReport(ModelAndView modelAndView) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<Day2dayVehicleDetails> usersList = vehicleService
				.getDailyVehicleList();

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);

		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("xlsReport", parameterMap);

		return modelAndView;

	}// generatePdfReport

}

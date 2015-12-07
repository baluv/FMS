package com.fms.controller;

import java.util.HashMap;
import java.util.Iterator;
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

import com.fms.domain.Assets;
import com.fms.domain.ComplaintVoucher;
import com.fms.domain.GeneralAsset;
import com.fms.domain.Inward;
import com.fms.domain.InwardDTO;
import com.fms.domain.InwardQuantity;
import com.fms.domain.ItAsset;
import com.fms.domain.Outward;
import com.fms.domain.OutwardDTO;
import com.fms.domain.OutwardQuantity;
import com.fms.service.AssetService;
import com.fms.service.ComplaintService;

@Controller
@RequestMapping("/complaints")
public class AssetController {
	private static final Logger log = Logger.getLogger(AssetController.class);

	// Defining object for ComplaintService class
	@Autowired(required = true)
	public AssetService assetService;

	@RequestMapping(value = "/addnewroom")
	public String getNewRoom(Map<String, Object> model) {
		return "new_room";
	}

	@RequestMapping(value = "/adminnewroom")
	public String getadminNewRoom(Map<String, Object> model) {
		return "admin_newroom";
	}

	@RequestMapping(value = "/addnewmachine")
	public String getNewMachineForm(@RequestParam("organization")
	String organization, Map<String, Object> model) {

		ItAsset newMachineForm = new ItAsset();
		model.put("newMachineForm", newMachineForm);

		model.put("rooms", assetService.getRoomNumber(organization));
		return "new_machine";

	}

	@RequestMapping(value = "/adminnewmachine")
	public String getadminNewMachineForm(@RequestParam("organization")
	String organization, Map<String, Object> model) {

		ItAsset newMachineForm = new ItAsset();
		model.put("newMachineForm", newMachineForm);

		model.put("rooms", assetService.getRoomNumber(organization));
		return "admin_newmachine";

	}

	@RequestMapping(value = "/savenewroom")
	public String saveNewRoom(@ModelAttribute("generalasset")
	GeneralAsset generalasset, Map<String, Object> model) {

		assetService.insertnewRoom(generalasset);

		model.put("msg", "New Room Added successfully..");

		return "new_room";
	}

	@RequestMapping(value = "/saveadminnewroom")
	public String saveadminNewRoom(@ModelAttribute("generalasset")
	GeneralAsset generalasset, Map<String, Object> model) {

		assetService.insertnewRoom(generalasset);

		model.put("msg", "New Room Added successfully..");

		return "admin_newroom";
	}

	@RequestMapping(value = "/savenewmachine")
	public String saveNewMachine(@ModelAttribute("itAsset")
	ItAsset itAsset, Map<String, Object> model) {

		ItAsset newMachineForm = new ItAsset();
		assetService.insertbewMachine(itAsset);

		newMachineForm.setRoomNumber(itAsset.getRoomNumber());
		model.put("newMachineForm", newMachineForm);
		model.put("rooms", assetService
				.getRoomNumber(itAsset.getOrganization()));

		model.put("msg", "New Machine Added successfully..");

		return "new_machine";
	}

	@RequestMapping(value = "/saveadminnewmachine")
	public String saveadminNewMachine(@ModelAttribute("itAsset")
	ItAsset itAsset, Map<String, Object> model) {

		ItAsset newMachineForm = new ItAsset();
		assetService.insertbewMachine(itAsset);

		newMachineForm.setRoomNumber(itAsset.getRoomNumber());
		model.put("newMachineForm", newMachineForm);
		model.put("rooms", assetService
				.getRoomNumber(itAsset.getOrganization()));

		model.put("msg", "New Machine Added successfully..");

		return "admin_newmachine";
	}

	@RequestMapping(value = "/existingRoom")
	public String getExistingRoomDetails(Map<String, Object> model,
			@RequestParam("organization")
			String organization) {

		model
				.put("roomList", assetService
						.getExistingRoomDetails(organization));
		return "existing_room_details";
	}

	@RequestMapping(value = "/existingroomedetails")
	public String getadminExistingRoomDetails(Map<String, Object> model,
			@RequestParam("organization")
			String organization) {

		model
				.put("roomList", assetService
						.getExistingRoomDetails(organization));
		return "admin_existingrooms";
	}

	@RequestMapping(value = "/deleteRoom")
	public String deleteRoom(Map<String, Object> model,
			@RequestParam("generalassetid")
			int generalassetid, @RequestParam("organization")
			String organization) {

		assetService.deleteRoom(generalassetid, organization);
		model
				.put("roomList", assetService
						.getExistingRoomDetails(organization));
		return "existing_room_details";
	}

	@RequestMapping(value = "/admindeleteRoom")
	public String admindeleteRoom(Map<String, Object> model,
			@RequestParam("generalassetid")
			int generalassetid, @RequestParam("organization")
			String organization) {

		assetService.deleteRoom(generalassetid, organization);
		model
				.put("roomList", assetService
						.getExistingRoomDetails(organization));
		return "admin_existingrooms";
	}

	@RequestMapping(value = "/existingMachine")
	public String getExistingMachineDetails(Map<String, Object> model,
			@RequestParam("organization")
			String organization) {

		model.put("machineList", assetService
				.getExistingMachineDetails(organization));
		return "existing_machine_details";

	}

	@RequestMapping(value = "/existingmachinedetails")
	public String getadminExistingMachineDetails(Map<String, Object> model,
			@RequestParam("organization")
			String organization) {

		model.put("machineList", assetService
				.getExistingMachineDetails(organization));
		return "admin_existingmachines";

	}

	@RequestMapping(value = "/deleteMachine")
	public String deleteMachine(Map<String, Object> model,
			@RequestParam("itassetid")
			int itassetid, String organization) {

		assetService.deleteMacine(itassetid, organization);
		model.put("machineList", assetService
				.getExistingMachineDetails(organization));
		return "existing_machine_details";
	}

	@RequestMapping(value = "/admindeleteMachine")
	public String admindeleteMachine(Map<String, Object> model,
			@RequestParam("itassetid")
			int itassetid, String organization) {

		assetService.deleteMacine(itassetid, organization);
		model.put("machineList", assetService
				.getExistingMachineDetails(organization));
		return "admin_existingmachines";
	}

	@RequestMapping(value = "/updateMachine")
	public String updateMachine(Map<String, Object> model,
			@RequestParam("itassetid")
			int itassetid, @RequestParam("machinetype")
			String machinetype, @RequestParam("machine")
			String machine, @RequestParam("roomNumber")
			String roomNumber, @RequestParam("description")
			String description) {

		ItAsset updateMachineForm = new ItAsset();
		updateMachineForm.setItassetid(itassetid);
		updateMachineForm.setMachinetype(machinetype);
		updateMachineForm.setMachine(machine);
		updateMachineForm.setRoomNumber(roomNumber);
		updateMachineForm.setDescription(description);
		model.put("updateMachineForm", updateMachineForm);

		return "update_machine";

	}

	@RequestMapping(value = "/adminupdateMachine")
	public String adminupdateMachine(Map<String, Object> model,
			@RequestParam("itassetid")
			int itassetid, @RequestParam("machinetype")
			String machinetype, @RequestParam("machine")
			String machine, @RequestParam("roomNumber")
			String roomNumber, @RequestParam("description")
			String description) {

		ItAsset updateMachineForm = new ItAsset();
		updateMachineForm.setItassetid(itassetid);
		updateMachineForm.setMachinetype(machinetype);
		updateMachineForm.setMachine(machine);
		updateMachineForm.setRoomNumber(roomNumber);
		updateMachineForm.setDescription(description);
		model.put("updateMachineForm", updateMachineForm);

		return "admin_updatemachine";

	}

	@RequestMapping(value = "/machineUpdated")
	public String machineupdated(Map<String, Object> model,
			@ModelAttribute("itAsset")
			ItAsset itAsset) {

		ItAsset updateMachineForm = new ItAsset();
		// ItAsset newMachineForm = new ItAsset();
		updateMachineForm.setItassetid(itAsset.getItassetid());
		updateMachineForm.setMachinetype(itAsset.getMachinetype());
		updateMachineForm.setMachine(itAsset.getMachine());
		updateMachineForm.setRoomNumber(itAsset.getRoomNumber());
		updateMachineForm.setDescription(itAsset.getDescription());

		assetService.updateMachine(itAsset.getItassetid(), itAsset
				.getMachinetype(), itAsset.getMachine(), itAsset
				.getRoomNumber(), itAsset.getDescription());
		model.put("updateMachineForm", updateMachineForm);
		model.put("msg", "updated successfully");
		return "update_machine";

	}

	@RequestMapping(value = "/adminmachineUpdated")
	public String adminmachineupdated(Map<String, Object> model,
			@ModelAttribute("itAsset")
			ItAsset itAsset) {

		ItAsset updateMachineForm = new ItAsset();
		// ItAsset newMachineForm = new ItAsset();
		updateMachineForm.setItassetid(itAsset.getItassetid());
		updateMachineForm.setMachinetype(itAsset.getMachinetype());
		updateMachineForm.setMachine(itAsset.getMachine());
		updateMachineForm.setRoomNumber(itAsset.getRoomNumber());
		updateMachineForm.setDescription(itAsset.getDescription());

		assetService.updateMachine(itAsset.getItassetid(), itAsset
				.getMachinetype(), itAsset.getMachine(), itAsset
				.getRoomNumber(), itAsset.getDescription());
		model.put("updateMachineForm", updateMachineForm);
		model.put("msg", "updated successfully");
		return "admin_updatemachine";

	}

	@RequestMapping(value = "/updateRoom")
	public String updateRoom(Map<String, Object> model,
			@RequestParam("generalassetid")
			int generalassetid, @RequestParam("roomNumber")
			String roomNumber) {
		GeneralAsset updateRoomForm = new GeneralAsset();

		updateRoomForm.setGeneralassetid(generalassetid);
		updateRoomForm.setRoomNumber(roomNumber);
		model.put("updateRoomForm", updateRoomForm);
		return "update_room";
	}

	@RequestMapping(value = "/adminupdateRoom")
	public String adminupdateRoom(Map<String, Object> model,
			@RequestParam("generalassetid")
			int generalassetid, @RequestParam("roomNumber")
			String roomNumber) {
		GeneralAsset updateRoomForm = new GeneralAsset();

		updateRoomForm.setGeneralassetid(generalassetid);
		updateRoomForm.setRoomNumber(roomNumber);
		model.put("updateRoomForm", updateRoomForm);
		return "admin_updateroom";
	}

	@RequestMapping(value = "/roomUpdated")
	public String roomUpdated(Map<String, Object> model,
			@ModelAttribute("generalAsset")
			GeneralAsset generalAsset) {
		GeneralAsset updateRoomForm = new GeneralAsset();
		updateRoomForm.setGeneralassetid(generalAsset.getGeneralassetid());
		updateRoomForm.setRoomNumber(generalAsset.getRoomNumber());
		assetService.updateRoom(generalAsset.getGeneralassetid(), generalAsset
				.getRoomNumber());
		model.put("updateRoomForm", updateRoomForm);
		model.put("msg", "updated successfully");
		return "update_room";

	}

	@RequestMapping(value = "/adminroomUpdated")
	public String adminroomUpdated(Map<String, Object> model,
			@ModelAttribute("generalAsset")
			GeneralAsset generalAsset) {
		GeneralAsset updateRoomForm = new GeneralAsset();
		updateRoomForm.setGeneralassetid(generalAsset.getGeneralassetid());
		updateRoomForm.setRoomNumber(generalAsset.getRoomNumber());
		assetService.updateRoom(generalAsset.getGeneralassetid(), generalAsset
				.getRoomNumber());
		model.put("updateRoomForm", updateRoomForm);
		model.put("msg", "updated successfully");
		return "admin_updateroom";
	}

	@RequestMapping(value = "/addnewitem")
	public String getNewItemForm(@RequestParam("organization")
	String organization, Map<String, Object> model) {

		GeneralAsset newItemForm = new GeneralAsset();
		model.put("newItemForm", newItemForm);

		model.put("rooms", assetService.getRoomNumber(organization));
		return "new_item";

	}

	@RequestMapping(value = "/adminnewitem")
	public String getNewadminItemForm(Map<String, Object> model,
			@RequestParam("organization")
			String organization) {
		GeneralAsset adminnewItemForm = new GeneralAsset();
		model.put("adminnewItemForm", adminnewItemForm);

		model.put("rooms", assetService.getRoomNumber(organization));
		return "admin_newitem";

	}

	@RequestMapping(value = "/savenewasset")
	public String insertNewItems(@RequestParam("organization")
	String organization, @RequestParam("roomNumber")
	String roomNumber, @RequestParam("itemName")
	String itemName, @RequestParam("itemCount")
	int itemCount, Map<String, Object> model) {

		assetService.insertnewAsset(organization, roomNumber, itemName,
				itemCount);
		GeneralAsset newItemForm = new GeneralAsset();
		newItemForm.setRoomNumber(roomNumber);
		model.put("newItemForm", newItemForm);
		model.put("msg", "New Asset Saved successfully...");
		model.put("rooms", assetService.getRoomNumber(organization));
		return "new_item";

	}

	@RequestMapping(value = "/saveadminnewasset")
	public String saveadminnewasset(@RequestParam("organization")
	String organization, @RequestParam("roomNumber")
	String roomNumber, @RequestParam("itemName")
	String itemName, @RequestParam("itemCount")
	int itemCount, Map<String, Object> model) {

		assetService.insertnewAsset(organization, roomNumber, itemName,
				itemCount);
		GeneralAsset adminnewItemForm = new GeneralAsset();
		adminnewItemForm.setRoomNumber(roomNumber);
		model.put("adminnewItemForm", adminnewItemForm);
		model.put("msg", "New Asset Saved successfully...");
		model.put("rooms", assetService.getRoomNumber(organization));

		return "admin_newitem";

	}

	@RequestMapping(value = "/existingRoomsDetails")
	public String getExistingrooms(@RequestParam("organization")
	String organization, Map<String, Object> model) {

		model
				.put("roomList", assetService
						.getExistingRoomDetails(organization));
		return "orgexistingassets";
	}

	@RequestMapping(value = "/adminexistingitems")
	public String getadminExistingRooms(Map<String, Object> model,
			@RequestParam("organization")
			String organization) {
		model
				.put("roomList", assetService
						.getExistingRoomDetails(organization));

		return "admin_existingItems";
	}

	@RequestMapping(value = "/viewroomassets")
	public String viewroomassets(@RequestParam("generalassetid")
	int generalassetid, @RequestParam("roomNumber")
	String roomNumber, Map<String, Object> model) {

		model.put("roomNumber", roomNumber);
		model.put("assetList", assetService.getRoomAssets(generalassetid));
		return "roomassetdetails";
	}

	@RequestMapping(value = "/adminviewroomassets")
	public String adminviewroomassets(@RequestParam("generalassetid")
	int generalassetid, @RequestParam("roomNumber")
	String roomNumber, Map<String, Object> model) {
		model.put("roomNumber", roomNumber);
		model.put("assetList", assetService.getRoomAssets(generalassetid));
		return "admin_roomassetdetails";
	}

	@RequestMapping(value = "/editroomassetform")
	public String editroomassetsform(@RequestParam("id")
	int id, @RequestParam("itemName")
	String itemName, @RequestParam("itemCount")
	int itemCount, Map<String, Object> model) {

		Assets newItemForm = new Assets();

		newItemForm.setId(id);
		newItemForm.setItemName(itemName);
		newItemForm.setItemCount(itemCount);
		model.put("newItemForm", newItemForm);
		return "editroomasset";
	}

	@RequestMapping(value = "/admineditroomassetform")
	public String admineditassetform(@RequestParam("id")
	int id, @RequestParam("itemName")
	String itemName, @RequestParam("itemCount")
	int itemCount, Map<String, Object> model) {
		Assets newItemForm = new Assets();

		newItemForm.setId(id);
		newItemForm.setItemName(itemName);
		newItemForm.setItemCount(itemCount);
		model.put("newItemForm", newItemForm);
		return "admin_editassetform";

	}

	@RequestMapping(value = "/editsavenewasset")
	public String editroomassets(@RequestParam("id")
	int id, @RequestParam("itemName")
	String itemName, @RequestParam("itemCount")
	int itemCount, Map<String, Object> model) {

		Assets newItemForm = new Assets();

		newItemForm.setId(id);
		newItemForm.setItemName(itemName);
		newItemForm.setItemCount(itemCount);

		assetService.editRoomAsset(id, itemName, itemCount);

		model.put("newItemForm", newItemForm);
		model.put("msg", "Updated successfully..");
		return "editroomasset";
	}

	@RequestMapping(value = "/admineditsavenewasset")
	public String admineditroomassets(@RequestParam("id")
	int id, @RequestParam("itemName")
	String itemName, @RequestParam("itemCount")
	int itemCount, Map<String, Object> model) {

		Assets newItemForm = new Assets();

		newItemForm.setId(id);
		newItemForm.setItemName(itemName);
		newItemForm.setItemCount(itemCount);

		assetService.editRoomAsset(id, itemName, itemCount);

		model.put("newItemForm", newItemForm);
		model.put("msg", "Updated successfully..");
		return "admin_editassetform";
	}

	@RequestMapping(value = "/deleteroomasset")
	public String deleteroomassets(@RequestParam("id")
	int id, Map<String, Object> model) {

		assetService.deleteRoomAsset(id);

		model.put("msg", "Room Asset Deleted Successfully...");
		return "success";
	}

	@RequestMapping(value = "/admindeleteroomasset")
	public String admindeleteroomassets(@RequestParam("id")
	int id, Map<String, Object> model) {

		assetService.deleteRoomAsset(id);

		model.put("msg", "Room Asset Deleted Successfully...");
		return "admin_success";
	}

	@RequestMapping(value = "/inwardreturnable")
	public String getInwardReturnableForm(Map<String, Object> model) {
		Inward inwardForm = new Inward();
		model.put("inwardForm", inwardForm);
		return "inward_returnable";
	}

	@RequestMapping(value = "/outwardreturnable")
	public String getOutwardReturnableForm(Map<String, Object> model) {
		Outward outwardForm = new Outward();
		model.put("outwardForm", outwardForm);
		return "outward_returnable";
	}

	@RequestMapping(value = "/inwardsave")
	public String saveinward(Map<String, Object> model,
			@ModelAttribute("inward")
			Inward inward)

	{

		InwardQuantity inwardquantityForm = new InwardQuantity();

		assetService.saveInward(inward);
		// inwardquantityForm.setInwardid(inwardid)(inward.getTowhere());
		model.put("inwardquantityForm", inwardquantityForm);
		inwardquantityForm.setInwardid(inward.getId());
		// model.put("id",inward.getId());
		// model.put("msg","Inward saved successfully");
		return "inward_quantity";
	}

	@RequestMapping(value = "/savequantity")
	public String saveQuantity(Map<String, Object> model,
			@ModelAttribute("inwardquantity")
			InwardQuantity inwardquantity, @RequestParam("inwardid")
			int inwardid) {

		InwardQuantity inwardquantityForm = new InwardQuantity();
		assetService.savequantity(inwardquantity);

		model.put("inwardquantityForm", inwardquantityForm);
		inwardquantityForm.setInwardid(inwardid);
		// model.put("id",inward.getId());
		model.put("msg", "Inward saved successfully");
		return "inward_quantity";
	}

	@RequestMapping(value = "/saveoutward")
	public String saveoutward(Map<String, Object> model,
			@ModelAttribute("outward")
			Outward outward) {
		OutwardQuantity outwardquantityForm = new OutwardQuantity();
		model.put("outwardquantityForm", outwardquantityForm);
		assetService.saveOutward(outward);
		model.put("id", outward.getId());
		// model.put("msg", "outward saved successfully");
		return "outward_quantity";
	}

	@RequestMapping(value = "/saveoutwardquantity")
	public String saveoutwardquantity(Map<String, Object> model,
			@ModelAttribute("outwardquantity")
			OutwardQuantity outwardquantity, @RequestParam("outwardid")
			int outwardid) {
		OutwardQuantity outwardquantityForm = new OutwardQuantity();
		assetService.saveoutwardquantity(outwardquantity);
		model.put("outwardquantityForm", outwardquantityForm);
		model.put("id", outwardid);
		model.put("msg", "outward saved successfully");
		return "outward_quantity";
	}

	@RequestMapping(value = "/inwardreturnableinfo")
	public String returnableinfo(Map<String, Object> model,
			@ModelAttribute("inward")
			Inward inward, @RequestParam("type")
			String type) {
		Inward inwardInfoForm = new Inward();
		model.put("inwardInfoForm", inwardInfoForm);

		model.put("InwardList", assetService.getInwardinfo(type));
		return "inward_returnableinfo";
	}

	@RequestMapping(value = "/inwardnonreturnableinfo")
	public String nonreturnableinfo(Map<String, Object> model,
			@ModelAttribute("inward")
			Inward inward, @RequestParam("type")
			String type) {
		Inward inwardInfoForm = new Inward();
		model.put("inwardInfoForm", inwardInfoForm);

		model.put("InwardList", assetService.getInwardinfo(type));
		return "inward_nonreturnableinfo";
	}

	@RequestMapping(value = "/inwardreturnablequantity")
	public String viewquantity(Map<String, Object> model, @RequestParam("id")
	int id) {
		model.put("quantityList", assetService.viewquantity(id));
		return "inwardreturnable_quantity_info";
	}

	@RequestMapping(value = "/inwardnonreturnablequantity")
	public String viewquantitydetails(Map<String, Object> model,
			@RequestParam("id")
			int id) {
		model.put("quantityList", assetService.viewquantity(id));
		return "inwardreturnable_quantity_info";
	}

	@RequestMapping(value = "/outwardreturnableinfo")
	public String outwardreturnableinfo(Map<String, Object> model,
			@RequestParam("type")
			String type) {
		model.put("OutwardList", assetService.getOutwardinfo(type));
		return "outward_returnableinfo";
	}

	@RequestMapping(value = "/outwardnonreturnableinfo")
	public String outwardnonreturnableinfo(Map<String, Object> model,
			@RequestParam("type")
			String type) {
		model.put("OutwardList", assetService.getOutwardinfo(type));
		return "outward_nonreturnableinfo";
	}

	@RequestMapping(value = "/outwardreturnablequantity")
	public String viewretunquantitydetails(Map<String, Object> model,
			@RequestParam("id")
			int id) {
		model.put("quantityList", assetService.outwardquantity(id));
		return "outward_quantity_info";
	}

	@RequestMapping(value = "/outwardnonreturnablequantity")
	public String viewnonretunquantitydetails(Map<String, Object> model,
			@RequestParam("id")
			int id) {
		model.put("quantityList", assetService.outwardquantity(id));
		return "outward_quantity_info";
	}

	@RequestMapping(value = "/deleteinwardreturnablequantity")
	public String deleteinwardreturnablequantity(Map<String, Object> model,
			@RequestParam("id")
			int id) {

		assetService.deleteinwardquantity(id);

		model.put("quantityList", assetService.viewquantity(id));
		model.put("msg", "Record deleted successfully");

		return "admin_success";
	}

	@RequestMapping(value = "/deleteinwardnonreturnablequantity")
	public String deleteinwardnonreturnablequantity(Map<String, Object> model,
			@RequestParam("id")
			int id) {
		InwardQuantity inwardquantityForm = new InwardQuantity();
		assetService.deleteinwardquantity(id);
		model.put("inwardquantityForm", inwardquantityForm);
		// assetService.viewquantity(id);
		model.put("quantityList", assetService.viewquantity(id));
		model.put("msg", "Record deleted successfully");

		return "admin_success";
	}

	@RequestMapping(value = "/deleteoutwardquantity")
	public String deleteoutwardquantity(Map<String, Object> model,
			@RequestParam("id")
			int id) {
		assetService.deleteoutwardquantity(id);
		model.put("quantityList", assetService.outwardquantity(id));
		model.put("msg", "Record deleted successfully");

		return "admin_success";
	}

	@RequestMapping(value = "/updateinward")
	public String getupdateinward(Map<String, Object> model,
			@RequestParam("id")
			int id, @RequestParam("date")
			String date, @RequestParam("invoicenumber")
			String invoicenumber, @RequestParam("fromwhere")
			String fromwhere, @RequestParam("towhere")
			String towhere, @RequestParam("edate")
			String edate, @RequestParam("rdate")
			String rdate, @RequestParam("takenby")
			String takenby) {
		Inward inwardupdateForm = new Inward();
		inwardupdateForm.setId(id);
		inwardupdateForm.setDate(date);
		inwardupdateForm.setInvoicenumber(invoicenumber);
		inwardupdateForm.setFromwhere(fromwhere);
		inwardupdateForm.setTowhere(towhere);
		inwardupdateForm.setEdate(edate);
		inwardupdateForm.setRdate(rdate);
		inwardupdateForm.setTakenby(takenby);
		model.put("inwardupdateForm", inwardupdateForm);
		return "update_inward_form";
	}

	@RequestMapping(value = "/inwardupdated")
	public String updateinward(Map<String, Object> model,
			@ModelAttribute("inward")
			Inward inward) {
		Inward inwardupdateForm = new Inward();
		inwardupdateForm.setId(inward.getId());
		inwardupdateForm.setDate(inward.getDate());
		inwardupdateForm.setInvoicenumber(inward.getInvoicenumber());
		inwardupdateForm.setFromwhere(inward.getFromwhere());
		inwardupdateForm.setTowhere(inward.getTowhere());
		inwardupdateForm.setEdate(inward.getEdate());
		inwardupdateForm.setRdate(inward.getRdate());
		inwardupdateForm.setTakenby(inward.getTakenby());

		assetService.updateinward(inward.getId(), inward.getDate(), inward
				.getInvoicenumber(), inward.getFromwhere(),
				inward.getTowhere(), inward.getEdate(), inward.getRdate(),
				inward.getTakenby());
		model.put("inwardupdateForm", inwardupdateForm);
		model.put("msg", "inward returnable updated successfully");
		return "update_inward_form";
	}

	@RequestMapping(value = "/updateinwardnonreturnable")
	public String getupdateinwardnonreturnable(Map<String, Object> model,
			@RequestParam("id")
			int id, @RequestParam("date")
			String date, @RequestParam("invoicenumber")
			String invoicenumber, @RequestParam("fromwhere")
			String fromwhere, @RequestParam("towhere")
			String towhere) {
		Inward updateinwardnonreturnableForm = new Inward();
		updateinwardnonreturnableForm.setId(id);
		updateinwardnonreturnableForm.setDate(date);
		updateinwardnonreturnableForm.setInvoicenumber(invoicenumber);
		updateinwardnonreturnableForm.setFromwhere(fromwhere);
		updateinwardnonreturnableForm.setTowhere(towhere);
		model.put("updateinwardnonreturnableForm",
				updateinwardnonreturnableForm);
		return "update_inwardnonreturnable";
	}

	@RequestMapping(value = "/inwardnonreturnableupdated")
	public String inwardnonreturnableupdated(Map<String, Object> model,
			@ModelAttribute("inward")
			Inward inward) {
		Inward updateinwardnonreturnableForm = new Inward();
		updateinwardnonreturnableForm.setId(inward.getId());
		updateinwardnonreturnableForm.setDate(inward.getDate());
		updateinwardnonreturnableForm.setInvoicenumber(inward
				.getInvoicenumber());
		updateinwardnonreturnableForm.setFromwhere(inward.getFromwhere());
		updateinwardnonreturnableForm.setTowhere(inward.getTowhere());
		assetService.updateinwardnonreturnable(inward.getId(),
				inward.getDate(), inward.getInvoicenumber(), inward
						.getFromwhere(), inward.getTowhere());

		model.put("updateinwardnonreturnableForm",
				updateinwardnonreturnableForm);
		model.put("msg", "inward nonreturnable updated successfully");
		return "update_inwardnonreturnable";

	}

	@RequestMapping(value = "/updateoutward")
	public String getupdateoutward(Map<String, Object> model,
			@RequestParam("id")
			int id, @RequestParam("date")
			String date, @RequestParam("gatepass")
			String gatepass, @RequestParam("fromwhere")
			String fromwhere, @RequestParam("towhere")
			String towhere, @RequestParam("edate")
			String edate, @RequestParam("rdate")
			String rdate, @RequestParam("authorizedby")
			String authorizedby) {
		Outward outwardupdateForm = new Outward();
		outwardupdateForm.setId(id);
		outwardupdateForm.setDate(date);
		outwardupdateForm.setGatepass(gatepass);
		outwardupdateForm.setFromwhere(fromwhere);
		outwardupdateForm.setTowhere(towhere);
		outwardupdateForm.setEdate(edate);
		outwardupdateForm.setRdate(rdate);
		outwardupdateForm.setAuthorizedby(authorizedby);
		model.put("outwardupdateForm", outwardupdateForm);
		return "update_outward_form";
	}

	@RequestMapping(value = "/outwardupdated")
	public String outwardupdated(Map<String, Object> model,
			@ModelAttribute("outward")
			Outward outward) {
		Outward outwardupdateForm = new Outward();
		outwardupdateForm.setId(outward.getId());
		outwardupdateForm.setDate(outward.getDate());
		outwardupdateForm.setGatepass(outward.getGatepass());
		outwardupdateForm.setFromwhere(outward.getFromwhere());
		outwardupdateForm.setTowhere(outward.getTowhere());
		outwardupdateForm.setEdate(outward.getEdate());
		outwardupdateForm.setRdate(outward.getRdate());
		outwardupdateForm.setAuthorizedby(outward.getAuthorizedby());
		assetService.updateoutward(outward.getId(), outward.getDate(), outward
				.getGatepass(), outward.getFromwhere(), outward.getTowhere(),
				outward.getEdate(), outward.getRdate(), outward
						.getAuthorizedby());
		model.put("outwardupdateForm", outwardupdateForm);
		model.put("msg", "outward returnable updated successfully");
		return "update_outward_form";

	}

	@RequestMapping(value = "/updateoutwardnonreturnable")
	public String getupdateoutwardnonreturnable(Map<String, Object> model,
			@RequestParam("id")
			int id, @RequestParam("date")
			String date, @RequestParam("gatepass")
			String gatepass, @RequestParam("fromwhere")
			String fromwhere, @RequestParam("towhere")
			String towhere) {
		Outward updateoutwardnonreturnableForm = new Outward();
		updateoutwardnonreturnableForm.setId(id);
		updateoutwardnonreturnableForm.setDate(date);
		updateoutwardnonreturnableForm.setGatepass(gatepass);
		updateoutwardnonreturnableForm.setFromwhere(fromwhere);
		updateoutwardnonreturnableForm.setTowhere(towhere);
		model.put("updateoutwardnonreturnableForm",
				updateoutwardnonreturnableForm);
		return "update_outwardnonreturnable";
	}

	@RequestMapping(value = "/outwardnonreturnableupdated")
	public String outwardnonreturnableupdated(Map<String, Object> model,
			@ModelAttribute("outward")
			Outward outward) {

		Outward updateoutwardnonreturnableForm = new Outward();
		updateoutwardnonreturnableForm.setId(outward.getId());
		updateoutwardnonreturnableForm.setDate(outward.getDate());
		updateoutwardnonreturnableForm.setGatepass(outward.getGatepass());
		updateoutwardnonreturnableForm.setFromwhere(outward.getFromwhere());
		updateoutwardnonreturnableForm.setTowhere(outward.getTowhere());
		assetService.updateoutwardnonreturnable(outward.getId(), outward
				.getDate(), outward.getGatepass(), outward.getFromwhere(),
				outward.getTowhere());
		model.put("updateoutwardnonreturnableForm",
				updateoutwardnonreturnableForm);
		model.put("msg", "outward nonreturnable updated successfully");
		return "update_outwardnonreturnable";
	}

	@RequestMapping(value = "/updateinwardreturnablequantity")
	public String getupdateinwardquantity(Map<String, Object> model,
			@RequestParam("id")
			int id, @RequestParam("itemname")
			String itemname, @RequestParam("quantity")
			int quantity) {
		InwardQuantity updateinwardquantityForm = new InwardQuantity();
		updateinwardquantityForm.setId(id);
		updateinwardquantityForm.setItemname(itemname);
		updateinwardquantityForm.setQuantity(quantity);
		model.put("updateinwardquantityForm", updateinwardquantityForm);
		return "update_inwardreturnable_quantity";
	}

	@RequestMapping(value = "/inwardreturnablequantityupdated")
	public String inwardquantityupdated(Map<String, Object> model,
			@ModelAttribute("inwardquantity")
			InwardQuantity inwardquantity) {
		InwardQuantity updateinwardquantityForm = new InwardQuantity();
		updateinwardquantityForm.setId(inwardquantity.getId());
		updateinwardquantityForm.setItemname(inwardquantity.getItemname());
		updateinwardquantityForm.setQuantity(inwardquantity.getQuantity());
		assetService.updateinwardquantity(inwardquantity.getId(),
				inwardquantity.getItemname(), inwardquantity.getQuantity());
		model.put("updateinwardquantityForm", updateinwardquantityForm);
		return "update_inwardreturnable_quantity";
	}

	@RequestMapping(value = "/updateinwardnonreturnablequantity")
	public String getupdateinwardnonreturnable(Map<String, Object> model,
			@RequestParam("id")
			int id, @RequestParam("itemname")
			String itemname, @RequestParam("quantity")
			int quantity) {
		InwardQuantity updateinwardnonreturnablequantityForm = new InwardQuantity();
		updateinwardnonreturnablequantityForm.setId(id);
		updateinwardnonreturnablequantityForm.setItemname(itemname);
		updateinwardnonreturnablequantityForm.setQuantity(quantity);
		model.put("updateinwardnonreturnablequantityForm",
				updateinwardnonreturnablequantityForm);
		return "update_inwardnonreturnable_quantity";

	}

	@RequestMapping(value = "/inwardnonreturnablequantityupdated")
	public String inwardnonreturnablequantityupdated(Map<String, Object> model,
			@ModelAttribute("inwardquantity")
			InwardQuantity inwardquantity) {
		InwardQuantity updateinwardnonreturnablequantityForm = new InwardQuantity();
		updateinwardnonreturnablequantityForm.setId(inwardquantity.getId());
		updateinwardnonreturnablequantityForm.setItemname(inwardquantity
				.getItemname());
		updateinwardnonreturnablequantityForm.setQuantity(inwardquantity
				.getQuantity());
		assetService.updateinwardquantity(inwardquantity.getId(),
				inwardquantity.getItemname(), inwardquantity.getQuantity());
		model.put("updateinwardnonreturnablequantityForm",
				updateinwardnonreturnablequantityForm);
		model.put("msg", "inward quantity updated successfully");
		return "update_inwardnonreturnable_quantity";

	}

	@RequestMapping(value = "/updateoutwardreturnablequantity")
	public String getupdateoutwardreturnable(Map<String, Object> model,
			@RequestParam("id")
			int id, @RequestParam("itemname")
			String itemname, @RequestParam("quantity")
			int quantity) {
		OutwardQuantity updateoutwardreturnablequantity = new OutwardQuantity();
		updateoutwardreturnablequantity.setId(id);
		updateoutwardreturnablequantity.setItemname(itemname);
		updateoutwardreturnablequantity.setQuantity(quantity);
		model.put("updateoutwardreturnablequantity",
				updateoutwardreturnablequantity);
		return "update_outwardreturnable_quantity";
	}

	@RequestMapping(value = "/outwardreturnablequantityupdated")
	public String outwardreturnablequantityupdated(Map<String, Object> model,
			@ModelAttribute("outwardquantity")
			OutwardQuantity outwardquantity) {
		OutwardQuantity updateoutwardreturnablequantity = new OutwardQuantity();
		updateoutwardreturnablequantity.setId(outwardquantity.getId());
		updateoutwardreturnablequantity.setItemname(outwardquantity
				.getItemname());
		updateoutwardreturnablequantity.setQuantity(outwardquantity
				.getQuantity());
		assetService.updateoutwardquantity(outwardquantity.getId(),
				outwardquantity.getItemname(), outwardquantity.getQuantity());
		model.put("updateoutwardreturnablequantity",
				updateoutwardreturnablequantity);
		model.put("msg", "outward quantity updated successfully");
		return "update_outwardreturnable_quantity";
	}

	@RequestMapping(value = "/inwardreport")
	public String getInwardReportForm(Map<String, Object> model) {
		return "inward_reports";

	}

	@RequestMapping(value = "/outwardreport")
	public String getOutwardReportForm(Map<String, Object> model) {
		return "outward_reports";
	}

	@RequestMapping(value = "/getinwardreport")
	public ModelAndView getInwardReturnableReport(Map<String, Object> model,
			@RequestParam("type")
			String type, @RequestParam("month")
			String month, @RequestParam("year")
			String year) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		ModelAndView modelAndView;

		List<InwardDTO> list = assetService.getInwardreport(type, month, year);

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(list);

		parameterMap.put("datasource", JRdataSource);

		if (type.equals("Returnable")) {
			// /{
			// pdfReport bean has ben declared in the jasper-views.xml file
			modelAndView = new ModelAndView("inwardreturnble1", parameterMap);
		} else

		{

			// /{
			// pdfReport bean has ben declared in the jasper-views.xml file
			modelAndView = new ModelAndView("inwardnonreturnble1", parameterMap);
		}
		// {
		// modelAndView = new ModelAndView("inwardnonreturnable",
		// parameterMap);
		// }

		return modelAndView;

	}

	@RequestMapping(value = "/getoutwardreport")
	public ModelAndView getOutWardReport(Map<String, Object> model,
			@RequestParam("type")
			String type, @RequestParam("month")
			String month, @RequestParam("year")
			String year) {

	
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<OutwardDTO> list = assetService
				.getOutwardReport(type, month, year);

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(list);

		parameterMap.put("datasource", JRdataSource);
		ModelAndView modelAndView;
		if (type.equals("Returnable")) {
			// pdfReport bean has ben declared in the jasper-views.xml file
			modelAndView = new ModelAndView("outwardreturnable", parameterMap);
		} else {
			Iterator i = list.iterator();
			while (i.hasNext()) {
				OutwardDTO o = (OutwardDTO) i.next();

			}
			modelAndView = new ModelAndView("outwardnonreturnable",
					parameterMap);
		}

		return modelAndView;

	}

}

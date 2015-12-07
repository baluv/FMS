package com.fms.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.dao.AssetDao;
import com.fms.domain.Assets;
import com.fms.domain.GeneralAsset;
import com.fms.domain.Inward;
import com.fms.domain.InwardDTO;
import com.fms.domain.InwardQuantity;
import com.fms.domain.ItAsset;
import com.fms.domain.Outward;
import com.fms.domain.OutwardDTO;
import com.fms.domain.OutwardQuantity;

@Service("AssetService")
@Transactional
public class AssetServiceImpl implements AssetService {

	@Autowired(required = true)
	public AssetDao assetDao;
	public void insertnewRoom(GeneralAsset generalasset) {
		
		assetDao.insertnewRoom(generalasset);
	}
	
	public List getRoomNumber(String organization){
		System.out.println("availableroom");
		return assetDao.getRoomNumber(organization);
	}
	public void insertbewMachine(ItAsset itAsset){
		
		assetDao.insertbewMachine(itAsset);
	}
	public List<GeneralAsset> getExistingRoomDetails(String organization)
	{
		return assetDao.getExistingRoomDetails(organization);
	}
	public void deleteRoom(int generalassetid,String organization)
	{
		assetDao.deleteRoom(generalassetid,organization);
	}
	public List<ItAsset> getExistingMachineDetails(String organization)
	{
		return assetDao.getExistingMachineDetails(organization);
	}
	public void deleteMacine(int itassetid,String organization)
	{
		assetDao.deleteMacine(itassetid,organization);
	}
	public void updateMachine(int itassetid,String machinetype,String machine,String roomNumber,String description)
	{
		System.out.println("welcomeservice");
		assetDao.updateMachine(itassetid, machinetype, machine, roomNumber, description);
	}
	public void updateRoom(int generalAssetid,String roomNumber)
	{
		assetDao.updateRoom(generalAssetid, roomNumber);
	}
	public List getMachinename(String organization)
	{
		System.out.println("scanservice");
		return assetDao.getMachinename(organization);
	}
	
	public void insertnewAsset(String organization, String roomNumber,
			String itemName, int itemCount){
		
		assetDao.insertnewAsset(organization, roomNumber, itemName, itemCount);
	}
	
	public List<Assets> getRoomAssets(int id){
		
		return assetDao.getRoomAssets(id);

	}
	public void editRoomAsset(int id, String itemName, int itemCount){
		assetDao.editRoomAsset(id, itemName, itemCount);
	}
	public void deleteRoomAsset(int id){
		assetDao.deleteRoomAsset(id);
	}
	public void saveInward(Inward inward)
	{
		assetDao.saveInward(inward);
	}
	public void saveOutward(Outward outward)
	{
		assetDao.saveOutward(outward);
	}
	public List<InwardDTO> getInwardreport(String type,String month,String year)
	{
		return assetDao.getInwardreport(type, month, year);
	}
	
	public List<OutwardDTO> getOutwardReport(String type,String month,String year)
	{
		return assetDao.getOutwardReport(type, month, year);
	}
	public void savequantity(InwardQuantity inwardquantity)
	{
		assetDao.savequantity(inwardquantity);
	}
	public void saveoutwardquantity(OutwardQuantity outwardquantity)
	{
		assetDao.saveoutwardquantity(outwardquantity);
	}
	public List getInwardinfo(String type)
	{
		return assetDao.getInwardinfo(type);
	}
	public List getOutwardinfo(String type)
	{
		return assetDao.getOutwardinfo(type);
	}
	public List viewquantity(int id)
	{
		return assetDao.viewquantity(id);
	}
	public List outwardquantity(int id)
	{
		return assetDao.outwardquantity(id);
	}
	public void deleteinwardquantity(int id)
	{
		assetDao.deleteinwardquantity(id);
	}
	public void deleteoutwardquantity(int id)
	{
		assetDao.deleteoutwardquantity(id);
	}
	public void updateinward(int id,String date,String invoicenumber,String fromwhere,String towhere,String edate,String rdate,String takenby)
	{
		assetDao.updateinward(id, date, invoicenumber, fromwhere, towhere, edate, rdate, takenby);
	}
	public void updateoutward(int id,String date,String gatepass,String fromwhere,String towhere,String edate,String rdate,String authorizedby)
	{
		assetDao.updateoutward(id, date, gatepass, fromwhere, towhere, edate, rdate, authorizedby);
	}
	public void updateinwardnonreturnable(int id,String date,String invoicenumber,String fromwhere,String towhere)
	{
		assetDao.updateinwardnonreturnable(id, date, invoicenumber, fromwhere, towhere);
	}
	public void updateoutwardnonreturnable(int id,String date,String gatepass,String fromwhere,String towhere)
	{
		assetDao.updateoutwardnonreturnable(id, date, gatepass, fromwhere, towhere);
	}
	public void updateinwardquantity(int id,String itemname,int quantity)
	{
		assetDao.updateinwardquantity(id, itemname, quantity);
	}
	public void updateoutwardquantity(int id,String itemname,int quantity)
	{
		assetDao.updateoutwardquantity(id, itemname, quantity);
	}
}

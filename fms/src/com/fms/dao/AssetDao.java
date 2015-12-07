package com.fms.dao;

import java.util.List;
import java.util.Set;

import com.fms.domain.Assets;
import com.fms.domain.GeneralAsset;
import com.fms.domain.Inward;
import com.fms.domain.InwardDTO;
import com.fms.domain.InwardQuantity;
import com.fms.domain.ItAsset;
import com.fms.domain.Outward;
import com.fms.domain.OutwardDTO;
import com.fms.domain.OutwardQuantity;


public interface AssetDao {

	public void insertnewRoom(GeneralAsset generalasset);

	public List getRoomNumber(String organization);

	public void insertbewMachine(ItAsset itAsset);

	public List<GeneralAsset> getExistingRoomDetails(String organization);

	public void deleteRoom(int generalassetid, String organization);

	public List<ItAsset> getExistingMachineDetails(String organization);

	public void deleteMacine(int itassetid, String organization);

	public void updateMachine(int itassetid, String machinetype,
			String machine, String roomNumber, String description);

	public void updateRoom(int generalAssetid, String roomNumber);

	public List getMachinename(String organization);

	public void insertnewAsset(String organization, String roomNumber,
			String itemName, int itemCount);
	
	public List<Assets> getRoomAssets(int id);
	
	public void editRoomAsset(int id, String itemName, int itemCount);
	
	public void deleteRoomAsset(int id);
	
	public void saveInward(Inward inward);
	
	public void saveOutward(Outward outward);
	
	public List<InwardDTO>  getInwardreport(String type,String month,String year);
//	public List<InwardDTO>  getInwardnonreturnablereport(String type,String month,String year);
	
	public List<OutwardDTO> getOutwardReport(String type,String month,String year);
	
	public void savequantity(InwardQuantity inwardquantity);
	
	public void saveoutwardquantity(OutwardQuantity outwardquantity);
	
	public List getInwardinfo(String type);
	public List getOutwardinfo(String type);
	
	public List viewquantity(int id);
	public List outwardquantity(int id);
	public void deleteinwardquantity(int id);
	public void deleteoutwardquantity(int id);
	public void updateinward(int id,String date,String invoicenumber,String fromwhere,String towhere,String edate,String rdate,String takenby);
	public void updateoutward(int id,String date,String gatepass,String fromwhere,String towhere,String edate,String rdate,String authorizedby);
	public void updateinwardnonreturnable(int id,String date,String invoicenumber,String fromwhere,String towhere);
	public void updateoutwardnonreturnable(int id,String date,String gatepass,String fromwhere,String towhere);
	public void updateinwardquantity(int id,String itemname,int quantity);
	public void updateoutwardquantity(int id,String itemname,int quantity);
	
}

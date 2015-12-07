package com.fms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.domain.Assets;
import com.fms.domain.Day2dayVehicleDetails;
import com.fms.domain.GeneralAsset;
import com.fms.domain.Inward;
import com.fms.domain.InwardDTO;
import com.fms.domain.InwardQuantity;
import com.fms.domain.ItAsset;
import com.fms.domain.Outward;
import com.fms.domain.OutwardDTO;
import com.fms.domain.OutwardQuantity;
import com.fms.exception.FMSGenericException;

@Repository("AssetDao")
@Transactional
public class AssetDaoImpl implements AssetDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void insertnewRoom(GeneralAsset generalasset)
			throws FMSGenericException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(generalasset);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
	}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List getRoomNumber(String organization) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = " from GeneralAsset WHERE organization='" + organization
				+ "'";

		List list = session.createQuery(hql).list();

		List list1 = new ArrayList();

		for (Iterator it = list.iterator(); it.hasNext();) {

			GeneralAsset l = (GeneralAsset) it.next();

			list1.add("'" + l.getRoomNumber() + "'");
		}

		return list1;
	}

	public void insertbewMachine(ItAsset itAsset) throws FMSGenericException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(itAsset);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}

	}

	@SuppressWarnings("unchecked")
	public List<GeneralAsset> getExistingRoomDetails(String organization) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "from GeneralAsset where organization='" + organization
				+ "'";
		List<GeneralAsset> list = session.createQuery(hql).list();

		// Criteria criteria = session.createCriteria(GeneralAsset.class);

		return list;
	}

	public void deleteRoom(int generalassetid, String organization) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "delete from GeneralAsset where generalassetid='"
				+ generalassetid + "' and organization='" + organization + "'";
		session.createQuery(hql).executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<ItAsset> getExistingMachineDetails(String organization) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "from ItAsset where organization='" + organization + "'";
		List<ItAsset> list = session.createQuery(hql).list();

		// Criteria criteria = session.createCriteria(ItAsset.class);

		return list;
	}

	public void deleteMacine(int itassetid, String organization) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "delete from ItAsset where itassetid='" + itassetid
				+ "' and organization='" + organization + "'";
		session.createQuery(hql).executeUpdate();

	}

	public void updateMachine(int itassetid, String machinetype,
			String machine, String roomNumber, String description) {

		
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update ItAsset i set i.machinetype='" + machinetype
				+ "',i.machine='" + machine + "',i.roomNumber='" + roomNumber
				+ "',i.description='" + description + "' where i.itassetid='"
				+ itassetid + "'";
		session.createQuery(hql).executeUpdate();

	}

	public void updateRoom(int generalAssetid, String roomNumber) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update GeneralAsset a set a.roomNumber='" + roomNumber
				+ "' where a.generalassetid='" + generalAssetid + "'";
		session.createQuery(hql).executeUpdate();

	}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List getMachinename(String organization) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = " from ItAsset WHERE organization='" + organization + "'";

		List list = session.createQuery(hql).list();

		List list1 = new ArrayList();

		for (Iterator it = list.iterator(); it.hasNext();) {

			ItAsset l = (ItAsset) it.next();

			list1.add("'" + l.getMachine() + "'");
		}
		
		return list1;

	}

	public void insertnewAsset(String organization, String roomNumber,
			String itemName, int itemCount) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "FROM GeneralAsset g WHERE g.organization='"
				+ organization + "' AND g.roomNumber='" + roomNumber + "'";

		int generalassetid = 0;

		List list = session.createQuery(hql).list();

		for (Iterator it = list.iterator(); it.hasNext();) {

			GeneralAsset l = (GeneralAsset) it.next();
			generalassetid = l.getGeneralassetid();
		}
		Assets newassets = new Assets();

		newassets.setGeneralassetid(generalassetid);
		newassets.setItemName(itemName);
		newassets.setItemCount(itemCount);

		try {
			session.save(newassets);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}

	}

	public List<Assets> getRoomAssets(int id) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "from Assets where generalassetid='" + id + "'";
		@SuppressWarnings("unchecked")
		List<Assets> list = session.createQuery(hql).list();

		// Criteria criteria = session.createCriteria(GeneralAsset.class);

		return list;

	}

	public void editRoomAsset(int id, String itemName, int itemCount) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "UPDATE Assets a set a.itemName ='" + itemName
				+ "',a.itemCount='" + itemCount + "' WHERE a.id='" + id + "'";

		session.createQuery(hql).executeUpdate();
	}

	public void deleteRoomAsset(int id) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "DELETE Assets a  WHERE a.id='" + id + "'";

		session.createQuery(hql).executeUpdate();
	}

	public void saveInward(Inward inward) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		session.save(inward);

	}

	public void saveOutward(Outward outward) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		session.save(outward);
	}

	public List<InwardDTO> getInwardreport(String type, String month,
			String year) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "select NEW com.fms.domain.InwardDTO(i.id,i.type,i.date,i.invoicenumber,i.fromwhere,i.towhere,i.edate,i.rdate,i.takenby,iq.itemname,iq.quantity)FROM Inward i,InwardQuantity iq where i.id=iq.inwardid AND i.type='"
				+ type
				+ "' AND i.date LIKE '%"
				+ month
				+ "%' AND i.date LIKE '%" + year + "%'";

		List<InwardDTO> list = session.createQuery(hql).list();
		return list;
		// Criteria criteria = session.createCriteria(Inward.class);
		// criteria.setFetchMode("InwardQuantity", FetchMode.JOIN);
		// criteria.add(Restrictions.eq("type", type));
		// criteria.add(Restrictions.between("date",fromdate,todate));
		// criteria.addOrder(Order.asc("date"));
		// return criteria.list();

	}

	public List<OutwardDTO> getOutwardReport(String type, String month,
			String year) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "select NEW com.fms.domain.OutwardDTO(i.id,i.type,i.date,i.gatepass,i.fromwhere,i.towhere,i.edate,i.rdate,i.authorizedby,iq.itemname,iq.quantity)FROM Outward i,OutwardQuantity iq where i.id=iq.outwardid AND i.type='"
				+ type
				+ "' AND i.date LIKE '%"
				+ month
				+ "%' AND i.date LIKE '%" + year + "%'";
		List<OutwardDTO> list = session.createQuery(hql).list();
		return list;
	}

	public void savequantity(InwardQuantity inwardquantity) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		session.save(inwardquantity);
	}

	public void saveoutwardquantity(OutwardQuantity outwardquantity) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		session.save(outwardquantity);
	}

	public List getInwardinfo(String type) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "from Inward i where i.type='" + type + "'";
		List list = session.createQuery(hql).list();
		return list;
	}

	public List getOutwardinfo(String type) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "from Outward i where i.type='" + type + "'";
		List list = session.createQuery(hql).list();
		return list;
	}

	public List viewquantity(int id) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "from InwardQuantity i where i.inwardid='" + id + "'";
		List list = session.createQuery(hql).list();

		return list;
	}

	public List outwardquantity(int id) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "from OutwardQuantity i where i.outwardid='" + id + "'";
		List list = session.createQuery(hql).list();

		return list;
	}

	public void deleteinwardquantity(int id) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "delete InwardQuantity i where i.id='" + id + "'";
		session.createQuery(hql).executeUpdate();
	}

	public void deleteoutwardquantity(int id) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "delete OutwardQuantity i where i.id='" + id + "'";
		session.createQuery(hql).executeUpdate();

	}

	public void updateinward(int id, String date, String invoicenumber,
			String fromwhere, String towhere, String edate, String rdate,
			String takenby) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update Inward i set i.date='" + date
				+ "',i.invoicenumber='" + invoicenumber + "',i.fromwhere='"
				+ fromwhere + "',i.towhere='" + towhere + "',i.edate='" + edate
				+ "',i.rdate='" + rdate + "',i.takenby='" + takenby
				+ "' where i.id='" + id + "'";
		session.createQuery(hql).executeUpdate();
	}

	public void updateinwardnonreturnable(int id, String date,
			String invoicenumber, String fromwhere, String towhere) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update Inward i set i.date='" + date
				+ "',i.invoicenumber='" + invoicenumber + "',i.fromwhere='"
				+ fromwhere + "',i.towhere='" + towhere + "' where i.id='" + id
				+ "'";
		session.createQuery(hql).executeUpdate();
	}

	public void updateoutward(int id, String date, String gatepass,
			String fromwhere, String towhere, String edate, String rdate,
			String authorizedby) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update Outward i set i.date='" + date + "',i.gatepass='"
				+ gatepass + "',i.fromwhere='" + fromwhere + "',i.towhere='"
				+ towhere + "',i.edate='" + edate + "',i.rdate='" + rdate
				+ "',i.authorizedby='" + authorizedby + "' where i.id='" + id
				+ "'";
		session.createQuery(hql).executeUpdate();
	}

	public void updateoutwardnonreturnable(int id, String date,
			String gatepass, String fromwhere, String towhere) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update Outward i set i.date='" + date + "',i.gatepass='"
				+ gatepass + "',i.fromwhere='" + fromwhere + "',i.towhere='"
				+ towhere + "' where i.id='" + id + "'";
		session.createQuery(hql).executeUpdate();
	}

	public void updateinwardquantity(int id, String itemname, int quantity) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update InwardQuantity i set i.itemname='" + itemname
				+ "',i.quantity='" + quantity + "' where i.id='" + id + "'";
		session.createQuery(hql).executeUpdate();
	}

	public void updateoutwardquantity(int id, String itemname, int quantity) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		String hql = "update OutwardQuantity i set i.itemname='" + itemname
				+ "',i.quantity='" + quantity + "' where i.id='" + id + "'";
		session.createQuery(hql).executeUpdate();
	}

}
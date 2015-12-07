package com.fms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.fms.domain.Complaint;
import com.fms.domain.ComplaintDTO;
import com.fms.domain.ComplaintVoucher;
import com.fms.exception.FMSGenericException;

@Repository("ComplaintDao")
@Transactional
public class ComplaintDaoImpl implements ComplaintDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void saveComplaint(Complaint complaint) throws FMSGenericException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(complaint);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getAllComplaintList() {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Criteria criteria = session.createCriteria(Complaint.class);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Complaint> searchComplaints(String organization) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Criteria criteria = session.createCriteria(Complaint.class);

		criteria.add(Restrictions.eq("organization", organization));

		return criteria.list();
	}

	public void updateComplaint(int complaintId, String complaint,
			String roomNumber, String category,String machine,String assignedto, String status, String priority,
			String comments, String updatedDate) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "UPDATE Complaint c set c.complaint ='" + complaint
				+ "',c.roomNumber='" + roomNumber + "',c.category='" + category
				+ "',c.machine='"+machine+"',c.assignedto='"+assignedto+"',c.status='" + status + "',c.priority='" + priority
				+ "',c.comments='" + comments + "',c.updatedDate='"
				+ updatedDate + "' WHERE c.complaintId ='" + complaintId + "'";
		session.createQuery(hql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<ComplaintVoucher> getVoucherList(int complaintId) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "FROM ComplaintVoucher v WHERE v.complaintId= '"
				+ complaintId + "'";

		List<ComplaintVoucher> list = session.createQuery(hql).list();

		return list;

	}
	
	

	public void saveVocuher(ComplaintVoucher vocuher)
			throws FMSGenericException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(vocuher);
		} catch (HibernateException he) {
			throw new FMSGenericException(he + "");
		}
	}

	public void updateVoucher(int complaintId, String cashmode, String vdate,
			int amount, String towards, String sumofrupees, String idate,
			String pperson, String rperson, String rparty, String pnumber) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "UPDATE ComplaintVoucher c set c.cashmode ='" + cashmode
				+ "',c.voucherDate='" + vdate + "',c.amount='" + amount
				+ "',c.towards='" + towards + "',c.sumofrupees='" + sumofrupees
				+ "',c.issuedDate='" + idate + "',c.paidPerson='" + pperson
				+ "',c.receivedPerson='" + rperson + "',c.receivedParty='"
				+ rparty + "',c.phoneNumber='" + pnumber
				+ "' WHERE c.complaintId ='" + complaintId + "'";
		session.createQuery(hql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<ComplaintVoucher> getAllVouchersList() {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Criteria criteria = session.createCriteria(ComplaintVoucher.class);

		return criteria.list();

	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getComplaint(int complaintId) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "FROM Complaint c WHERE c.complaintId= '" + complaintId
				+ "'";

		List<Complaint> list = session.createQuery(hql).list();

		return list;

	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getClosedComplaint() {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "FROM Complaint c WHERE c.status = 'Closed'";

		List<Complaint> list = session.createQuery(hql).list();

		return list;

	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getRoomHistoryComplaintList(String organization,
			String roomNumber) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "FROM Complaint c WHERE c.organization= '" + organization
				+ "' AND c.roomNumber= '" + roomNumber + "'";

		List<Complaint> list = session.createQuery(hql).list();

		return list;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getComplaintStatus() {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String SQL_QUERY = "select status,count(status) from Complaint group by status";
		Query query = session.createQuery(SQL_QUERY);
		Object[] row = null;
		Iterator it = query.iterate();
		ArrayList list = new ArrayList();
		list.add("['Status'");
		list.add("'Count']");
		while (it.hasNext()) {
			row = (Object[]) it.next();
			
			list.add("['" + row[0] + "'");
			list.add(row[1] + "]");
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getComplaintsByCategory() {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String SQL_QUERY = "select category,count(category) from Complaint group by category";
		Query query = session.createQuery(SQL_QUERY);
		Object[] row = null;
		Iterator it = query.iterate();
		ArrayList list = new ArrayList();
		list.add("['Category'");
		list.add("'Count']");
		while (it.hasNext()) {
			row = (Object[]) it.next();
			
			list.add("['" + row[0] + "'");
			list.add(row[1] + "]");
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getComplaintsByOrganization() {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String SQL_QUERY = "select organization,count(organization) from Complaint group by organization";
		Query query = session.createQuery(SQL_QUERY);
		Object[] row = null;
		Iterator it = query.iterate();
		ArrayList list = new ArrayList();
		list.add("['Category'");
		list.add("'Count']");
		while (it.hasNext()) {
			row = (Object[]) it.next();
			

			list.add("['" + row[0] + "'");
			list.add(row[1] + "]");
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ComplaintDTO> getComplaintsReportByOrganization(
			String organization, String status, String month, String year) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "SELECT NEW com.fms.domain.ComplaintDTO(c.complaint, c.organization, c.roomNumber, c.category, c.status, c.createdDate, v.amount) FROM Complaint c, ComplaintVoucher v WHERE c.complaintId=v.complaintId AND c.organization='"
				+ organization
				+ "' AND c.status='"
				+ status
				+ "' AND c.createdDate LIKE '%"
				+ month
				+ "%' AND c.createdDate LIKE '%"
				+ year
				+ "%' ORDER BY c.category";

		List<ComplaintDTO> list = session.createQuery(hql).list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ComplaintDTO> getComplaintsReportByCategory(String category,
			String status, String month, String year) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();
		
		String hql=null;
		if(status.equals("Open")){
			
		 hql = "SELECT NEW com.fms.domain.ComplaintDTO(c.complaint, c.organization, c.roomNumber, c.category, c.status, c.createdDate, v.amount) FROM Complaint c, ComplaintVoucher v WHERE  c.complaintId=v.complaintId AND c.category='"
				+ category
				+ "' AND c.status='"
				+ status
				+ "' AND c.createdDate LIKE '%"
				+ month
				+ "%' AND c.createdDate LIKE '%"
				+ year
				+ "%' ORDER BY c.organization";
			
		}else{

		 hql = "SELECT NEW com.fms.domain.ComplaintDTO(c.complaint, c.organization, c.roomNumber, c.category, c.status, c.createdDate, v.amount) FROM Complaint c, ComplaintVoucher v WHERE c.complaintId=v.complaintId AND c.category='"
				+ category
				+ "' AND c.status='"
				+ status
				+ "' AND c.createdDate LIKE '%"
				+ month
				+ "%' AND c.createdDate LIKE '%"
				+ year
				+ "%' ORDER BY c.organization";
		}
		List<ComplaintDTO> list = session.createQuery(hql).list();

		return list;

	}

	@SuppressWarnings("unchecked")
	public List<ComplaintDTO> getRoomComplaintHistory(String organization,
			String roomNumber, String month, String year) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "SELECT NEW com.fms.domain.ComplaintDTO(c.complaint, c.organization, c.roomNumber, c.category, c.status, c.createdDate, v.amount) FROM Complaint c, ComplaintVoucher v WHERE c.complaintId=v.complaintId AND status='Closed' AND c.organization='"
				+ organization
				+ "' AND c.roomNumber='"
				+ roomNumber
				+ "' AND c.createdDate LIKE '%"
				+ month
				+ "%' AND c.createdDate LIKE '%"
				+ year
				+ "%' ORDER BY c.category";

		List<ComplaintDTO> list = session.createQuery(hql).list();

		return list;

	}

	@SuppressWarnings("unchecked")
	public List<ComplaintVoucher> getVouchersReport(String month, String year) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "FROM ComplaintVoucher WHERE issuedDate LIKE '%" + month
				+ "%' AND issuedDate LIKE '%" + year
				+ "%' ORDER BY issuedDate ASC";

		List<ComplaintVoucher> list = session.createQuery(hql).list();

		return list;

	}
	
	@SuppressWarnings("unchecked")
	public List<Complaint> getOpenCategoryComplaints(String category, String status, String month, String year){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();

String	 hql = "FROM Complaint c WHERE  c.category='"
		+ category
		+ "' AND c.status='"
		+ status
		+ "' AND c.createdDate LIKE '%"
		+ month
		+ "%' AND c.createdDate LIKE '%"
		+ year
		+ "%' ORDER BY c.organization";

		List<Complaint> list = session.createQuery(hql).list();

return list;

	}
	
	@SuppressWarnings("unchecked")
	public List<Complaint> getOpenOrganizationComplaints(String organization, String status, String month, String year){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();

String	 hql = "FROM Complaint c WHERE  c.organization='"
		+ organization
		+ "' AND c.status='"
		+ status
		+ "' AND c.createdDate LIKE '%"
		+ month
		+ "%' AND c.createdDate LIKE '%"
		+ year
		+ "%' ORDER BY c.category";

		List<Complaint> list = session.createQuery(hql).list();

return list;
	}
	
	
	public List<Complaint> getdailycomplaintsreport(String organization,String status,String currentDate)
	{
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		String hql="from Complaint c where c.organization='"+organization+"' " +
				"and " +
				"c.status='"+status+"' and c.createdDate LIKE '%"+currentDate+"%'";
		List<Complaint> list=session.createQuery(hql).list();
		return list;

	}
	
	
	public List getAmount(ComplaintVoucher voucher)
	{
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		String hql="from ComplaintVoucher ";
		List list =session.createQuery(hql).list();
		Iterator it=list.iterator();
		List list1 =new ArrayList();
		while (it.hasNext())
		{
			list1.add(voucher.getAmount());
		}
		
		return list1;
	}
	
}



package com.fms.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.domain.ComplaintArchive;

@Repository("ArchiveDao")
@Transactional
public class ArchiveDaoImpl implements ArchiveDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void inserArciveData(String month, String year) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "INSERT INTO ComplaintArchive (complaintId, complaint, organization, roomNumber, category, status, priority, createdDate,  updatedDate, comments, machine, assignedto)  SELECT c.complaintId, c.complaint,c.organization, c.roomNumber,c.category, c.status, c.priority, c.createdDate,c.updatedDate,c.comments, c.machine,c.assignedto FROM Complaint c WHERE c.status='Closed' AND c.createdDate LIKE '%"
				+ month + "%' AND c.createdDate LIKE '%" + year + "%'";

		session.createQuery(hql).executeUpdate();
	}

	public void deleteComplaintData(String month, String year) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "DELETE  FROM Complaint c WHERE c.status='Closed' AND c.createdDate LIKE '%"
				+ month + "%' AND c.createdDate LIKE '%" + year + "%'";

		session.createQuery(hql).executeUpdate();
	}

}

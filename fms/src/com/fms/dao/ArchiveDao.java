package com.fms.dao;

import com.fms.domain.ComplaintArchive;

public interface ArchiveDao {

	public void inserArciveData(String month, String year);
	public void deleteComplaintData(String month, String year);
}

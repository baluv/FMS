package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.dao.ArchiveDao;

@Service("ArchiveService")
@Transactional
public class ArchiveServiceImpl implements ArchiveService{

	@Autowired(required=true)
	private ArchiveDao archiveDao;
	
	public void inserArciveData(String month, String year){
		
		archiveDao.inserArciveData(month, year);
		
	}
	public void deleteComplaintData(String month, String year){
		
		archiveDao.deleteComplaintData(month, year);
		
	}
}

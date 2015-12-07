package com.fms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.service.ArchiveService;


@Controller
@RequestMapping("/complaints")
public class ArchiveController {

	@Autowired(required = true)
	public ArchiveService archiveService;
	
	@RequestMapping(value = "/archivepage")
	public String getNewRoom(Map<String, Object> model) {
		return "archivepage";
	}
	@RequestMapping(value = "/archive")
	public String performCompalintArchive(Map<String, Object> model, @RequestParam("month")
			String month, @RequestParam("year")
			String year) {
		
		archiveService.inserArciveData(month, year);
		archiveService.deleteComplaintData(month, year);
		
		model.put("msg", "Data Archived Successfully....");
		return "archivepage";
		
		
	}
	
}


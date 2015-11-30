package com.ehualu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehualu.service.DailyRecordService;

@Controller
@RequestMapping(value = "/user")
public class DailyRecordController {
	private static final Logger logger = LoggerFactory
			.getLogger(DailyRecordController.class);
	
	DailyRecordService dailyRecordService;
	@Autowired
	public void setDailyRecordService(DailyRecordService dailyRecordService) {
		this.dailyRecordService = dailyRecordService;
	}
	
	@RequestMapping(value = { "/", ""}, method = RequestMethod.GET)
	public String dailyRecordPage(Model model) {
		logger.info("into Daily Record requested");
		return "/dailyRecord/list";
	}
	

}

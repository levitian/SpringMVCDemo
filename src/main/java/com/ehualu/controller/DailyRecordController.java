package com.ehualu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehualu.bo.DailyRecord;
import com.ehualu.service.DailyRecordService;
import com.ehualu.util.DateEditor;

@Controller
@RequestMapping(value = "/dr")
public class DailyRecordController {
	private static final Logger logger = LoggerFactory
			.getLogger(DailyRecordController.class);
	
	DailyRecordService dailyRecordService;
	@Autowired
	public void setDailyRecordService(DailyRecordService dailyRecordService) {
		this.dailyRecordService = dailyRecordService;
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
	                              ServletRequestDataBinder binder) throws Exception {
	    //对于需要转换为Date类型的属性，使用DateEditor进行处理
	    binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	
	@RequestMapping(value = { "/", ""}, method = RequestMethod.GET)
	public String dailyRecordPage(Model model) {
		logger.info("into Daily Record requested");
		return "/dailyRecord/list";
	}
	
	@RequestMapping(value = { "/list"}, method = RequestMethod.GET)
	@ResponseBody
	public List<DailyRecord> list(Model model) {
		List<DailyRecord> drs = dailyRecordService.list();
		return drs;
	}
	
	@RequestMapping(value = { "/add"}, method = RequestMethod.POST)
	@ResponseBody
	public boolean add(@ModelAttribute DailyRecord dailyRecord) {
		dailyRecord.setCreate_date(new Date());
		dailyRecordService.add(dailyRecord);
		return true;
	}
	
	
}

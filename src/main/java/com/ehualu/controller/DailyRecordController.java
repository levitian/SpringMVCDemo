package com.ehualu.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javassist.bytecode.ByteArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.ehualu.util.ExportTodayDailyRecordUtil;

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
		// 对于需要转换为Date类型的属性，使用DateEditor进行处理
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String dailyRecordPage(Model model) {
		logger.info("into Daily Record requested");
		return "/dailyRecord/list";
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	@ResponseBody
	public List<DailyRecord> list(Model model) {
		List<DailyRecord> drs = dailyRecordService.list();
		return drs;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public boolean add(@ModelAttribute DailyRecord dailyRecord) {
		dailyRecord.setCreate_date(new Date());
		dailyRecordService.add(dailyRecord);
		return true;
	}

	@RequestMapping(value = { "/exportTodayDailyRecord" }, method = RequestMethod.GET)
	@ResponseBody
	public void exportTodayDailyRecord(HttpServletResponse response) {
		List<DailyRecord> drs = dailyRecordService.listByToday();
		HSSFWorkbook wb = ExportTodayDailyRecordUtil.export(drs);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
			byte[] bytes = os.toByteArray();

			response.reset();
			response.setContentType("application/msexcel;charset=utf-8");
			response.setHeader("Content-disposition", "attachment;filename=dailyReport.xls");
			response.getOutputStream().write(bytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			logger.error("export error:",e);
		}
	}

}

package com.ehualu.service;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehualu.bo.DailyRecord;
import com.ehualu.dao.DailyRecordDao;

@Service
@Transactional
public class DailyRecordService {
	
	private DailyRecordDao dailyRecordDao;
	@Autowired
	public void setDailyRecordDao(DailyRecordDao dailyRecordDao) {
		this.dailyRecordDao = dailyRecordDao;
	}
	
	public long add(DailyRecord dailyRecord){
		return dailyRecordDao.save(dailyRecord);
	}
	
	public void delete(long id){
		dailyRecordDao.delete(id);
	}
	
	public List<DailyRecord> list(){
		return dailyRecordDao.list();
	}
	
	public void update(DailyRecord dailyRecord){
		dailyRecordDao.update(dailyRecord);
	}
	
	public List<DailyRecord> list(String propertyName, Object value){
		return dailyRecordDao.list(propertyName, value);
	}
	
	public List<DailyRecord> listByToday(){
		return dailyRecordDao.listByToday();
	}
}

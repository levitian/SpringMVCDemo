package com.ehualu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehualu.bo.Event;
import com.ehualu.dao.EventDao;

@Service
@Transactional
public class EventService {

	private EventDao eventDao;
	@Autowired
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	public void add(Event event){
		eventDao.save(event);
	}
	
	public void delete(int id){
		Event event = eventDao.get(id);
		eventDao.delete(event);
	}
	
	public void update(Event event){
		eventDao.update(event);
	}
	public List<Event> list(){
		return eventDao.list();
	}
}

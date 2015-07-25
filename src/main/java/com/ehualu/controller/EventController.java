package com.ehualu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehualu.bo.Event;
import com.ehualu.service.EventService;

@Controller
@RequestMapping(value = "/event")
public class EventController {

	EventService eventService;
	@Autowired
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	
	@RequestMapping(value = { "/list"}, method = RequestMethod.GET)
	@ResponseBody
	public List<Event> list(HttpServletRequest request) {
		List<Event> events = eventService.list();
		return events;
	}
}

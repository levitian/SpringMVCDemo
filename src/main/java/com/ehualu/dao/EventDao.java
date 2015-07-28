package com.ehualu.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehualu.bo.Event;

@Repository
@Transactional(readOnly = true)
public class EventDao extends BaseDao<Event, Integer>{

}

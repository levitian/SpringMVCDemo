package com.ehualu.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehualu.bo.DailyRecord;

@Repository
@Transactional(readOnly = true)
public class DailyRecordDao extends BaseDao<DailyRecord, Long>{

}

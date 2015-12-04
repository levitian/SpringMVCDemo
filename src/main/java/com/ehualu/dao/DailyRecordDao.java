package com.ehualu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehualu.bo.DailyRecord;

@Repository
@Transactional(readOnly = true)
public class DailyRecordDao extends BaseDao<DailyRecord, Long> {

	@SuppressWarnings("unchecked")
	public List<DailyRecord> listByToday() {
		String sql = "select * from daily_record where to_days(work_date) = to_days(now())";
		List<DailyRecord> drs = getSession().createSQLQuery(sql)
				.addEntity(DailyRecord.class).list();
		return drs;
	}
}

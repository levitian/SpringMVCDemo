package com.ehualu.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daily_record")
public class DailyRecord implements Serializable {
	
	private static final long serialVersionUID = 6589294010139831423L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	/**
	 * 姓名
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * 工作内容（任务）
	 */
	@Column(name = "WORK_CONTENT")
	private String work_content;
	
	/**
	 * 牵头人
	 */
	@Column(name = "INITIATOR")
	private String initiator;
	
	/**
	 * 工作进展 
	 */
	@Column(name = "JOB_PROGRESS")
	private int  job_progress;
	
	/**
	 * 是否测试
	 */
	@Column(name = "IS_TEST")
	private boolean is_test;
	
	/**
	 * 是否提交svn
	 */
	@Column(name = "IS_SUBMIT")
	private boolean is_submit;
	
	/**
	 * 遇到的困难/问题
	 */
	@Column(name = "DOUBT")
	private String doubt;
	
	/**
	 * 备注
	 */
	@Column(name = "REMARK")
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWork_content() {
		return work_content;
	}

	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public int getJob_progress() {
		return job_progress;
	}

	public void setJob_progress(int job_progress) {
		this.job_progress = job_progress;
	}

	public boolean isIs_test() {
		return is_test;
	}

	public void setIs_test(boolean is_test) {
		this.is_test = is_test;
	}

	public boolean isIs_submit() {
		return is_submit;
	}

	public void setIs_submit(boolean is_submit) {
		this.is_submit = is_submit;
	}

	public String getDoubt() {
		return doubt;
	}

	public void setDoubt(String doubt) {
		this.doubt = doubt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

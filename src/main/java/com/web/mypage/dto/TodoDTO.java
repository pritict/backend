package com.web.mypage.dto;

import java.util.Date;

public class TodoDTO {
	private int num;
	private String title;
	private String detail;
	private Integer done;
	private Date createdt;
	private Date updatedt;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getDone() {
		return done;
	}
	public void setDone(Integer done) {
		this.done = done;
	}
	public Date getCreatedt() {
		return createdt;
	}
	public void setCreatedt(Date createdt) {
		this.createdt = createdt;
	}
	public Date getUpdatedt() {
		return updatedt;
	}
	public void setUpdatedt(Date updatedt) {
		this.updatedt = updatedt;
	}
}

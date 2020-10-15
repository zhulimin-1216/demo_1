package com.zhiyou.model;

import java.io.Serializable;

public class Subject implements Serializable{
	private static final long serialVersionUID = 7L;

	private Integer subjectId;//id
	private String subjectName;//Ñ§¿ÆÃû³Æ
	
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}

}

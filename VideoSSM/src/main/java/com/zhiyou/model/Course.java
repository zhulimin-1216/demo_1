package com.zhiyou.model;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{//�γ�ר����
	private static final long serialVersionUID = 133L;

	private Integer id;//id
	private String courseTitle;//ר������
	private String courseDesc;//ר������
	private Integer subjectId;//����ѧ��
	private List<Video> videoss;		// �ÿγ̵���Ƶ�б�
	private Subject subject;
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public List<Video> getVideoss() {
		return videoss;
	}
	public void setVideoss(List<Video> videoss) {
		this.videoss = videoss;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseTitle=" + courseTitle + ", courseDesc=" + courseDesc + ", subjectId="
				+ subjectId + ", videoss=" + videoss + ", subject=" + subject + "]";
	}
	public Course(Integer id, String courseTitle, String courseDesc, Integer subjectId, List<Video> videoss) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
		this.subjectId = subjectId;
		this.videoss = videoss;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

package com.zhiyou.model;

import java.io.Serializable;

public class Video implements Serializable{//��Ƶ��Ϣ��
	private static final long serialVersionUID = 3L;
	
	private Integer videoId;//id
	private String title;//��Ƶ����
	private String detail;//��Ƶ�������
	private Integer time;//��Ƶ��ʱ��(��)
	private Integer speakerId;//��ʦid
	private Integer courseId;//�γ�ר��id
	private String videoUrl;//��Ƶ����url
	private String imageUrl;//��Ƶ����ͼƬurl
	private Integer playNum;//��Ƶ���Ŵ���ͳ��
	private Speaker speaker;	// ��ʦ����
	private Course course;//�γ�ר��id
	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
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
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(Integer speakerId) {
		this.speakerId = speakerId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getPlayNum() {
		return playNum;
	}
	public void setPlayNum(Integer playNum) {
		this.playNum = playNum;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", detail=" + detail + ", time=" + time
				+ ", speakerId=" + speakerId + ", courseId=" + courseId + ", videoUrl=" + videoUrl + ", imageUrl="
				+ imageUrl + ", playNum=" + playNum + ", speaker=" + speaker + "]";
	}
	public Video(Integer videoId, String title, String detail, Integer time, Integer speakerId, Integer courseId,
			String videoUrl, String imageUrl, Integer playNum, Speaker speaker) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.detail = detail;
		this.time = time;
		this.speakerId = speakerId;
		this.courseId = courseId;
		this.videoUrl = videoUrl;
		this.imageUrl = imageUrl;
		this.playNum = playNum;
		this.speaker = speaker;
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}



}

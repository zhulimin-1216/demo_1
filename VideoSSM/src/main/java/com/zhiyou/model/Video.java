package com.zhiyou.model;

import java.io.Serializable;

public class Video implements Serializable{//视频信息表
	private static final long serialVersionUID = 3L;
	
	private Integer videoId;//id
	private String title;//视频标题
	private String detail;//视频详情介绍
	private Integer time;//视频总时长(秒)
	private Integer speakerId;//讲师id
	private Integer courseId;//课程专辑id
	private String videoUrl;//视频播放url
	private String imageUrl;//视频封面图片url
	private Integer playNum;//视频播放次数统计
	private Speaker speaker;	// 讲师对象
	private Course course;//课程专辑id
	
	
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

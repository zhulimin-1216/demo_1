package com.zhiyou.model;

import java.io.Serializable;

public class Speaker implements Serializable{//��ʦ��Ϣ
	private static final long serialVersionUID = 11L;

	private Integer id;//id
	private String speakerName;//��ʦ����
	private String speakerDesc;//��ʦ���
	private String speakerJob;//��ʦְλ
	private String picUrl;//��ʦͷ���ַ
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getSpeakerDesc() {
		return speakerDesc;
	}
	public void setSpeakerDesc(String speakerDesc) {
		this.speakerDesc = speakerDesc;
	}
	public String getSpeakerJob() {
		return speakerJob;
	}
	public void setSpeakerJob(String speakerJob) {
		this.speakerJob = speakerJob;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	@Override
	public String toString() {
		return "Speaker [id=" + id + ", speakerName=" + speakerName + ", speakerDesc=" + speakerDesc + ", speakerJob="
				+ speakerJob + ", picUrl=" + picUrl + "]";
	}
	public Speaker(Integer id, String speakerName, String speakerDesc, String speakerJob, String picUrl) {
		super();
		this.id = id;
		this.speakerName = speakerName;
		this.speakerDesc = speakerDesc;
		this.speakerJob = speakerJob;
		this.picUrl = picUrl;
	}
	public Speaker() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}

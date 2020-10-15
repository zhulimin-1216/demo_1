package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.SpeakerDao;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;

@Service
public class SpeakerServiceImpl implements SpeakerService{

	@Autowired
	SpeakerDao dao;
	public List<Speaker> select() {
		
		return dao.select();
	}

	public void deleteAll(Integer[] ids) {
		dao.deleteAll(ids);
		
	}

	public void delete(Integer id) {
		dao.delete(id);
		
	}

	public void add(Speaker speaker) {
		dao.add(speaker);
		
	}

	public void update(Speaker speaker) {
		dao.update(speaker);
		
	}

	public Speaker selectById(Integer id) {
		
		return dao.selectById(id);
	}

}

package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.SubjectDao;
import com.zhiyou.model.Subject;
import com.zhiyou.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDao dao;
	public List<Subject> selectAll() {
		
		return dao.selectAll();
	}
	public Subject selectById(Integer id) {
		
		return dao.selectById(id);
	}

}

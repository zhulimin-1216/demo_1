package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Subject;

public interface SubjectService {

	List<Subject> selectAll();

	Subject selectById(Integer id);
}

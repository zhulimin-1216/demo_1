package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Subject;

public interface SubjectDao {

	List<Subject> selectAll();

	Subject selectById(Integer id);
}

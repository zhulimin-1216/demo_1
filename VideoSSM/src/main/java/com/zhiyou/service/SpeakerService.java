package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;

public interface SpeakerService {

	//查全部
		List<Speaker> select();
		//批量删除
		void deleteAll(Integer[] ids);
		//删除一个
		void delete(Integer id);
		//添加
		void add(Speaker speaker);
		//更改
		void update(Speaker speaker);
		//回显
		Speaker selectById(Integer id);
}

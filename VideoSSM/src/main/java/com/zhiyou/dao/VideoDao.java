package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;

public interface VideoDao {

	//查全部
	List<Video> select(@Param("page")int page,@Param("v")Video video);
	//批量删除
	void deleteAll(Integer[] ids);
	//删除一个
	void delete(Integer id);
	//添加
	void add(Video video);
	//更改
	void update(Video video);
	//回显
	Video  selectById(Integer id);
	//视频播放次数
	void addPlayNum(Integer id);
	//模糊查询
/*	List<Video>selectLike(String name);*/
	//分页
/*	PageInfo<Video> selectPage(int page);*/
}

package com.zhiyou.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Video;

public interface VideoService {

	//查全部
	PageInfo<Video> select(int page,Video video);
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
	//播放视频
	Video playVideo(Integer videoId);
/*	//模糊查询
	List<Video>selectLike(String name);
	//分页
	PageInfo<Video> selectPage(int page);*/
}

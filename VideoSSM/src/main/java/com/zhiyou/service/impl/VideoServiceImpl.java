package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.dao.VideoDao;
import com.zhiyou.model.Course;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	VideoDao dao;
	public PageInfo<Video> select(int page,Video video) {
		PageHelper.startPage(page,5);
		//将查询出来的结果集放入list里
		List<Video> list = dao.select(page,video);
		//new一个pageInfo 传入list(list,2)后面的数字可以代表页数展示几页
		//如:上一页 123下一页 ,后面的数字显示展示几页
		return new PageInfo<Video>(list);
	}

	public void deleteAll(Integer[] ids) {
		dao.deleteAll(ids);
		
	}

	public void delete(Integer id) {
		dao.delete(id);
		
	}

	public void add(Video video) {
		dao.add(video);
		
	}

	public void update(Video video) {
		dao.update(video);
		
	}

	public Video selectById(Integer id) {
		
		return dao.selectById(id);
	}


	public Video playVideo(Integer videoId) {
		dao.addPlayNum(videoId);
		return dao.selectById(videoId);
	}
/*	//模糊
	public List<Video> selectLike(String name) {
		//判断传入的name等不等于null
		//等于null走全部查询
		//不等于null走模糊查询
		if(name==null||name.equals("")){
			return dao.selectLike(name);
		}
		return dao.selectLike(name);
	}*/
	//分页
/*	public PageInfo<Video> selectPage(int page) {
		//调用静态方法PageHelper.startPage(page(当前页), 5(一页分几条数据))
		PageHelper.startPage(page,5);
		//将查询出来的结果集放入list里
		List<Video> list = dao.select(page);
		//new一个pageInfo 传入list(list,2)后面的数字可以代表页数展示几页
		//如:上一页 123下一页 ,后面的数字显示展示几页
		return new PageInfo<Video>(list);
	}*/
}

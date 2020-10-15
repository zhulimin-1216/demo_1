package com.zhiyou.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FileInterceptor implements HandlerInterceptor{
	//在执行controller方法之前执行,如果返回true代表放行,如果返回false代表不放行
	long maxSize;// 文件的最大大小
	
	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		// 先检查此请求是否为文件上传请求：
		if(request instanceof MultipartHttpServletRequest){
			// 将其转换为文件上传请求：
			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
			// 获取文件map 
			Map<String,MultipartFile> fileMap = req.getFileMap();
			// 遍历文件map
			for(String key : fileMap.keySet()){
				// 根据key 获得对应的文件
				MultipartFile file = fileMap.get(key);
				// 先对文件的大小进行校验
				if(file.getSize() > maxSize){
					return false;
				} else{
					// 比对文件后缀格式
					// 获得文件类型（图片文件的类型为image/jpeg），即所有的图片文件都是image开头的
					String type = file.getContentType();
					// 去文件类型的前置类型
					String pre = type.split("/")[0];
					// 将其与image对比
					if(!pre.equals("image")){
						return false;
					}
				}
			}
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

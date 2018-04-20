package com.neu.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.bean.College;
import com.neu.service.CollegeService;

@RequestMapping(value="/college")
@Controller
public class CollegeController {
	@Autowired
	private CollegeService collegeService;
	
	/**
	 * 以HTML的形式返回所有的学院名称
	 */
	@RequestMapping(value="/selectAllCollegeName", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectAllCollegeName() {
		//定义一个StringBuffer对象用来存储要返回的filter_college的下拉菜单
		StringBuffer filter_college = new StringBuffer();
		List<String> collegeNames = collegeService.selectAllCollegeName();
		//利用迭代器对list进行遍历
		Iterator<String> iterator = collegeNames.iterator();
		filter_college.append("<option value='0'>所有学院</option>");
		while(iterator.hasNext()) {
			String collegeName = iterator.next();
			filter_college.append("<option value='"+collegeName+"'>"+collegeName+"</option>");
		}
		
		return filter_college.toString();
	}
	/**
	 * 以HTML的形式返回所有的学院信息
	 */
	@RequestMapping(value="/selectAllCollege", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectAllCollege() {
		//定义一个StringBuffer对象用来存储要返回的filter_college的下拉菜单
		StringBuffer filter_college = new StringBuffer();
		List<College> collegeNames = collegeService.selectAllCollege();
		//利用迭代器对list进行遍历
		Iterator<College> iterator = collegeNames.iterator();
		filter_college.append("<option value='0'>所有学院</option>");
		while(iterator.hasNext()) {
			College college = iterator.next();
			int collegeId = college.getCollege_id();
			String collegeName = college.getCollege_name();
			filter_college.append("<option value='"+collegeId+"'>"+collegeName+"</option>");
		}
		
		return filter_college.toString();
	}
}

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
	 * ��HTML����ʽ�������е�ѧԺ����
	 */
	@RequestMapping(value="/selectAllCollegeName", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectAllCollegeName() {
		//����һ��StringBuffer���������洢Ҫ���ص�filter_college�������˵�
		StringBuffer filter_college = new StringBuffer();
		List<String> collegeNames = collegeService.selectAllCollegeName();
		//���õ�������list���б���
		Iterator<String> iterator = collegeNames.iterator();
		filter_college.append("<option value='0'>����ѧԺ</option>");
		while(iterator.hasNext()) {
			String collegeName = iterator.next();
			filter_college.append("<option value='"+collegeName+"'>"+collegeName+"</option>");
		}
		
		return filter_college.toString();
	}
	/**
	 * ��HTML����ʽ�������е�ѧԺ��Ϣ
	 */
	@RequestMapping(value="/selectAllCollege", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectAllCollege() {
		//����һ��StringBuffer���������洢Ҫ���ص�filter_college�������˵�
		StringBuffer filter_college = new StringBuffer();
		List<College> collegeNames = collegeService.selectAllCollege();
		//���õ�������list���б���
		Iterator<College> iterator = collegeNames.iterator();
		filter_college.append("<option value='0'>����ѧԺ</option>");
		while(iterator.hasNext()) {
			College college = iterator.next();
			int collegeId = college.getCollege_id();
			String collegeName = college.getCollege_name();
			filter_college.append("<option value='"+collegeId+"'>"+collegeName+"</option>");
		}
		
		return filter_college.toString();
	}
}

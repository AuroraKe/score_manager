package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.bean.College;
import com.neu.dao.CollegeMapper;

@Service
public class CollegeService {
	@Autowired
	private CollegeMapper collegeMapper;
	
	//查询所有的学院名称并返回
	public List<String> selectAllCollegeName(){
		return collegeMapper.selectAllCollegeName();
	}
	
	//查询所有的学院信息并返回
	public List<College> selectAllCollege(){
		return collegeMapper.selectAllCollege();
	}
}

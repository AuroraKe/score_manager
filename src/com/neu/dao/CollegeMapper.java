package com.neu.dao;

import java.util.List;

import com.neu.bean.College;

public interface CollegeMapper {
	//查询所有学院的名称
	public List<String> selectAllCollegeName();
	
	//查询所有学院信息
	public List<College> selectAllCollege();
	
	//根据学院id查询学院名称
	public College selectById(int college_id);
}

package com.neu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.bean.Classes;


public interface ClassesMapper {
	//添加班级
	public void insert(@Param("class_name")String className);
	
	//查询所有班级
	public List<Classes> selectAll();
	
	//根据班级id删除该班级
	public void deleteById(@Param("class_id")Integer classId);
	
	//根据班级id修改班级名称
	public void updateById(@Param("class_id")Integer classId, @Param("class_name")String class_name);
	
	//查询所有班级的名称
	public List<String> selectClassName();
}

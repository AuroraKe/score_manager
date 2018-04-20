package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neu.bean.Classes;
import com.neu.dao.ClassesMapper;

@Service
public class ClassesService {
	@Autowired
	private ClassesMapper classesMapper;
	
	public void insert(String className) {
		classesMapper.insert(className);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<Classes> selectAll(){
		return classesMapper.selectAll();
	}

	//根据班级ID删除班级信息
	public void deleteById(Integer class_id) {
		classesMapper.deleteById(class_id);
	}
	
	//根据班级id更新班级名称
	public void updateById(Integer class_id, String class_name) {
		classesMapper.updateById(class_id, class_name);
	}
	
	//查询所有班级名称
	public List<String> selectClassName(){
		return classesMapper.selectClassName();
	}
}

package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.bean.Teacher;
import com.neu.dao.TeacherMapper;

@Service
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;
	
	//根据学院id和教师名字查询教师信息
	public List<Teacher> selectByName(String teacherName, int filter_college){
		return teacherMapper.selectByName(teacherName, filter_college);
	}
	
	//添加教师信息
	public void insert(String teacherName, int collegeId) {
		teacherMapper.insert(teacherName, collegeId);
	}
	
	//删除教师信息
	public void deleteById(int teacher_id) {
		teacherMapper.deleteById(teacher_id);
	}
	
	//修改教师信息
	public void update(String teacherName, int collegeId, int teacherId) {
		teacherMapper.update(teacherName, collegeId, teacherId);
	}
}

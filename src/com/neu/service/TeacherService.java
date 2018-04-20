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
	
	//����ѧԺid�ͽ�ʦ���ֲ�ѯ��ʦ��Ϣ
	public List<Teacher> selectByName(String teacherName, int filter_college){
		return teacherMapper.selectByName(teacherName, filter_college);
	}
	
	//��ӽ�ʦ��Ϣ
	public void insert(String teacherName, int collegeId) {
		teacherMapper.insert(teacherName, collegeId);
	}
	
	//ɾ����ʦ��Ϣ
	public void deleteById(int teacher_id) {
		teacherMapper.deleteById(teacher_id);
	}
	
	//�޸Ľ�ʦ��Ϣ
	public void update(String teacherName, int collegeId, int teacherId) {
		teacherMapper.update(teacherName, collegeId, teacherId);
	}
}

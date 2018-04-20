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
	
	//��ѯ���е�ѧԺ���Ʋ�����
	public List<String> selectAllCollegeName(){
		return collegeMapper.selectAllCollegeName();
	}
	
	//��ѯ���е�ѧԺ��Ϣ������
	public List<College> selectAllCollege(){
		return collegeMapper.selectAllCollege();
	}
}

package com.neu.dao;

import java.util.List;

import com.neu.bean.College;

public interface CollegeMapper {
	//��ѯ����ѧԺ������
	public List<String> selectAllCollegeName();
	
	//��ѯ����ѧԺ��Ϣ
	public List<College> selectAllCollege();
	
	//����ѧԺid��ѯѧԺ����
	public College selectById(int college_id);
}

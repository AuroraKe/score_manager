package com.neu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.bean.Classes;


public interface ClassesMapper {
	//��Ӱ༶
	public void insert(@Param("class_name")String className);
	
	//��ѯ���а༶
	public List<Classes> selectAll();
	
	//���ݰ༶idɾ���ð༶
	public void deleteById(@Param("class_id")Integer classId);
	
	//���ݰ༶id�޸İ༶����
	public void updateById(@Param("class_id")Integer classId, @Param("class_name")String class_name);
	
	//��ѯ���а༶������
	public List<String> selectClassName();
}

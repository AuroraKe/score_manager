package com.neu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.bean.Teacher;

public interface TeacherMapper {
	/**
	 * �����ݶ������ʱ��Ҫʹ��@param��ǩ����Ϊ���ݶ������ʱ��mybatis��������⴦����������װ��map��
	 * ����ֱ�ӽ������Ž�map�У�����map����Ҳ�� 
	 * @param filterCollege
	 * @return
	 */
	//����ѧԺid�ͽ�ʦ���ֲ�ѯ��ʦ��Ϣ
	public List<Teacher> selectByName(@Param("teacher_name")String teacherName, 
			@Param("filter_college")int filterCollege);
	
	//��ӽ�ʦ��Ϣ
	public void insert(@Param("teacher_name")String teacherName, @Param("college_id")int collegeId);
	
	//���ݽ�ʦidɾ����ʦ��Ϣ
	public void deleteById(@Param("teacher_id")int teacherId);
	
	//���ݽ�ʦid�޸Ľ�ʦ��Ϣ
	public void update(@Param("teacher_name")String teacherName, @Param("college_id")int collegeId, 
			@Param("teacher_id")int teacherId);
}

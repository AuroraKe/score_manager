package com.neu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.bean.Teacher;

public interface TeacherMapper {
	/**
	 * 当传递多个参数时需要使用@param标签，因为传递多个参数时，mybatis会进行特殊处理，将参数封装成map。
	 * 或者直接将参数放进map中，传递map对象也行 
	 * @param filterCollege
	 * @return
	 */
	//根据学院id和教师名字查询教师信息
	public List<Teacher> selectByName(@Param("teacher_name")String teacherName, 
			@Param("filter_college")int filterCollege);
	
	//添加教师信息
	public void insert(@Param("teacher_name")String teacherName, @Param("college_id")int collegeId);
	
	//根据教师id删除教师信息
	public void deleteById(@Param("teacher_id")int teacherId);
	
	//根据教师id修改教师信息
	public void update(@Param("teacher_name")String teacherName, @Param("college_id")int collegeId, 
			@Param("teacher_id")int teacherId);
}

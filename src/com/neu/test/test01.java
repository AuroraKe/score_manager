package com.neu.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neu.bean.Classes;
import com.neu.bean.College;
import com.neu.bean.Teacher;
import com.neu.dao.ClassesMapper;
import com.neu.dao.CollegeMapper;
import com.neu.dao.TeacherMapper;
import com.neu.dao.UserMapper;

public class test01 {

	//测试数据库连通性
	@Test
	public void testCon() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = ctx.getBean(DataSource.class);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		return sqlSessionFactory;
	}
	
	@Test
	public void test02() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ClassesMapper userMapper = sqlSession.getMapper(ClassesMapper.class);
		List<Classes> classes = userMapper.selectAll();
		System.out.println(classes.size());
		sqlSession.commit();
	}
	@Test
	public void test03() throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ClassesMapper classesMapper = ctx.getBean(ClassesMapper.class);
//		List<Classes> classes = classesMapper.selectAll();
//		System.out.println(classes.size());
//		对teachermapper进行测试
//		TeacherMapper teacherMapper = ctx.getBean(TeacherMapper.class);
//		List<Teacher> teachers = teacherMapper.selectByName("习", 0);
		
//		CollegeMapper collegeMapper = ctx.getBean(CollegeMapper.class);
//		System.out.println(collegeMapper.selectById(16).getCollege_name());
		
		TeacherMapper teacherMapper = ctx.getBean(TeacherMapper.class);
	}

}

package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.bean.Teacher;
import com.neu.service.TeacherService;
import com.neu.utils.TokenProcessor;

@RequestMapping(value="/teacher")
@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * @param request
	 * @return
	 * 根据学院名称和教师名字查找教师信息
	 * 通过@ResponseBody注解可以直接将返回的数据转换成json数据
	 */
	@RequestMapping(value="/selectByName")
	@ResponseBody
	public List<Teacher> selectByName(HttpServletRequest request) {
		//获取js传过来的json数据
		String teacher_name = request.getParameter("teacher_name");
		String filter_college = request.getParameter("filter_college");
		//将获取的学院id转换成int型
		int college_id = 0;
		if(filter_college != null && filter_college.length() > 0)
			college_id = Integer.parseInt(filter_college);
		return teacherService.selectByName(teacher_name, college_id);
	}
	
	/**
	 * @param filter_college：学院id
	 * @param teacher_name
	 * @return
	 */
	@RequestMapping(value="/insert")
	public String insert(@RequestParam("filter_college")String filter_college, 
			@RequestParam("teacher_name")String teacher_name, HttpServletRequest request) {
		//接受客户端的token
		String client_token = request.getParameter("class_token");
		//如果客户端的token为空则证明重复提交
		if(client_token == null) {
			System.out.println("重复提交");
			return "admin/teacher_manager";
		}
		
		//获取服务器端的token
		String server_token = (String)request.getSession().getAttribute("token");
		//如果服务器端和客户端的服务器不相等，则重复提交
		if(!client_token.equals(server_token)) {
			System.out.println("重复提交");
			return "admin/teacher_manager";
		}
		
		//随后立即移除session中的token属性
		request.getSession().removeAttribute("token");
		int role_id = Integer.parseInt(filter_college);
		teacherService.insert(teacher_name, role_id);
		return "admin/teacher_manager";
	}
	
	/**
	 * 标签@PathVariable支持REST风格
	 */
	@RequestMapping(value="/deleteById/{teacher_id}", method=RequestMethod.GET)
	public String deleteById(@PathVariable("teacher_id")int teacher_id) {
		teacherService.deleteById(teacher_id);
		return "admin/teacher_manager";
	}
	
	@RequestMapping(value="/update/{teacher_id}")
	public String update(@RequestParam(value="teacher_name", required=false)String teacherName, 
			@RequestParam(value="college_id", required=false)int collegeId, 
			@PathVariable(value="teacher_id")String teacherId) {
		System.out.println("test");
		System.out.println(teacherId);
		//teacherService.update(teacherName, collegeId, teacherId);
		return "admin/teacher_manager";
	}
	
	/**
	 * 负责页面的跳转，转到teacher_manager.jsp页面
	 */
	@RequestMapping(value="/teacher_manager")
	public String teacher_manager(HttpServletRequest request) {
		//向teacher_manager.jsp界面的隐藏域传值，用来防止重复提交
		String token = TokenProcessor.geTokenProcessor().makeToken();
		request.getSession().setAttribute("token", token);
		return "admin/teacher_manager";
	}
}

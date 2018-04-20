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
	 * ����ѧԺ���ƺͽ�ʦ���ֲ��ҽ�ʦ��Ϣ
	 * ͨ��@ResponseBodyע�����ֱ�ӽ����ص�����ת����json����
	 */
	@RequestMapping(value="/selectByName")
	@ResponseBody
	public List<Teacher> selectByName(HttpServletRequest request) {
		//��ȡjs��������json����
		String teacher_name = request.getParameter("teacher_name");
		String filter_college = request.getParameter("filter_college");
		//����ȡ��ѧԺidת����int��
		int college_id = 0;
		if(filter_college != null && filter_college.length() > 0)
			college_id = Integer.parseInt(filter_college);
		return teacherService.selectByName(teacher_name, college_id);
	}
	
	/**
	 * @param filter_college��ѧԺid
	 * @param teacher_name
	 * @return
	 */
	@RequestMapping(value="/insert")
	public String insert(@RequestParam("filter_college")String filter_college, 
			@RequestParam("teacher_name")String teacher_name, HttpServletRequest request) {
		//���ܿͻ��˵�token
		String client_token = request.getParameter("class_token");
		//����ͻ��˵�tokenΪ����֤���ظ��ύ
		if(client_token == null) {
			System.out.println("�ظ��ύ");
			return "admin/teacher_manager";
		}
		
		//��ȡ�������˵�token
		String server_token = (String)request.getSession().getAttribute("token");
		//����������˺Ϳͻ��˵ķ���������ȣ����ظ��ύ
		if(!client_token.equals(server_token)) {
			System.out.println("�ظ��ύ");
			return "admin/teacher_manager";
		}
		
		//��������Ƴ�session�е�token����
		request.getSession().removeAttribute("token");
		int role_id = Integer.parseInt(filter_college);
		teacherService.insert(teacher_name, role_id);
		return "admin/teacher_manager";
	}
	
	/**
	 * ��ǩ@PathVariable֧��REST���
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
	 * ����ҳ�����ת��ת��teacher_manager.jspҳ��
	 */
	@RequestMapping(value="/teacher_manager")
	public String teacher_manager(HttpServletRequest request) {
		//��teacher_manager.jsp�����������ֵ��������ֹ�ظ��ύ
		String token = TokenProcessor.geTokenProcessor().makeToken();
		request.getSession().setAttribute("token", token);
		return "admin/teacher_manager";
	}
}

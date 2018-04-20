package com.neu.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.bean.Classes;
import com.neu.service.ClassesService;
import com.neu.utils.TokenProcessor;

/**
 * @author Eternity
 *
 */
@RequestMapping("/classes")
@Controller
public class ClassesController {

	@Autowired
	private ClassesService classesService;
	
	
	/**
	 * ��Ӱ༶
	 * @param className:�༶����
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(@RequestParam("className")String className, HttpServletRequest request) {
		//���ܿͻ��˵�token
		String client_token = request.getParameter("token");
		//����ͻ��˵�tokenΪ����֤���ظ��ύ
		if(client_token == null) {
			return "admin/classes_add";
		}
		
		//��ȡ�������˵�token
		String server_token = (String)request.getSession().getAttribute("token");
		//����������˺Ϳͻ��˵ķ���������ȣ����ظ��ύ
		if(!client_token.equals(server_token)) {
			return "admin/classes_add";
		}
		
		//��������Ƴ�session�е�token����
		request.getSession().removeAttribute("token");
		classesService.insert(className);
		return "admin/classes_add";
	}
	
	/**
	 * ��ѯ���еİ༶������
	 * ��listת����json���ݲ�����
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/selectAll", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectAll(){
		List<Classes> classes = classesService.selectAll();
		//����ObjectMapper���󣬿��Խ��б�listת����json����
		ObjectMapper mapper = new ObjectMapper();
		String string = null;
		try {
			string = mapper.writeValueAsString(classes);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
	
	/**
	 * ����idɾ���༶
	 */
	@RequestMapping(value="/deleteById")
	public String deleteById(HttpServletRequest request) {
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		classesService.deleteById(class_id);
		return "admin/classes_add";
	}
	
	/**
	 * ���ݰ༶id���°༶����
	 */
	@RequestMapping(value="/updateById")
	public String updateById(@RequestParam("class_id")String c_id, @RequestParam("class_name")String class_name, 
			HttpServletRequest request) {
		//���ܿͻ��˵�token
		String client_token = request.getParameter("class_token");
		//����ͻ��˵�tokenΪ����֤���ظ��ύ
		if(client_token == null) {
			return "admin/classes_add";
		}
		
		//��ȡ�������˵�token
		String server_token = (String)request.getSession().getAttribute("token");
		//����������˺Ϳͻ��˵ķ���������ȣ����ظ��ύ
		if(!client_token.equals(server_token)) {
			return "admin/classes_add";
		}
		
		//��������Ƴ�session�е�token����
		request.getSession().removeAttribute("token");
		int class_id = Integer.parseInt(c_id);
		classesService.updateById(class_id, class_name);
		//�Ƴ�session�е�class_id����
		request.getSession().removeAttribute("class_id");
		
		return "admin/classes_add";
	}
	
	/**
	 * ��HTML����ʽ�������еİ༶����
	 */
	@RequestMapping(value="/selectClassName", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectClassName() {
		//����һ��StringBuffer���������洢Ҫ���ص�filter_classes�������˵�
		StringBuffer filter_classes = new StringBuffer();
		List<String> classNames = classesService.selectClassName();
		//���õ�������list���б���
		Iterator<String> iterator = classNames.iterator();
		filter_classes.append("<option value='ALL'>���а༶</option>");
		while(iterator.hasNext()) {
			String className = iterator.next();
			filter_classes.append("<option value='"+className+"'>"+className+"</option>");
		}
		
		return filter_classes.toString();
	}
	
	/**
	 * ����ҳ����ת,��ת���༶�༭��ҳ�棬���Խ��а༶���Ƹ���
	 */
	@RequestMapping(value="/classes_edit")
	public String classes_edit(HttpServletRequest request) {
		//��class_edit.jspҳ�洫��class_id
		String class_id = request.getParameter("class_id");
		request.getSession().setAttribute("class_id", class_id);
		
		//��class_edit.jsp����Ĵ���token��ֹ�ظ��ύ
		String token = TokenProcessor.geTokenProcessor().makeToken();
		request.getSession().setAttribute("token", token);
		return "admin/classes_edit";
	}
	
	
	/**
	 * ��������ת��������ҳʱ��������ת���༶����Ľ��棬���а༶��ɾ�Ĳ飬�����и�ֵ��
	 * ��ֹ�ظ��ύ
	 */
	@RequestMapping("/classes_add")
	public String classes_add(HttpServletRequest request) {
		//��class_add�����������ֵ
		String token = TokenProcessor.geTokenProcessor().makeToken();
		request.getSession().setAttribute("token", token);
		return "admin/classes_add";
	}
	
	/**
	 * @return ��ѯ���еİ༶������
	 * ��һ��ֱ�ӷ���json���ݵķ���
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Classes> getAll(){
		return classesService.selectAll();
	}
}

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
	 * 添加班级
	 * @param className:班级名称
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(@RequestParam("className")String className, HttpServletRequest request) {
		//接受客户端的token
		String client_token = request.getParameter("token");
		//如果客户端的token为空则证明重复提交
		if(client_token == null) {
			return "admin/classes_add";
		}
		
		//获取服务器端的token
		String server_token = (String)request.getSession().getAttribute("token");
		//如果服务器端和客户端的服务器不相等，则重复提交
		if(!client_token.equals(server_token)) {
			return "admin/classes_add";
		}
		
		//随后立即移除session中的token属性
		request.getSession().removeAttribute("token");
		classesService.insert(className);
		return "admin/classes_add";
	}
	
	/**
	 * 查询所有的班级并返回
	 * 将list转换成json数据并返回
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/selectAll", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectAll(){
		List<Classes> classes = classesService.selectAll();
		//创建ObjectMapper对象，可以将列表list转换成json对象
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
	 * 根据id删除班级
	 */
	@RequestMapping(value="/deleteById")
	public String deleteById(HttpServletRequest request) {
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		classesService.deleteById(class_id);
		return "admin/classes_add";
	}
	
	/**
	 * 根据班级id更新班级名称
	 */
	@RequestMapping(value="/updateById")
	public String updateById(@RequestParam("class_id")String c_id, @RequestParam("class_name")String class_name, 
			HttpServletRequest request) {
		//接受客户端的token
		String client_token = request.getParameter("class_token");
		//如果客户端的token为空则证明重复提交
		if(client_token == null) {
			return "admin/classes_add";
		}
		
		//获取服务器端的token
		String server_token = (String)request.getSession().getAttribute("token");
		//如果服务器端和客户端的服务器不相等，则重复提交
		if(!client_token.equals(server_token)) {
			return "admin/classes_add";
		}
		
		//随后立即移除session中的token属性
		request.getSession().removeAttribute("token");
		int class_id = Integer.parseInt(c_id);
		classesService.updateById(class_id, class_name);
		//移除session中的class_id属性
		request.getSession().removeAttribute("class_id");
		
		return "admin/classes_add";
	}
	
	/**
	 * 以HTML的形式返回所有的班级名称
	 */
	@RequestMapping(value="/selectClassName", produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectClassName() {
		//定义一个StringBuffer对象用来存储要返回的filter_classes的下拉菜单
		StringBuffer filter_classes = new StringBuffer();
		List<String> classNames = classesService.selectClassName();
		//利用迭代器对list进行遍历
		Iterator<String> iterator = classNames.iterator();
		filter_classes.append("<option value='ALL'>所有班级</option>");
		while(iterator.hasNext()) {
			String className = iterator.next();
			filter_classes.append("<option value='"+className+"'>"+className+"</option>");
		}
		
		return filter_classes.toString();
	}
	
	/**
	 * 负责页面跳转,跳转到班级编辑的页面，可以进行班级名称更改
	 */
	@RequestMapping(value="/classes_edit")
	public String classes_edit(HttpServletRequest request) {
		//向class_edit.jsp页面传递class_id
		String class_id = request.getParameter("class_id");
		request.getSession().setAttribute("class_id", class_id);
		
		//向class_edit.jsp界面的传递token防止重复提交
		String token = TokenProcessor.geTokenProcessor().makeToken();
		request.getSession().setAttribute("token", token);
		return "admin/classes_edit";
	}
	
	
	/**
	 * 负责面跳转，在子首页时，可以跳转到班级管理的界面，进行班级增删改查，并进行赋值，
	 * 防止重复提交
	 */
	@RequestMapping("/classes_add")
	public String classes_add(HttpServletRequest request) {
		//向class_add界面的隐藏域传值
		String token = TokenProcessor.geTokenProcessor().makeToken();
		request.getSession().setAttribute("token", token);
		return "admin/classes_add";
	}
	
	/**
	 * @return 查询所有的班级并返回
	 * 另一种直接返回json数据的方法
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Classes> getAll(){
		return classesService.selectAll();
	}
}

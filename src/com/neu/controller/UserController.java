package com.neu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.bean.User;
import com.neu.service.UserService;

/**
 * @author Eternity
 *
 */
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public String login(@RequestParam("username")String username, @RequestParam("password")String password, 
			HttpServletRequest request, HttpServletResponse response) {
		int role_id = Integer.parseInt(request.getParameter("select"));
		HttpSession session = request.getSession();
		//用于在系统管理员和学生界面等的首页获取值
		session.setAttribute("username", username);
		session.setAttribute("role_id", role_id);
		List<User> users = userService.login(username, password, role_id);
		if(users.size() == 1) {
			if(role_id == 1)
				return "admin/index";
			if(role_id == 2)
				return "admin/index";
			if(role_id == 1)
				return "teacher/index";
			if(role_id == 1)
				return "student/index";
			
		}
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		Object object = request.getSession().getAttribute("username");
		System.out.println(object);
		return "redirect:/index.jsp";
	}
	
	/**
	 * @param authentication: 首页用户输入的验证码
	 */
	@RequestMapping(value="/authentication", method=RequestMethod.POST)
	public void authentication(@RequestParam(name="verifyCode", required=false)String verifyCode, 
			HttpServletResponse response, HttpServletRequest request) {
		String verification = request.getSession().getAttribute("verification").toString().toLowerCase();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			if(verification.equals(verifyCode.toLowerCase())) {
				response.getWriter().print("<font color='green'>验证码正确</font>");
			}else {
				response.getWriter().print("<font color='red'>验证码不正确</font>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/firstpage")
	public String firstpage() {
		return "admin/firstpage";
	}
	@RequestMapping("/menu")
	public String menu() {
		return "admin/menu";
	}
	@RequestMapping("/top")
	public String top() {
		return "admin/top";
	}
}

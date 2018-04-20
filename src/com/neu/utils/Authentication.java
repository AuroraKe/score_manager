package com.neu.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从首页index.jsp接受的用户输入的验证码
		String verification = request.getParameter("verification").toLowerCase();
		//系统生成的验证码
		String verify = request.getSession().getAttribute("verification").toString().toLowerCase();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if(verification.equals(verify)) {
			response.getWriter().print("<font color='green'>验证码正确</font>");
		}else {
			response.getWriter().print("<font color='red'>验证码错误</font>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

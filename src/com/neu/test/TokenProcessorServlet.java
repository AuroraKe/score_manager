package com.neu.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eternity
 *	验证用户是否重复提交
 */
public class TokenProcessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean repeat = isRepeatSubmit(request);
		if(repeat == true) {
			System.out.println("请不要重复提交！");
		}
		request.getSession().removeAttribute("token");
	}
	
	private boolean isRepeatSubmit(HttpServletRequest request) {
		boolean repeat = false;
		//接受客户端的token
		String client_token = request.getParameter("token");
		//如果客户端的token为空则证明重复提交
		if(client_token == null) {
			System.out.println("重复提交");
			repeat = true;
		}
		
		//获取服务器端的token
		String server_token = request.getAttribute("token").toString();
		//如果服务器端和客户端的服务器不相等，则重复提交
		if(!client_token.equals(server_token)) {
			System.out.println("重复提交");
			repeat = true;
		}
		return repeat;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

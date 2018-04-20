package com.neu.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eternity
 *	��֤�û��Ƿ��ظ��ύ
 */
public class TokenProcessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean repeat = isRepeatSubmit(request);
		if(repeat == true) {
			System.out.println("�벻Ҫ�ظ��ύ��");
		}
		request.getSession().removeAttribute("token");
	}
	
	private boolean isRepeatSubmit(HttpServletRequest request) {
		boolean repeat = false;
		//���ܿͻ��˵�token
		String client_token = request.getParameter("token");
		//����ͻ��˵�tokenΪ����֤���ظ��ύ
		if(client_token == null) {
			System.out.println("�ظ��ύ");
			repeat = true;
		}
		
		//��ȡ�������˵�token
		String server_token = request.getAttribute("token").toString();
		//����������˺Ϳͻ��˵ķ���������ȣ����ظ��ύ
		if(!client_token.equals(server_token)) {
			System.out.println("�ظ��ύ");
			repeat = true;
		}
		return repeat;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

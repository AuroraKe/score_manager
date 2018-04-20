package com.neu.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ҳindex.jsp���ܵ��û��������֤��
		String verification = request.getParameter("verification").toLowerCase();
		//ϵͳ���ɵ���֤��
		String verify = request.getSession().getAttribute("verification").toString().toLowerCase();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if(verification.equals(verify)) {
			response.getWriter().print("<font color='green'>��֤����ȷ</font>");
		}else {
			response.getWriter().print("<font color='red'>��֤�����</font>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

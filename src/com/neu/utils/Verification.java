package com.neu.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Verification extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		response.setHeader("Pragma", "No-cache"); 
//		response.setHeader("Cache-Control", "no-cache"); 
//		response.setDateHeader("Expires", 0); 
		response.setContentType("image/jpeg");
		VerificationCode code = new VerificationCode();
		HttpSession session = request.getSession(true);
		String verification = code.generateVerification(4, null);
		session.removeAttribute("verification");
		session.setAttribute("verification", verification);
		code.outputImage(100, 30, verification, response.getOutputStream());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}

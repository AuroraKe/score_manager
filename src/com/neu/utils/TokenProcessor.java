package com.neu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * @author Petrichor
 *	ͨ����������һ�����ƣ�������ֹ���ظ��ύ
 */
public class TokenProcessor {
	/*
	 *�������ģʽ����֤��Ķ������ڴ���ֻ��һ����
	 *1.����Ĺ��캯��˽��
	 *2.�Լ�����һ����Ķ���
	 *3.�����ṩһ����Ĺ���������������Ķ���
	 */
	private TokenProcessor() {}
	
	private static final TokenProcessor TOKEN_PROCESSOR = new TokenProcessor();
	
	public static TokenProcessor geTokenProcessor() {
		return TOKEN_PROCESSOR;
	}
	
	public String makeToken() {
//		new Random()
		String token = System.currentTimeMillis() + new Random().nextInt(999999999) + "";
		//����ָ��	128λ	16���ֽ�	MD5
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(token.getBytes());
			//base64����--��������Ʊ��������ַ�
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
}

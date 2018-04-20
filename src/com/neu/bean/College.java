package com.neu.bean;

/**
 * @author Eternity
 *	此表对应数据库中的college表
 */
public class College {
	private int college_id;
	private String college_name;
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	
}

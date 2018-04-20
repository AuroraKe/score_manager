package com.neu.bean;

public class Teacher {
	private int teacher_id;
	private String teacher_name;
//	private int college_id;
	
	private College college;
//	public int getCollege_id() {
//		return college_id;
//	}
//	public void setCollege_id(int college_id) {
//		this.college_id = college_id;
//	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
	
}

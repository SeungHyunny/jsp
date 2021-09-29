package com.vision.beans;

public class Student {
	private String name;
	private String age;
	private String grade;
	private String studentNum;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + ", studentNum=" + studentNum + "]";
	}
	
	
	
}


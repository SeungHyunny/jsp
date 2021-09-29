package com.vision.beans;

import java.util.Arrays;

//이름, 이메일, 아이디, 비밀번호, 취미, 전공, 연령, 기타
public class Person {
	
	private String name;
	private String email;
	private String id;
	private String pw;
	private String[] hobby;
//	private String major;
	private String age;
	private String txt;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String email, String id, String pw, String[] hobby, String major, String age, String txt) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
		this.pw = pw;
		this.hobby = hobby;
//		this.major = major;
		this.age = age;
		this.txt = txt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

//	public String getMajor() {
//		return major;
//	}
//
//	public void setMajor(String major) {
//		this.major = major;
//	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", id=" + id + ", pw=" + pw + ", hobby=" + Arrays.toString(hobby)
				+ ", age=" + age + ", txt=" + txt + "]";
	}
	
}

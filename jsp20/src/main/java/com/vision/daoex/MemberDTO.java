package com.vision.daoex;

public class MemberDTO {
	private String name;
	private String id;
	private String pw;
	private String phone;
	
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String name, String id, String pw, String phone) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", id=" + id + ", pw=" + pw + ", phone=" + phone + "]";
	}
	
	
}

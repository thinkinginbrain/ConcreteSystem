package com.wzc.login.domain;

/**
 * 
 */
public class Model {
	private Integer id;
	
	private String name;
	
	private String message;

//	private String nickname;
//
//	private String password;
//
//	private String phone;
//
//	private String gender;
//
//	private String email;
//
//	private String address;

	public Integer getModelid() {
		return id;
	}

	public void setModelid(Integer modelid) {
		this.id = modelid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//
//	public String getNickname() {
//		return nickname;
//	}
//
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

	@Override
	public String toString() {
		return "查询结果：Model{" +
				"modelid=" + id +
				", name='" + name + '\'' +
				", message='" + message + '\''+
				'}';
	}
}


package com.wzc.login.domain;

public class APmessage {
    private Integer id;
	
	private String name;

	private String address;

	private String model;

	private String ip;

	private String groupmessage;

	private String state;


	public Integer getid() {
		return id;
	}

	public void setid(Integer userid) {
		this.id = userid;
	}

	public String getname() {
		return name;
	}

	public void setname(String username) {
		this.name = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String password) {
		this.address = password;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String nickname) {
		this.model = nickname;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String phone) {
		this.ip = phone;
	}

	public String getGroupmessage() {
		return groupmessage;
	}

	public void setGroupmessage(String gender) {
		this.groupmessage = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String email) {
		this.state = email;
	}



	@Override
	public String toString() {
		return "查询结果：APmessage{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", model='" + model + '\'' +
				", ip='" + ip + '\'' +
				", groupmessage='" + groupmessage + '\'' +
				", state='" + state + '\''  +
				'}';
	}



}

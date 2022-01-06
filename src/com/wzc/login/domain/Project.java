package com.wzc.login.domain;

/**
 * 
 */
public class Project {
	private Integer id;
	
	private String user;

	private String name;

	private String model;

	

	public Integer getid() {
		return id;
	}

	public void setid(Integer userid) {
		this.id = userid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String username) {
		this.user = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String password) {
		this.name = password;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String nickname) {
		this.model = nickname;
	}

	

	@Override
	public String toString() {
		return "查询结果：Project{" +
				"id=" + id +
				", user='" + user + '\'' +
				", name='" + name + '\'' +
				", model='" + model + '\'' +
				'}';
	}
}

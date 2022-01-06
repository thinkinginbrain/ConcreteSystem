package com.wzc.login.domain;

/**
 * 
 */
public class Logintime {
	private Integer id;
	
	private String username;

	private String login_time;

	private String logout_time;



	public Integer getUserid() {
		return id;
	}

	public void setUserid(Integer userid) {
		this.id = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginTime() {
		return login_time;
	}

	public void setLoginTime(String login_time) {
		this.login_time = login_time;
	}


	public String getLogoutTime() {
		return logout_time;
	}

	public void setLogoutTime(String logout_ime) {
		this.logout_time = logout_ime;
	}


	@Override
	public String toString() {
		return "查询结果：Logintime{" +
				"userid=" + id +
				", username='" + username + '\'' +
				", login_time='" + login_time + '\'' +
				", login_time='" + logout_time + '\'' +

				'}';
	}
}


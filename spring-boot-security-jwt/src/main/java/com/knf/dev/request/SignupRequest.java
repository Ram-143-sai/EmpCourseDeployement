package com.knf.dev.request;

public class SignupRequest {

	private String username;

	private String email;

	private int designationLevel;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getDesignationLevel() {
		return designationLevel;
	}
	public void setDesignationLevel(int designationLevel) {
		this.designationLevel = designationLevel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

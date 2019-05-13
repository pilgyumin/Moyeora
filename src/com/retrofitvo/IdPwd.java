package com.retrofitvo;

public class IdPwd {
	private String id;
	private String pwd;
	
	public IdPwd(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "IdPwd [id=" + id + ", pwd=" + pwd + "]";
	}
	
}

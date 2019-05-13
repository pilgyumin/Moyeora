package com.vo;

public class Admin {
	
	private String aid;
	private String apwd;
	
	public Admin() {}

	public Admin(String aid, String apwd) {
		this.aid = aid;
		this.apwd = apwd;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", apwd=" + apwd + "]";
	}
	
}

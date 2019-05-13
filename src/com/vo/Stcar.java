package com.vo;

public class Stcar {
	
	private String sid;
	private int cid;
	private String rpm;
	private String speed;
	private String ptemp;
	private String htemp;
	private String light;
	private String battery;
	private String seat;
	private String gpsx;
	private String gpsy;
	
	public Stcar(String sid, int cid, String rpm, String speed, String ptemp, String htemp, String light,
			String battery, String seat, String gpsx, String gpsy) {
		this.sid = sid;
		this.cid = cid;
		this.rpm = rpm;
		this.speed = speed;
		this.ptemp = ptemp;
		this.htemp = htemp;
		this.light = light;
		this.battery = battery;
		this.seat = seat;
		this.gpsx = gpsx;
		this.gpsy = gpsy;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getRpm() {
		return rpm;
	}

	public void setRpm(String rpm) {
		this.rpm = rpm;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getPtemp() {
		return ptemp;
	}

	public void setPtemp(String ptemp) {
		this.ptemp = ptemp;
	}

	public String getHtemp() {
		return htemp;
	}

	public void setHtemp(String htemp) {
		this.htemp = htemp;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getGpsx() {
		return gpsx;
	}

	public void setGpsx(String gpsx) {
		this.gpsx = gpsx;
	}

	public String getGpsy() {
		return gpsy;
	}

	public void setGpsy(String gpsy) {
		this.gpsy = gpsy;
	}

	@Override
	public String toString() {
		return "Stcar [sid=" + sid + ", cid=" + cid + ", rpm=" + rpm + ", speed=" + speed + ", ptemp=" + ptemp
				+ ", htemp=" + htemp + ", light=" + light + ", battery=" + battery + ", seat=" + seat + ", gpsx=" + gpsx
				+ ", gpsy=" + gpsy + "]";
	}
	
}

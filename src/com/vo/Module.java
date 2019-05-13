package com.vo;

public class Module {
	private int mid;
	private String mtype;
	private String moption1;
	private String moption2;
	private String moption3;
	private String moption4;
	private String mstatus;
	
	public Module() {}

	// 전체 칼럼 생성자
	public Module(int mid, String mtype, String moption1, String moption2, String moption3, String moption4,
			String mstatus) {
		this.mid = mid;
		this.mtype = mtype;
		this.moption1 = moption1;
		this.moption2 = moption2;
		this.moption3 = moption3;
		this.moption4 = moption4;
		this.mstatus = mstatus;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getMoption1() {
		return moption1;
	}

	public void setMoption1(String moption1) {
		this.moption1 = moption1;
	}

	public String getMoption2() {
		return moption2;
	}

	public void setMoption2(String moption2) {
		this.moption2 = moption2;
	}

	public String getMoption3() {
		return moption3;
	}

	public void setMoption3(String moption3) {
		this.moption3 = moption3;
	}

	public String getMoption4() {
		return moption4;
	}

	public void setMoption4(String moption4) {
		this.moption4 = moption4;
	}

	public String getMstatus() {
		return mstatus;
	}

	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}

	@Override
	public String toString() {
		return "Module [mid=" + mid + ", mtype=" + mtype + ", moption1=" + moption1 + ", moption2=" + moption2
				+ ", moption3=" + moption3 + ", moption4=" + moption4 + ", mstatus=" + mstatus + "]";
	}
	
}

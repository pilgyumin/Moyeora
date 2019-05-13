package com.vo;

import java.util.Date;

public class Order {

	private int oid;
	private String mtype;
	private String moption1;
	private String moption2;
	private String moption3;
	private String moption4;
	private int totalprice;
	private Date odate;
	private double slng;
	private double slag;
	private double elng;
	private double elag;
	private String stime;
	private String etime;
	private String ostatus;
	private int cid;
	private String cust_id;
	private int mid;
	private String insert;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(int oid, String mtype, String moption1, String moption2, String moption3, String moption4,
			int totalprice, Date odate, double slng, double slag, double elng, double elag, String stime, String etime,
			String ostatus, int cid, String cust_id, int mid, String insert) {
		this.oid = oid;
		this.mtype = mtype;
		this.moption1 = moption1;
		this.moption2 = moption2;
		this.moption3 = moption3;
		this.moption4 = moption4;
		this.totalprice = totalprice;
		this.odate = odate;
		this.slng = slng;
		this.slag = slag;
		this.elng = elng;
		this.elag = elag;
		this.stime = stime;
		this.etime = etime;
		this.ostatus = ostatus;
		this.cid = cid;
		this.cust_id = cust_id;
		this.mid = mid;
		this.insert = insert;
	}




	//order ���̺� ������
	public Order(String mtype, String moption1, String moption2, String moption3, String moption4, int totalprice,
			double slng, double slag, double elng, double elag, String stime, String etime, String ostatus, int cid,
			String cust_id, int mid) {
		this.mtype = mtype;
		this.moption1 = moption1;
		this.moption2 = moption2;
		this.moption3 = moption3;
		this.moption4 = moption4;
		this.totalprice = totalprice;
		this.slng = slng;
		this.slag = slag;
		this.elng = elng;
		this.elag = elag;
		this.stime = stime;
		this.etime = etime;
		this.ostatus = ostatus;
		this.cid = cid;
		this.cust_id = cust_id;
		this.mid = mid;
	}



	// �ܰŸ��� ������
	public Order(int oid, String mtype, String moption1, String moption2, int totalprice, Date odate, double slng,
			double slag, double elng, double elag, String stime, String etime, String ostatus, int cid, String cust_id,
			int mid) {
		this.oid = oid;
		this.mtype = mtype;
		this.moption1 = moption1;
		this.moption2 = moption2;
		this.totalprice = totalprice;
		this.odate = odate;
		this.slng = slng;
		this.slag = slag;
		this.elng = elng;
		this.elag = elag;
		this.stime = stime;
		this.etime = etime;
		this.ostatus = ostatus;
		this.cid = cid;
		this.cust_id = cust_id;
		this.mid = mid;
	}
	
	

	public Order(int oid, String mtype, String moption1, String moption2, String moption3, String moption4,
			int totalprice, Date odate, double slng, double slag, double elng, double elag, String stime, String etime,
			String ostatus, int cid, String cust_id, int mid) {
		this.oid = oid;
		this.mtype = mtype;
		this.moption1 = moption1;
		this.moption2 = moption2;
		this.moption3 = moption3;
		this.moption4 = moption4;
		this.totalprice = totalprice;
		this.odate = odate;
		this.slng = slng;
		this.slag = slag;
		this.elng = elng;
		this.elag = elag;
		this.stime = stime;
		this.etime = etime;
		this.ostatus = ostatus;
		this.cid = cid;
		this.cust_id = cust_id;
		this.mid = mid;
	}

	// ��� Į�� ������
	
	

	public int getOid() {
		return oid;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public void setOid(int oid) {
		this.oid = oid;
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

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public Date getOdate() {
		return odate;
	}

	public void setOdate(Date odate) {
		this.odate = odate;
	}

	public double getSlng() {
		return slng;
	}

	public void setSlng(double slng) {
		this.slng = slng;
	}

	public double getSlag() {
		return slag;
	}

	public void setSlag(double slag) {
		this.slag = slag;
	}

	public double getElng() {
		return elng;
	}

	public void setElng(double elng) {
		this.elng = elng;
	}

	public double getElag() {
		return elag;
	}

	public void setElag(double elag) {
		this.elag = elag;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", mtype=" + mtype + ", moption1=" + moption1 + ", moption2=" + moption2
				+ ", moption3=" + moption3 + ", moption4=" + moption4 + ", totalprice=" + totalprice + ", odate="
				+ odate + ", slng=" + slng + ", slag=" + slag + ", elng=" + elng + ", elag=" + elag + ", stime=" + stime
				+ ", etime=" + etime + ", ostatus=" + ostatus + ", cid=" + cid + ", cust_id=" + cust_id + ", mid=" + mid
				+ "]";
	}

}

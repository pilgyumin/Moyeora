package com.vo;

public class Updatevo {
	
	private String column;
	private String value;
	private String cust_id;
	
	public Updatevo() {
		
	}

	public Updatevo(String column, String value, String pk) {
		super();
		this.column = column;
		this.value = value;
		this.cust_id = pk;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCust_id() {
		return cust_id;
	}


	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	
}

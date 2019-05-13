package com.mapper;

import java.util.ArrayList;

import com.vo.Cust;

public interface CustMapper {
	
	public void insert(Cust obj);
	
	public void deleteString(String s);
	public void deleteInt(int i);
	public void deleteDouble(double d);
	
	public void update(Cust obj);
	public void updateColumn(Cust obj);
	
	public Object selectString(String s);
	public Object selectInt(int i);
	public Object selectDouble(double d);
	
	public ArrayList<Cust> selectArString(String s);
	public ArrayList<Cust> selectArInt(int i);
	public ArrayList<Cust> selectArDouble(double d);
	
	public ArrayList<Cust> selectall();
	
}

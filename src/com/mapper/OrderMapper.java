package com.mapper;

import java.util.ArrayList;

import com.vo.Order;
import com.vo.Updatevo;

public interface OrderMapper {
	
	public void insert(Order obj);
	
	public void deleteString(String s);
	public void deleteInt(int i);
	public void deleteDouble(double d);
	
	public void update(Order obj);
	public void updateColumn(Updatevo obj);
	
	public Object selectString(String s);
	public Object selectInt(int i);
	public Object selectDouble(double d);
	
	public ArrayList<Order> selectArString(String s);
	public ArrayList<Order> selectArInt(int i);
	public ArrayList<Order> selectArDouble(double d);
	
	public ArrayList<Order> selectall();
	
}

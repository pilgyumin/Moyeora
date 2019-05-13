package com.mapper;

import java.util.ArrayList;

import com.vo.Admin;
import com.vo.Updatevo;

public interface AdminMapper {
	
	public void insert(Admin obj);
	
	public void deleteString(String s);
	public void deleteInt(int i);
	public void deleteDouble(double d);
	
	public void update(Admin obj);
	public void updateColumn(Updatevo obj);
	
	public Object selectString(String s);
	public Object selectInt(int i);
	public Object selectDouble(double d);
	
	public ArrayList<Admin> selectArString(String s);
	public ArrayList<Admin> selectArInt(int i);
	public ArrayList<Admin> selectArDouble(double d);
	
	public ArrayList<Admin> selectall();
	
}

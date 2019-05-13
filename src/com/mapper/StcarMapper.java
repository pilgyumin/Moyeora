package com.mapper;

import java.util.ArrayList;

import com.vo.Stcar;
import com.vo.Updatevo;

public interface StcarMapper {
	
	public void insert(Stcar obj);
	
	public void deleteString(String s);
	public void deleteInt(int i);
	public void deleteDouble(double d);
	
	public void update(Stcar obj);
	public void updateColumn(Updatevo obj);
	
	public Object selectString(String s);
	public Object selectInt(int i);
	public Object selectDouble(double d);
	
	public ArrayList<Stcar> selectArString(String s);
	public ArrayList<Stcar> selectArInt(int i);
	public ArrayList<Stcar> selectArDouble(double d);
	
	public ArrayList<Stcar> selectall();
	
}

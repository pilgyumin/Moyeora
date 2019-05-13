package com.mapper;

import java.util.ArrayList;

import com.vo.Car;
import com.vo.Updatevo;

public interface CarMapper {
	
	public void insert(Car obj);
	
	public void deleteString(String s);
	public void deleteInt(int i);
	public void deleteDouble(double d);
	
	public void update(Car obj);
	public void updateColumn(Updatevo obj);
	
	public Object selectString(String s);
	public Object selectInt(int i);
	public Object selectDouble(double d);
	
	public ArrayList<Car> selectArString(String s);
	public ArrayList<Car> selectArInt(int i);
	public ArrayList<Car> selectArDouble(double d);
	
	public ArrayList<Car> selectall();
	
}

package com.mapper;

import java.util.ArrayList;

import com.vo.Module;
import com.vo.Updatevo;

public interface ModuleMapper {
	
	public void insert(Module obj);
	
	public void deleteString(String s);
	public void deleteInt(int i);
	public void deleteDouble(double d);
	
	public void update(Module obj);
	public void updateColumn(Updatevo obj);
	
	public Object selectString(String s);
	public Object selectInt(int i);
	public Object selectDouble(double d);
	public Object selectCid();
	
	public ArrayList<Module> selectArString(String s);
	public ArrayList<Module> selectArInt(int i);
	public ArrayList<Module> selectArDouble(double d);
	
	public ArrayList<Module> selectall();
	
}

package com.frame;

import java.util.ArrayList;

public interface CrudDao<str,intt,doub,objec,obj> {
	
	// insert 문
	public void insert(objec o);

	// delete 문
	public void deleteString(str s);
	public void deleteInt(intt i);
	public void deleteDouble(doub d);
	
	// update 문
	public void update(objec o);
	public void updateColumn(obj o);
	
	// select 문(객체 하나) 
	public objec selectString(str s);
	public objec selectInt(intt i);
	public objec selectDouble(doub d);
	
	// select 문(객체 배열)
	public ArrayList<objec> selectArString(str s);
	public ArrayList<objec> selectArInt(intt i);
	public ArrayList<objec> selectArDouble(doub d);
	
	// select 문 (테이블 전체)
	public ArrayList<objec> selectall();
} 
  
package com.frame;

import java.util.ArrayList;

public interface CrudDao<str,intt,doub,objec,obj> {
	
	// insert ��
	public void insert(objec o);

	// delete ��
	public void deleteString(str s);
	public void deleteInt(intt i);
	public void deleteDouble(doub d);
	
	// update ��
	public void update(objec o);
	public void updateColumn(obj o);
	
	// select ��(��ü �ϳ�) 
	public objec selectString(str s);
	public objec selectInt(intt i);
	public objec selectDouble(doub d);
	
	// select ��(��ü �迭)
	public ArrayList<objec> selectArString(str s);
	public ArrayList<objec> selectArInt(intt i);
	public ArrayList<objec> selectArDouble(doub d);
	
	// select �� (���̺� ��ü)
	public ArrayList<objec> selectall();
} 
  
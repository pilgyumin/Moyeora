package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface CrudBiz<str,intt,doub,objec,obj> {
	// register 기능
	@Transactional
	public void register(objec o) throws Exception;
	
	// remove 기능
	@Transactional
	public void removeString(str s) throws Exception;
	@Transactional
	public void removeInt(intt i) throws Exception;
	@Transactional
	public void removeDouble(doub d) throws Exception;
	
	// modify 기능
	@Transactional
	public void modify(objec o) throws Exception;
	@Transactional
	public void modifyColumn(obj o) throws Exception;
	
	// get (객체 하나) 기능
	public objec getString(str s) throws Exception;
	public objec getInt(intt i) throws Exception;
	public objec getDouble(doub d) throws Exception;
	
	// get (객체 여러개) 기능
	public ArrayList<objec> getArString(str s) throws Exception;
	public ArrayList<objec> getArInt(intt i) throws Exception;
	public ArrayList<objec> getArDouble(doub b) throws Exception;
	
	// get (객체 전부) 기능
	public ArrayList<objec> getall() throws Exception;
} 

package com.cust;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.CrudBiz;
import com.frame.CrudDao;
import com.vo.Cust;

@Service("custbiz")
public class CustBiz implements CrudBiz<String, Integer, Double, Cust, Cust> {
	
	@Resource(name="custdao")
	CrudDao<String, Integer, Double, Cust, Cust> dao;

	@Override
	public void register(Cust o) throws Exception {
		dao.insert(o);
	}

	@Override
	public void removeString(String s) throws Exception {
		dao.deleteString(s);
	}

	@Override
	public void removeInt(Integer i) throws Exception {
		dao.deleteInt(i);
	}

	@Override
	public void removeDouble(Double d) throws Exception {
		dao.deleteDouble(d);
	}

	@Override
	public void modify(Cust o) throws Exception {
		dao.update(o);
	}
	
	@Override
	public void modifyColumn(Cust o) throws Exception {
		dao.updateColumn(o);
	}

	@Override
	public Cust getString(String s) throws Exception {
		return (Cust) dao.selectString(s);
	}

	@Override
	public Cust getInt(Integer i) throws Exception {
		return (Cust) dao.selectInt(i);
	}

	@Override
	public Cust getDouble(Double d) throws Exception {
		return (Cust) dao.selectDouble(d);
	}

	@Override
	public ArrayList<Cust> getArString(String s) throws Exception {
		return dao.selectArString(s);
	}

	@Override
	public ArrayList<Cust> getArInt(Integer i) throws Exception {
		return dao.selectArInt(i);
	}

	@Override
	public ArrayList<Cust> getArDouble(Double d) throws Exception {
		return dao.selectArDouble(d);
	}

	@Override
	public ArrayList<Cust> getall() throws Exception {
		return dao.selectall();
	}

}

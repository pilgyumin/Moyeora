package com.cust;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.CrudDao;
import com.mapper.CustMapper;
import com.vo.Cust;
import com.vo.Updatevo;

@Repository("custdao")
public class CustDao implements CrudDao<String, Integer, Double, Cust, Cust> {
	
	@Autowired
	CustMapper cm;

	@Override
	public void insert(Cust o) {
		cm.insert(o);
	}

	@Override
	public void deleteString(String s) {
		cm.deleteString(s);
	}

	@Override
	public void deleteInt(Integer i) {
		cm.deleteInt(i);
	}

	@Override
	public void deleteDouble(Double d) {
		cm.deleteDouble(d);
	}

	@Override
	public void update(Cust o) {
		cm.update(o);
	}
	
	@Override
	public void updateColumn(Cust o) {
		cm.updateColumn(o);
	}

	@Override
	public Cust selectString(String s) {
		return (Cust) cm.selectString(s);
	}

	@Override
	public Cust selectInt(Integer i) {
		return (Cust) cm.selectInt(i);
	}

	@Override
	public Cust selectDouble(Double d) {
		return (Cust) cm.selectDouble(d);
	}

	@Override
	public ArrayList<Cust> selectArString(String s) {
		return cm.selectArString(s);
	}

	@Override
	public ArrayList<Cust> selectArInt(Integer i) {
		return cm.selectArInt(i);
	}

	@Override
	public ArrayList<Cust> selectArDouble(Double d) {
		return cm.selectArDouble(d);
	}

	@Override
	public ArrayList<Cust> selectall() {
		return cm.selectall();
	}

}

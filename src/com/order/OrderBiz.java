package com.order;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.CrudBiz;
import com.frame.CrudDao;
import com.vo.Order;
import com.vo.Updatevo;

@Service("orderbiz")
public class OrderBiz implements CrudBiz<String, Integer, Double, Order,Updatevo> {
	
	@Resource(name="orderdao")
	CrudDao<String, Integer, Double, Order,Updatevo> dao;

	@Override
	public void register(Order o) throws Exception {
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
	public void modify(Order o) throws Exception {
		dao.update(o);
	}
	
	@Override
	public void modifyColumn(Updatevo o) throws Exception {
		dao.updateColumn(o);
	}

	@Override
	public Order getString(String s) throws Exception {
		return (Order) dao.selectString(s);
	}

	@Override
	public Order getInt(Integer i) throws Exception {
		return (Order) dao.selectInt(i);
	}

	@Override
	public Order getDouble(Double d) throws Exception {
		return (Order) dao.selectDouble(d);
	}

	@Override
	public ArrayList<Order> getArString(String s) throws Exception {
		return dao.selectArString(s);
	}

	@Override
	public ArrayList<Order> getArInt(Integer i) throws Exception {
		return dao.selectArInt(i);
	}

	@Override
	public ArrayList<Order> getArDouble(Double d) throws Exception {
		return dao.selectArDouble(d);
	}

	@Override
	public ArrayList<Order> getall() throws Exception {
		return dao.selectall();
	}


}

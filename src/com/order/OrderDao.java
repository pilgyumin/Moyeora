package com.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.CrudDao;
import com.mapper.OrderMapper;
import com.vo.Order;
import com.vo.Updatevo;

@Repository("orderdao")
public class OrderDao implements CrudDao<String, Integer, Double, Order,Updatevo>{
	
	@Autowired
	OrderMapper om;

	@Override
	public void insert(Order o) {
		om.insert(o);
	}

	@Override
	public void deleteString(String s) {
		om.deleteString(s);
	}

	@Override
	public void deleteInt(Integer i) {
		om.deleteInt(i);
	}

	@Override
	public void deleteDouble(Double d) {
		om.deleteDouble(d);
	}

	@Override
	public void update(Order o) {
		om.update(o);
	}

	@Override
	public Order selectString(String s) {
		return (Order) om.selectString(s);
	}

	@Override
	public Order selectInt(Integer i) {
		return (Order) om.selectInt(i);
	}

	@Override
	public Order selectDouble(Double d) {
		return (Order) om.selectDouble(d);
	}

	@Override
	public ArrayList<Order> selectArString(String s) {
		return om.selectArString(s);
	}

	@Override
	public ArrayList<Order> selectArInt(Integer i) {
		return om.selectArInt(i);
	}

	@Override
	public ArrayList<Order> selectArDouble(Double d) {
		return om.selectArDouble(d);
	}

	@Override
	public ArrayList<Order> selectall() {
		return om.selectall();
	}

	@Override
	public void updateColumn(Updatevo o) {
		// TODO Auto-generated method stub
		
	}

}

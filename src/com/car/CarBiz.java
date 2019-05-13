package com.car;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.CrudBiz;
import com.frame.CrudDao;
import com.vo.Car;
import com.vo.Updatevo;

@Service("carbiz")
public class CarBiz implements CrudBiz<String, Integer, Double, Car, Updatevo> {
	
	@Resource(name="cardao")
	CrudDao<String, Integer, Double, Car, Updatevo> dao;

	@Override
	public void register(Car o) throws Exception {
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
	public void modify(Car o) throws Exception {
		dao.update(o);
	}
	
	@Override
	public void modifyColumn(Updatevo o) throws Exception {
		dao.updateColumn(o);
	}

	@Override
	public Car getString(String s) throws Exception {
		return (Car) dao.selectString(s);
	}

	@Override
	public Car getInt(Integer i) throws Exception {
		return (Car) dao.selectInt(i);
	}

	@Override
	public Car getDouble(Double d) throws Exception {
		return (Car) dao.selectDouble(d);
	}

	@Override
	public ArrayList<Car> getArString(String s) throws Exception {
		return dao.selectArString(s);
	}

	@Override
	public ArrayList<Car> getArInt(Integer i) throws Exception {
		return dao.selectArInt(i);
	}

	@Override
	public ArrayList<Car> getArDouble(Double d) throws Exception {
		return dao.selectArDouble(d);
	}

	@Override
	public ArrayList<Car> getall() throws Exception {
		return dao.selectall();
	}
	
}

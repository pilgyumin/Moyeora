package com.car;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.CrudDao;
import com.mapper.CarMapper;
import com.vo.Car;
import com.vo.Updatevo;

@Repository("cardao")
public class CarDao implements CrudDao<String, Integer, Double, Car,Updatevo> {
	
	@Autowired
	CarMapper cm;

	@Override
	public void insert(Car o) {
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
	public void update(Car o) {
		cm.update(o);
	}
	
	@Override
	public void updateColumn(Updatevo o) {
		cm.updateColumn(o);
	}

	@Override
	public Car selectString(String s) {
		return (Car) cm.selectString(s);
	}

	@Override
	public Car selectInt(Integer i) {
		return (Car) cm.selectInt(i);
	}

	@Override
	public Car selectDouble(Double d) {
		return (Car) cm.selectDouble(d);
	}

	@Override
	public ArrayList<Car> selectArString(String s) {
		return cm.selectArString(s);
	}

	@Override
	public ArrayList<Car> selectArInt(Integer i) {
		return cm.selectArInt(i);
	}

	@Override
	public ArrayList<Car> selectArDouble(Double d) {
		return cm.selectArDouble(d);
	}

	@Override
	public ArrayList<Car> selectall() {
		return cm.selectall();
	}

}

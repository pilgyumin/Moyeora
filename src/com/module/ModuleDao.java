package com.module;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.CrudDao;
import com.mapper.CarMapper;
import com.mapper.ModuleMapper;
import com.vo.Car;
import com.vo.Module;
import com.vo.Updatevo;

@Repository("moduledao")
public class ModuleDao implements CrudDao<String, Integer, Double, Module,Updatevo> {
	
	@Autowired
	ModuleMapper cm;

	@Override
	public void insert(Module o) {
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
	public void update(Module o) {
		cm.update(o);
	}
	
	@Override
	public void updateColumn(Updatevo o) {
		cm.updateColumn(o);
	}

	@Override
	public Module selectString(String s) {
		return (Module) cm.selectString(s);
	}

	@Override
	public Module selectInt(Integer i) {
		return (Module) cm.selectInt(i);
	}

	@Override
	public Module selectDouble(Double d) {
		return (Module) cm.selectDouble(d);
	}

	@Override
	public ArrayList<Module> selectArString(String s) {
		return cm.selectArString(s);
	}

	@Override
	public ArrayList<Module> selectArInt(Integer i) {
		return cm.selectArInt(i);
	}

	@Override
	public ArrayList<Module> selectArDouble(Double d) {
		return cm.selectArDouble(d);
	}

	@Override
	public ArrayList<Module> selectall() {
		return cm.selectall();
	}

}

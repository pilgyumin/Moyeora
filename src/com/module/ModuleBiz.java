package com.module;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.CrudBiz;
import com.frame.CrudDao;
import com.vo.Car;
import com.vo.Module;
import com.vo.Updatevo;

@Service("modulebiz")
public class ModuleBiz implements CrudBiz<String, Integer, Double, Module, Updatevo> {

	@Resource(name="moduledao")
	CrudDao<String, Integer, Double, Module, Updatevo> dao;
	
	@Override
	public void register(Module o) throws Exception {
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
	public void modify(Module o) throws Exception {
		dao.update(o);
	}
	
	@Override
	public void modifyColumn(Updatevo o) throws Exception {
		dao.updateColumn(o);
	}

	@Override
	public Module getString(String s) throws Exception {
		return (Module) dao.selectString(s);
	}

	@Override
	public Module getInt(Integer i) throws Exception {
		return (Module) dao.selectInt(i);
	}

	@Override
	public Module getDouble(Double d) throws Exception {
		return (Module) dao.selectDouble(d);
	}

	@Override
	public ArrayList<Module> getArString(String s) throws Exception {
		return dao.selectArString(s);
	}

	@Override
	public ArrayList<Module> getArInt(Integer i) throws Exception {
		return dao.selectArInt(i);
	}

	@Override
	public ArrayList<Module> getArDouble(Double d) throws Exception {
		return dao.selectArDouble(d);
	}

	@Override
	public ArrayList<Module> getall() throws Exception {
		return dao.selectall();
	}

	
}

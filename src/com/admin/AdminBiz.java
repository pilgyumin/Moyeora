package com.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.CrudBiz;
import com.frame.CrudDao;
import com.vo.Admin;
import com.vo.Updatevo;

@Service("adminbiz")
public class AdminBiz implements CrudBiz<String, Integer, Double, Admin, Updatevo> {
	
	@Resource(name="admindao")
	CrudDao<String, Integer, Double, Admin, Updatevo> dao;

	@Override
	public void register(Admin o) throws Exception {
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
	public void modify(Admin o) throws Exception {
		dao.update(o);
	}
	
	@Override
	public void modifyColumn(Updatevo o) throws Exception {
		dao.updateColumn(o);
	}

	@Override
	public Admin getString(String s) throws Exception {
		return (Admin) dao.selectString(s);
	}

	@Override
	public Admin getInt(Integer i) throws Exception {
		return (Admin) dao.selectInt(i);
	}

	@Override
	public Admin getDouble(Double d) throws Exception {
		return (Admin) dao.selectDouble(d);
	}

	@Override
	public ArrayList<Admin> getArString(String s) throws Exception {
		return dao.selectArString(s);
	}

	@Override
	public ArrayList<Admin> getArInt(Integer i) throws Exception {
		return dao.selectArInt(i);
	}

	@Override
	public ArrayList<Admin> getArDouble(Double d) throws Exception {
		return dao.selectArDouble(d);
	}

	@Override
	public ArrayList<Admin> getall() throws Exception {
		return dao.selectall();
	}

}

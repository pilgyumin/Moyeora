package com.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.CrudDao;
import com.mapper.AdminMapper;
import com.vo.Admin;
import com.vo.Updatevo;

@Repository("admindao")
public class AdminDao implements CrudDao<String, Integer, Double, Admin,Updatevo> {

	@Autowired
	AdminMapper am;
	
	@Override
	public void insert(Admin o) {
		am.insert(o);
	}

	@Override
	public void deleteString(String s) {
		am.deleteString(s);
	}

	@Override
	public void deleteInt(Integer i) {
		am.deleteInt(i);
	}

	@Override
	public void deleteDouble(Double d) {
		am.deleteDouble(d);
	}

	@Override
	public void update(Admin o) {
		am.update(o);
	}
	
	@Override
	public void updateColumn(Updatevo o) {
		am.updateColumn(o);
	}

	@Override
	public Admin selectString(String s) {
		return (Admin) am.selectString(s);
	}

	@Override
	public Admin selectInt(Integer i) {
		return (Admin) am.selectInt(i);
	}

	@Override
	public Admin selectDouble(Double d) {
		return (Admin) am.selectDouble(d);
	}

	@Override
	public ArrayList<Admin> selectArString(String s) {
		return am.selectArString(s);
	}

	@Override
	public ArrayList<Admin> selectArInt(Integer i) {
		return am.selectArInt(i);
	}

	@Override
	public ArrayList<Admin> selectArDouble(Double d) {
		return am.selectArDouble(d);
	}

	@Override
	public ArrayList<Admin> selectall() {
		return am.selectall();
	}

}

package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.BasicDao;
import com.mm.cs.entities.Basic;

public class BasicService 
{
	private BasicDao basicDao;

	public void setBasicDao(BasicDao basicDao) {
		this.basicDao = basicDao;
	}
	
	//获取基础信息
	public Basic get(Integer basic_Id)
	{
		return basicDao.get(basic_Id);
	}
	//input
	public List<Basic> input(Integer id)
	{
		List<Basic> basics = basicDao.input(id);
		return basics;
	}
	//getAll
	public List<Basic> getAll(Integer id)
	{
		List<Basic> basics = basicDao.getAll(id);
		return basics;
	}
	//保存
	public void saveOrUpdate(Basic basic)
	{
		basicDao.saveOrUpdate(basic);
	}
}

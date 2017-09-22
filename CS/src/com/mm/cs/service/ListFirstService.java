package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.ListFirstDao;
import com.mm.cs.entities.ListFirst;

public class ListFirstService 
{
	private ListFirstDao listFirstDao;

	public void setListFirstDao(ListFirstDao listFirstDao) {
		this.listFirstDao = listFirstDao;
	}
	
	//显示listFirst信息
	public List<ListFirst> getAll()
	{
		return listFirstDao.getAll();
	}
	//三级显示ListSecond信息
	public List<ListFirst> getSecondList(String ListFirstId)
	{
		return listFirstDao.getSecondList(ListFirstId);
	}
	public List<ListFirst> getListFirst(String ListFirstId)
	{
		return listFirstDao.getListFirst(ListFirstId);
	}
}

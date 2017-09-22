package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.ListSecondDao;
import com.mm.cs.entities.ListSecond;

public class ListSecondService 
{
	private ListSecondDao listSecondDao;
	
	public void setListSecondDao(ListSecondDao listSecondDao)
	{
		this.listSecondDao = listSecondDao;
	}
	//����ʾListThird
	public List<ListSecond> getThirdList(String ListSecondId)
	{
		return listSecondDao.getThirdList(ListSecondId);
	}
	public List<ListSecond> getListSecond(String ListSecondId)
	{
		return listSecondDao.getListSecond(ListSecondId);
	}
	public List<ListSecond> getAll()
	{
		return listSecondDao.getAll();
	}
}

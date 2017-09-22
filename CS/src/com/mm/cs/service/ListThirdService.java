package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.ListThirdDao;
import com.mm.cs.entities.ListThird;

public class ListThirdService 
{
	private ListThirdDao listThirdDao;
	public void setListThirdDao(ListThirdDao listThirdDao) {
		this.listThirdDao = listThirdDao;
	}
	public List<ListThird> getListThird(String ListThirdId)
	{
		return listThirdDao.getListThird(ListThirdId);
	}

	public List<ListThird> getAll() {

		return listThirdDao.getAll();
	}
}

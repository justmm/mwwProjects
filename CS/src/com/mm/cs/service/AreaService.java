package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.AreaDao;
import com.mm.cs.entities.Area;

public class AreaService 
{
	private AreaDao areaDao;

	public void setAreaDao(AreaDao areaDao) 
	{
		this.areaDao = areaDao;
	}
	
	public List<Area> getAll()
	{
		return areaDao.getAll();
	}
}

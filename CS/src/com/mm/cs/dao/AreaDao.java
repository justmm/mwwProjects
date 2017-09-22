package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.Area;


public class AreaDao extends BaseDao
{

	public List<Area> getAll()
	{
		String hql="from Area";
		return getSession().createQuery(hql).list();
	}
}

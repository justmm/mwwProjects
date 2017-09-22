package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.Basic;

public class BasicDao extends BaseDao
{
	//id
	public Basic get(Integer basic_Id)
	{
		return (Basic) getSession().get(Basic.class, basic_Id);
	}
	//input
	public List<Basic> input(Integer id)
	{
		String hql="from Basic b LEFT OUTER JOIN fetch b.user where b.user.id = ? ";
		return getSession().createQuery(hql).setInteger(0, id).list();
	}
	//
	public List<Basic> getAll(Integer id)
	{
		String hql="from Basic b left outer join fetch b.department left outer join fetch b.area left outer join fetch b.user where b.user.id = ? ";
		return getSession().createQuery(hql).setInteger(0, id).list();
	}
	
	//
	public void saveOrUpdate(Basic basic)
	{
		getSession().saveOrUpdate(basic);
	}
}

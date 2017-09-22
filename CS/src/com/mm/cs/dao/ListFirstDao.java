package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.ListFirst;

public class ListFirstDao extends BaseDao 
{
	//��ʾListFirst
	public List<ListFirst> getAll()
	{
		String hql = "from ListFirst";
		return getSession().createQuery(hql).list();
	}
	//��ʾListSecond��Ϣ
	public List<ListFirst> getSecondList(String ListFirstId)
	{
		String hql = "from ListSecond s where s.ListSecondId like '"+ListFirstId+"%'";
		return getSession().createQuery(hql).list();
	}
	
	public List<ListFirst> getListFirst(String ListFirstId)
	{
		String hql="from ListFirst f where f.ListFirstId = ? ";
		return getSession().createQuery(hql).setString(0, ListFirstId).list();
	}
}

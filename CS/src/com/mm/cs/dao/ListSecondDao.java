package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.ListSecond;

public class ListSecondDao extends BaseDao 
{
	//����ʾListThird
	public List<ListSecond> getThirdList(String ListSecondId)
	{
		String hql = "from ListThird t where t.ListThirdId like '"+ListSecondId+"%'" ;
		return getSession().createQuery(hql).list();
	}
	
	public List<ListSecond> getListSecond(String ListSecondId)
	{
		String hql="from ListSecond s where s.ListSecondId= ?";
		return getSession().createQuery(hql).setString(0, ListSecondId).list();
	}
	
	public List<ListSecond> getAll()
	{
		String hql ="from ListSecond";
		return getSession().createQuery(hql).list();
	}
}

package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.ListThird;

public class ListThirdDao extends BaseDao 
{
	public List<ListThird> getListThird(String ListThirdId)
	{
		String hql="from ListThird t where t.ListThirdId = ?";
		return getSession().createQuery(hql).setString(0, ListThirdId).list();
	}

	public List<ListThird> getAll() {

		String hql = "from ListThird";
		return getSession().createQuery(hql).list();
	}
}

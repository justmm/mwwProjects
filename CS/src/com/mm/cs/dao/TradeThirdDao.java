package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.TradeThird;

public class TradeThirdDao extends BaseDao 
{
	public List<TradeThird> getTradeThird(String TradeThirdId)
	{
		String hql = "from TradeThird t where t.TradeThirdId= ?";
		return getSession().createQuery(hql).setString(0, TradeThirdId).list();
	}
	public List<TradeThird> getAll(){
		
		String hql = "from TradeThird";
		return getSession().createQuery(hql).list();
	}
}

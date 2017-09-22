package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.TradeFirst;

public class TradeFirstDao extends BaseDao 
{
	//显示TradeFirst
	public List<TradeFirst> getAll(){
		String hql = "from TradeFirst";
		return getSession().createQuery(hql).list();
	}
	
	//三级联动显示TradeSecond信息
	public List<TradeFirst> getSecondTrade(String TradeFirstId){
		
		String hql = "from TradeSecond s where s.TradeSecondId like '"+TradeFirstId+"%' ";
		return getSession().createQuery(hql).list();
	}
	
	public List<TradeFirst> getTradeFirst(String TradeFirstId)
	{
		String hql="from TradeFirst f where f.TradeFirstId= ?";
		return getSession().createQuery(hql).setString(0, TradeFirstId).list();
	}
}

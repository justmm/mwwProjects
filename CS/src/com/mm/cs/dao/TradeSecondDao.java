package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.TradeSecond;

public class TradeSecondDao extends BaseDao 
{
	//��������ʾTradeThird��Ϣ
	public List<TradeSecond> getThirdTrade(String TradeSecondId)
	{
		
		String hql = "from TradeThird t where t.TradeThirdId like '"+TradeSecondId+"%' ";
		return getSession().createQuery(hql).list();
	}
	
	public List<TradeSecond> getTradeSecond(String TradeSecondId)
	{
		String hql="from TradeSecond s where s.TradeSecondId = ?";
		return getSession().createQuery(hql).setString(0, TradeSecondId).list();
	}

	public List<TradeSecond> getAll() {

		String hql = "from TradeSecond";
		return getSession().createQuery(hql).list();
	}
}

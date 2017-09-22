package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.TradeFirstDao;
import com.mm.cs.entities.TradeFirst;

public class TradeFirstService 
{
	private TradeFirstDao tradeFirstDao;

	public void setTradeFirstDao(TradeFirstDao tradeFirstDao) {
		this.tradeFirstDao = tradeFirstDao;
	}
	//显示tradeFirst信息
	public List<TradeFirst> getAll()
	{
		return tradeFirstDao.getAll();
	}
	
	//显示TradeSecond信息
	public List<TradeFirst> getSecondTrade (String TradeFirstId)
	{
		return tradeFirstDao.getSecondTrade(TradeFirstId);
	}
	public List<TradeFirst> getTradeFirst(String TradeFirstId)
	{
		return tradeFirstDao.getTradeFirst(TradeFirstId);
	}
}

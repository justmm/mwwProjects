package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.TradeFirstDao;
import com.mm.cs.dao.TradeSecondDao;
import com.mm.cs.entities.TradeFirst;
import com.mm.cs.entities.TradeSecond;

public class TradeSecondService
{
	private TradeSecondDao tradeSecondDao;
	
	public void setTradeSecondDao(TradeSecondDao tradeSecondDao) {
		this.tradeSecondDao = tradeSecondDao;
	}
	//����ʾTradeThird
	public List<TradeSecond> getThirdTrade(String TradeSecondId)
	{
		return tradeSecondDao.getThirdTrade(TradeSecondId);
	}
	
	public List<TradeSecond> getTradeSecond(String TradeSecondId)
	{
		return tradeSecondDao.getTradeSecond(TradeSecondId);
	}

	public List<TradeSecond> getAll() {

		return tradeSecondDao.getAll();
	}
}

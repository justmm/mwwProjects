package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.TradeThirdDao;
import com.mm.cs.entities.TradeThird;

public class TradeThirdService {
	private TradeThirdDao tradeThirdDao;

	public void setTradeThirdDao(TradeThirdDao tradeThirdDao) {
		this.tradeThirdDao = tradeThirdDao;
	}

	public List<TradeThird> getTradeThird(String TradeThirdId) {
		return tradeThirdDao.getTradeThird(TradeThirdId);
	}

	public List<TradeThird> getAll() {

		return tradeThirdDao.getAll();
	}
}

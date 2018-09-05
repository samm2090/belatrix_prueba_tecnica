package io.moneyxchange.smuroy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.moneyxchange.smuroy.dao.CurrencyExchangeDAO;
import io.moneyxchange.smuroy.model.CurrencyExchangeBean;

@Service
public class CurrencyExchangeService {

	@Autowired
	CurrencyExchangeDAO currencyExchangeDAO;

	public double exchangeCurrency(double amount, int idCurrencyIn, int idCurrencyOut) {
		double exchangedAmount = 0;
		CurrencyExchangeBean currencyExchange = currencyExchangeDAO.getCurrecyExchange(idCurrencyIn, idCurrencyOut);
		
		exchangedAmount = currencyExchange.getValue() * amount;

		return exchangedAmount;
	}

}

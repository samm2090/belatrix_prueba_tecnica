package io.moneyxchange.smuroy.dao;

import io.moneyxchange.smuroy.model.CurrencyExchangeBean;

/**
 * DAO that interacts mainly with the table currency_exchange
 * @author SERGIO MUROY
 *
 */
public interface CurrencyExchangeDAO {

	/**
	 * 
	 * @param idCurrencyIn currency to exchange
	 * @param idCurrencyOut currency to be exchanged
	 * @return relation between two currencies
	 */
	public CurrencyExchangeBean getCurrecyExchange(int idCurrencyIn, int idCurrencyOut);

}

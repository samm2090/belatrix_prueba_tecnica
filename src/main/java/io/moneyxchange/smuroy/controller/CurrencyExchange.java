package io.moneyxchange.smuroy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.moneyxchange.smuroy.service.CurrencyExchangeService;

/**
 * Controller class that exposes Restful web services for exchanging currencies
 * 
 * @author SERGIO MUROY
 *
 */
@RestController
@RequestMapping("currencyExchange")
public class CurrencyExchange {

	@Autowired
	CurrencyExchangeService currencyExchangeService;

	/**
	 * 
	 * @param amount
	 *            quantity of money
	 * @param idCurrencyIn
	 * @param idCurrencyOut
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "exchangeCurrency", method = RequestMethod.GET)
	@ResponseBody
	public double exchangeCurrency(@RequestParam double amount, @RequestParam int idCurrencyIn,
			@RequestParam int idCurrencyOut) {
		double amountExchanged = 0;

		amountExchanged = currencyExchangeService.exchangeCurrency(amount, idCurrencyIn, idCurrencyOut);

		return amountExchanged;
	}

}

package io.moneyxchange.smuroy.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.moneyxchange.smuroy.service.CurrencyExchangeService;
import io.moneyxchange.smuroy.util.CurrencyConstants;

/**
 * Class for testing services
 * 
 * @author SERGIO MUROY
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class ServicesTest {

	@Autowired
	CurrencyExchangeService currencyExchangeService;

	@Test
	public void exchangeCurrency() {

		double amount = 100.50;
		int idCurrencyIn = CurrencyConstants.USD;
		int idCurrencyOut = CurrencyConstants.EUR;

		double exchangedCurrency = currencyExchangeService.exchangeCurrency(amount, idCurrencyIn, idCurrencyOut);

		System.out.println(exchangedCurrency);
		Assert.assertNotEquals(0.0, exchangedCurrency);
	}

}

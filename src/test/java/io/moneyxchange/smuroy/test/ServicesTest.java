package io.moneyxchange.smuroy.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.moneyxchange.smuroy.service.AuthenticationService;
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

	@Autowired
	AuthenticationService authenticationService;

	@Test
	public void exchangeCurrency() {
		double amount = 100.50;
		int idCurrencyIn = CurrencyConstants.USD;
		int idCurrencyOut = CurrencyConstants.EUR;

		double exchangedCurrency = currencyExchangeService.exchangeCurrency(amount, idCurrencyIn, idCurrencyOut);

		System.out.println("El cambio a euros es: " + exchangedCurrency);
		Assert.assertNotEquals(0.0, exchangedCurrency);
	}

	@Test
	public void loginTest() {
		String username = "admin";
		String password = "123456";

		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);

		Assert.assertTrue(authenticationService.validateCredentials(params));
	}

}

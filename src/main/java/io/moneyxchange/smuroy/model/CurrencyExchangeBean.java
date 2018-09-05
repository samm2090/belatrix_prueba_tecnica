package io.moneyxchange.smuroy.model;

import java.io.Serializable;

/**
 * Java Bean that represents the relation between two currencies and their
 * value.
 * 
 * @author SERGIO MUROY
 *
 */
public class CurrencyExchangeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idCurrencyIn; // currency to exchange
	private int idCurrencyOut; // currency to be exchanged
	private double value; // value for exchanging 1 unit of the currency e.g. 1 dollar is equivalent to 0.8624 euro
	private String currencyInName;
	private String currencyOutName;
	private String currencyInCode;
	private String currencyOutCode;
	private String currencyInSymbol;
	private String currencyOutSymbol;

	public int getIdCurrencyIn() {
		return idCurrencyIn;
	}

	public void setIdCurrencyIn(int idCurrencyIn) {
		this.idCurrencyIn = idCurrencyIn;
	}

	public int getIdCurrencyOut() {
		return idCurrencyOut;
	}

	public void setIdCurrencyOut(int idCurrencyOut) {
		this.idCurrencyOut = idCurrencyOut;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrencyInName() {
		return currencyInName;
	}

	public void setCurrencyInName(String currencyInName) {
		this.currencyInName = currencyInName;
	}

	public String getCurrencyOutName() {
		return currencyOutName;
	}

	public void setCurrencyOutName(String currencyOutName) {
		this.currencyOutName = currencyOutName;
	}

	public String getCurrencyInCode() {
		return currencyInCode;
	}

	public void setCurrencyInCode(String currencyInCode) {
		this.currencyInCode = currencyInCode;
	}

	public String getCurrencyOutCode() {
		return currencyOutCode;
	}

	public void setCurrencyOutCode(String currencyOutCode) {
		this.currencyOutCode = currencyOutCode;
	}

	public String getCurrencyInSymbol() {
		return currencyInSymbol;
	}

	public void setCurrencyInSymbol(String currencyInSymbol) {
		this.currencyInSymbol = currencyInSymbol;
	}

	public String getCurrencyOutSymbol() {
		return currencyOutSymbol;
	}

	public void setCurrencyOutSymbol(String currencyOutSymbol) {
		this.currencyOutSymbol = currencyOutSymbol;
	}

}

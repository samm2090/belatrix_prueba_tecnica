package io.moneyxchange.smuroy.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.moneyxchange.smuroy.dao.CurrencyExchangeDAO;
import io.moneyxchange.smuroy.model.CurrencyExchangeBean;

/**
 * Interacts with the table currency_exchange
 * @author SERGIO MUROY
 *
 */
@Repository
public class CurrecyExchangeDAOImpl implements CurrencyExchangeDAO{

	@Autowired
	DataSource dataSource;
	
	@Override
	public CurrencyExchangeBean getCurrecyExchange(int idCurrencyIn, int idCurrencyOut) {
		String query = "SELECT * FROM currency_exchange WHERE id_currency_in = ? AND  id_currency_out = ?";
		
		Connection connection = null;
		CurrencyExchangeBean currencyExchange = null;
		
		try {
			connection = dataSource.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, idCurrencyIn);
			ps.setInt(2, idCurrencyOut);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				currencyExchange =  new CurrencyExchangeBean();
				currencyExchange.setValue(rs.getDouble("value"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return currencyExchange;
	}

}

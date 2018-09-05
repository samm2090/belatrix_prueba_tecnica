package io.moneyxchange.smuroy.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.moneyxchange.smuroy.dao.UserDAO;
import io.moneyxchange.smuroy.model.User;

/**
 * 
 * @author SERGIO MUROY
 *
 */
@Service
public class AuthenticationService {
	
	@Autowired
	UserDAO userDAO;

	public boolean validateCredentials(Map<String, String> params) {
		boolean result = false;
		User user = new User();
		user.setUsername(params.get("username"));
		user.setPassword(params.get("password"));
		
		User searchedUser = userDAO.getUser(user);
		
		if(null != searchedUser){
			result = true;
		}
		
		return result;
	}
	

}

package io.moneyxchange.smuroy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.moneyxchange.smuroy.service.AuthenticationService;

/**
 * 
 * @author SERGIO MUROY
 *
 */
@Controller
@RequestMapping("authentication")
public class Authentication {

	@Autowired
	AuthenticationService authenticationService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public boolean validateCredentials(@RequestBody Map<String, String> params) {
		boolean result = false;
		
		result = authenticationService.validateCredentials(params);
		
		return result;
	}
}

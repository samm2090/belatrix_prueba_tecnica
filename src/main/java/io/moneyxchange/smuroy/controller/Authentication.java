package io.moneyxchange.smuroy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@CrossOrigin
	@RequestMapping(value = "validate", method = RequestMethod.POST)
	@ResponseBody
	public boolean validateCredentials(@RequestBody Map<String, String> params) {
		boolean result = false;
		
		result = authenticationService.validateCredentials(params);
		
		return result;
	}
}

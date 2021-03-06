package com.seostella.springsecuritylogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SigninController {
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
		return "user/signin";
	}
	
	@RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
	public String signinFailure() {
		return "user/signin_failure";
	}
	
}

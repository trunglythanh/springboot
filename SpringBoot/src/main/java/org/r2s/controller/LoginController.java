package org.r2s.controller;

import org.r2s.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/")
	public String gotoLogin() {		
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password) {
		boolean loginRespone = securityService.login(username, password);
		if (loginRespone) {
			return "redirect:index";
		}
		return "login";
	}
}

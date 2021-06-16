package com.dh.narihair.controller;

import com.dh.narihair.domain.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority(Role.ROLE_LOGIN.getValue()))) {
			return "redirect:/main";
		}else {
			return "login";
		}
	}
}

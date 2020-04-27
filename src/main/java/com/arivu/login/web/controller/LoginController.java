package com.arivu.login.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arivu.login.constant.LoginApplicationConstants;
import com.arivu.login.model.UserProfile;
import com.arivu.login.service.IUserProfileService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserProfileService userProfileService;
	
	@GetMapping(value = { LoginApplicationConstants.SLASH, LoginApplicationConstants.LOGIN_PATH })
	public String showLoginPage() {
		return LoginApplicationConstants.LOGIN;
	}

/*	// Login form with error
	@GetMapping("/error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "error";
	}
	*/
	@GetMapping(value = "/home")
	public String home(Model model) {
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();		
		logger.info("loggedInUser {}", authentication.getName());
		UserProfile userProfile = userProfileService.findByUserName(authentication.getName());
		model.addAttribute("currentUser", authentication.getName());
		model.addAttribute("userProfile", userProfile);
		//model.addAttribute("authorities", authentication.getAuthorities());
		return "home";
	}
	@GetMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
}

package com.arivu.login.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arivu.login.constant.LoginApplicationConstants;
import com.arivu.login.dto.UserRegistrationDTO;
import com.arivu.login.model.User;
import com.arivu.login.model.UserProfile;
import com.arivu.login.service.IUserProfileService;
import com.arivu.login.service.IUserService;

@Controller
public class RegistrationController {

	//private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserProfileService userProfileService;
	
	@GetMapping(LoginApplicationConstants.REGISTRATION_PATH)
	public String showRegistrationPage(Model model) {
		model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
		return LoginApplicationConstants.REGISTRATION;
	}
	
	@PostMapping(LoginApplicationConstants.REGISTRATION_PATH)
	public String performRegistration(Model model, UserRegistrationDTO userRegistrationDTO) {
		String password = bCryptPasswordEncoder.encode(userRegistrationDTO.getPassword());
		User user = new User();
		user.setUserName(userRegistrationDTO.getUserName());
		user.setPassword(password);
		user = userService.create(user);
		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName(userRegistrationDTO.getFirstName());
		userProfile.setLastName(userRegistrationDTO.getLastName());
		userProfile.setEmail(userRegistrationDTO.getEmail());
		userProfile.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
		userProfile.setUser(user);
		userProfileService.create(userProfile);
		return LoginApplicationConstants.LOGIN;
	}
}

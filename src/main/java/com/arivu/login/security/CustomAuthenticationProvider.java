package com.arivu.login.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.arivu.login.model.Role;
import com.arivu.login.model.User;
import com.arivu.login.service.IUserRoleService;
import com.arivu.login.service.IUserService;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleService userRoleService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        if(!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
        	  throw new BadCredentialsException("Credentials Mismatch!..");
        }
        logger.info("User Name - {}", user.getUserName());
        List<Role> roles = userRoleService.findRolesByUserId(user.getId());
		Set<GrantedAuthority> authorities = getAuthorities(roles);
		Authentication auth = new UsernamePasswordAuthenticationToken(userName, null, authorities);
		return auth;
        
	}
	
	private Set<GrantedAuthority> getAuthorities(List<Role> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if(userRoles != null) {
	        userRoles.stream().forEach(role -> {
	        	 authorities.add( new SimpleGrantedAuthority(role.getName()));
	        });
        }
        return authorities;

    }
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	

}

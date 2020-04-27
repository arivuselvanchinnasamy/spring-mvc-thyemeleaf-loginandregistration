package com.arivu.login.security;

import java.math.BigInteger;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.arivu.login.model.User;

public class LoggedInUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1295519640073734827L;
	
	private final User user;
	
	private final List<GrantedAuthority> authorities;
	
	public LoggedInUserDetails(User user, List<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}
	
    public BigInteger getId() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUserDetails() {
        return user;
    }

	/**
	 * @return the authorities
	 */
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}
}

package com.app.iami.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails{
	
	private String username;
	private String password;

	public CustomUserDetails(User byUserName) {
		// TODO Auto-generated constructor stub
		this.username=byUserName.getName();
		this.password=byUserName.getPassword();
		
		List<GrantedAuthority>  auth=new ArrayList<>();
		byUserName.getRole().forEach( r -> auth.add(new SimpleGrantedAuthority(r)));
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}

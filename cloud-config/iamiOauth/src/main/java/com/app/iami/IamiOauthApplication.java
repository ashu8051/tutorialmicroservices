package com.app.iami;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.app.iami.config.CustomUserDetails;

@SpringBootApplication
public class IamiOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamiOauthApplication.class, args);
	}

	@Autowired
	public void getAuthenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		authenticationManagerBuilder.userDetailsService(new UserDetailsService() {
			User user=new User();
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				user.setName(username);
				user.setPassword("pass");
				List<String>  roleList=new ArrayList<String>();
				roleList.add("ROLE_TRUSTED_CLIENT");
				user.setRole(roleList);
				return new CustomUserDetails(user);
			}
		});
	}
}

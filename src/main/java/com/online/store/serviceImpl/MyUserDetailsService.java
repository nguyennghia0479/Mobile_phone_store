package com.online.store.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.online.store.model.AccountInfo;
import com.online.store.service.AccountService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountInfo account = this.accountService.findByUsername(username);
		if(account != null) {
			List<String> roles = this.accountService.getAccountRoles(username);
			List<GrantedAuthority> authorities = new ArrayList<>();
			if(!roles.isEmpty()) {
				for(String role : roles) {
					GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
					authorities.add(authority);
				}
			}
			UserDetails user = new User(account.getUsername(), account.getPassword(), authorities);
			return user;
		} else {
			throw new UsernameNotFoundException("");
		}
	}
}

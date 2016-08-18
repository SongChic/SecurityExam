package com.MyClassDB.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {
	
	@Override
	public Users loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		System.out.println( userName );
		
		Users user = new Users();
		user.setUsername(userName);
        user.setPassword("aaa");
        
        Role role = new Role();
        role.setName("ROLE_USER");

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        user.setAuthorities(roles);
        
		return user;
	}

}

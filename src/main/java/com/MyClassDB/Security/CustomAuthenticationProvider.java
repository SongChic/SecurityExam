package com.MyClassDB.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider { 
    
	@Autowired
	private PasswordEncoder passwrdEncoder;
	
	@Autowired
    private SaltSource saltSource;
	
	@Autowired
	LoginService loginService;
     
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
  
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
         
        String user_id = (String)authentication.getPrincipal();    
        String user_pw = (String)authentication.getCredentials();
        
        Users user;
        
//        System.out.println( user_id );
        
        user = loginService.loadUserByUsername(user_id);
        
        String password = passwrdEncoder.encodePassword(user_pw, saltSource.getSalt(user));
        
        System.out.println( password );
        
         
         
        if(user_id.equals("test")&&user_pw.equals("test")){
            List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
             
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
//            result.setDetails(new Users(user_id, user_pw));
            return result;         
        }else{
            throw new BadCredentialsException("Bad credentials");
        }
    }
}
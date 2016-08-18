package com.MyClassDB.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.MyClassDB.Security.Users;


@Controller
public class UserController {
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public ModelAndView login(HttpSession session) {
		 	ModelAndView mav = new ModelAndView("/login");
		 	
		 	System.out.println( "pass" );
		 	return mav;
	    }
	     
	    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public void logout(HttpSession session) {
	    	Users userDetails = (Users)session.getAttribute("userLoginInfo");
	         
	        session.invalidate();
	    }
	     
	    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	    public void login_success(HttpSession session) {
	    	Users userDetails = (Users)SecurityContextHolder.getContext().getAuthentication().getDetails();
	        session.setAttribute("userLoginInfo", userDetails);
	    }
	     
	    @RequestMapping(value = "/page1", method = RequestMethod.GET)
	    public void page1() {      
	    }
	     
	    @RequestMapping(value = "/login_duplicate", method = RequestMethod.GET)
	    public void login_duplicate() {    
	    }

}

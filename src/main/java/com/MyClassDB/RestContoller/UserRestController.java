package com.MyClassDB.RestContoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

@Controller
public class UserRestController {

	@RequestMapping( value="/rest/dbTest" )
	@ResponseBody
	public ResponseEntity<JSONArray> test (
			@RequestParam(value="userId", required=false) String userId
			) {
		System.out.println( "DB Attack" );
		System.out.println( userId );
		
		return new ResponseEntity<JSONArray>(HttpStatus.OK);
	}
	
}

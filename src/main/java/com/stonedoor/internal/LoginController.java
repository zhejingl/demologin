package com.stonedoor.internal;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stonedoor.internal.datamodel.LoginData;
import com.stonedoor.internal.datamodel.LoginReturn;

import org.springframework.http.MediaType;
import com.auth0.jwt.algorithms.Algorithm;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class LoginController {
	
	private String SECRET = "SDGDemoLogin";
	@RequestMapping(value="/v1/api/demo/social/login", method=RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<LoginReturn> login(@RequestBody LoginData login) throws Exception {
		String token = JWT.create().withSubject(login.getUser())
				.withExpiresAt(new Date(System.currentTimeMillis()+1000000))
				.sign(Algorithm.HMAC512(SECRET.getBytes()));
		System.out.println("return token:"+  token);
		LoginReturn ret = new LoginReturn();
		ret.setToken(token);
		return new ResponseEntity<LoginReturn>(ret, HttpStatus.OK);

	}

}

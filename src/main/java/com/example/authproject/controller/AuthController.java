package com.example.authproject.controller;

import org.springframework.web.bind.annotation.*;

import com.example.authproject.dto.LoginRequest;
import com.example.authproject.entity.User;
import com.example.authproject.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
	private final AuthService authservice;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		return authservice.register(user);
		
		
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return authservice.login(loginRequest.getEmail(), loginRequest.getPassword());
	}


}

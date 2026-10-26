package com.example.authproject.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authproject.entity.Role;
import com.example.authproject.entity.User;
import com.example.authproject.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public String register(User user) {
		userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
			throw new RuntimeException("user already exist");
		});
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getRole().name().equals("USER")){
            user.setRole(Role.USER);
        }else{
            user.setRole(Role.ADMIN);
        }

		userRepository.save(user);

		return "user Regestered successfully";

	}

	public String login(String email, String password) {
		User user = userRepository.findByEmail(email).orElseThrow(()->{throw new RuntimeException("user not found");});
		if(!passwordEncoder.matches(password, user.getPassword())) {
			throw new RuntimeException("invalid credentials");
		}
		return jwtUtil.generateToken(user.getEmail(),user.getRole().name());

	}

}

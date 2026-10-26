package com.example.authproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgramRestController {
    @GetMapping("/greet")
    public String greeting(){
        return "Hello!!";
    }
    @GetMapping("/admin/greet")
    public String greetingAdmin(){
        return "Hello Admin!!";
    }
    @GetMapping("/user/greet")
    public String greetingUser(){
        return "Hello User!!";
    }
}

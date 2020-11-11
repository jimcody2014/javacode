package com.example.adp1.controller;

import com.example.adp1.service.UsersService;
import com.querydsl.core.types.Predicate;
import com.example.adp1.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class UsersController {
    
    @Autowired
    private UsersService userService;

    // Get All Applicant Records
    @GetMapping("/users")
    @ResponseBody
    public Iterable<Users> getAllapplicants(@QuerydslPredicate(root = Users.class) Predicate predicate, Pageable pageable) {
    	return this.userService.getAllusers(predicate, pageable);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody Map<String,String> userDetails) {
    	return this.userService.loginUser(userDetails);
    }
}
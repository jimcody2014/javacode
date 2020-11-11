package com.example.adp1.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.adp1.model.Users;
import com.example.adp1.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository userRepository;
	
    String username;
    String pw;
  
    
    public Iterable<Users> getAllusers(Predicate predicate, Pageable pageable) {
        return userRepository.findAll(predicate, pageable);
    }
    
    public ResponseEntity<?> loginUser(Map<String,String> userdetails) {

	    //see what user details we were sent
	    ObjectMapper mapper = new ObjectMapper();
	    try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    userdetails.forEach((key, value) -> {
	    	switch (key) {
	    	 case "username":
	    		 username = (value + "");
	    		 break;
	    	 case "pw":
	    		 pw = (value + "");
	    		 break;
	    	}
	    });
	    
    	Users user = userRepository.findByUsername(username);
    	
    	//See what is inside user
	    ObjectMapper mapper2 = new ObjectMapper();
	    try {
			System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if (user.getusername().equals(username) && user.getpw().equals(pw)) {
	    	return new ResponseEntity<>(user, HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
	    }
	    
    }
    
    
}
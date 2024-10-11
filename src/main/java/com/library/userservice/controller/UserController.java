package com.library.userservice.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.userservice.model.User;
import com.library.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User foundUser = userService.findUserByUsername(user.getUsername());
        if (foundUser != null ) {
            //String token = new JwtUtil().generateToken(user.getUsername());
        	String token="abc";
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }else {
        	System.out.println("Invalid User! No Token will be generated");
        //	return ResponseEntity.ok(Collections.singletonMap("token", "Invalid User! No Token will be generated"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

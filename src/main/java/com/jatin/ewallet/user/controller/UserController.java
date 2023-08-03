package com.jatin.ewallet.user.controller;

import com.jatin.ewallet.user.service.UserService;
import com.jatin.ewallet.user.service.resource.UserRequest;
import com.jatin.ewallet.user.service.resource.UserResponse;
import com.jatin.ewallet.user.service.resource.UserTransactionRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@Valid @RequestBody  UserRequest userRequest){
        userService.addUser(userRequest);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping(value = "{userId}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest userRequest,@PathVariable String userId){
        UserResponse response=userService.updateUser(userRequest,userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId){
        UserResponse userResponse=userService.getUser(userId);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);

    }

    @PostMapping(value="{userId}/wallet/deposit")
    public ResponseEntity<?> userWalletUpdate(@RequestBody UserTransactionRequest userTransactionRequest,@PathVariable String userId){
        userService.updateBalance(userTransactionRequest,userId);
        return new ResponseEntity<>(null,HttpStatus.ACCEPTED);
    }
}

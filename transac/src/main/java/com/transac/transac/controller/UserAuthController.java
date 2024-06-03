package com.transac.transac.controller;

import org.springframework.web.bind.annotation.RestController;

import com.transac.transac.model.UserLoginModel;
import com.transac.transac.model.UserRegisterModel;
import com.transac.transac.model.WebResponeModel;
import com.transac.transac.service.AuthUsersService;

import jakarta.annotation.security.PermitAll;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@PermitAll
@RestController
public class UserAuthController {

    @Autowired
    private AuthUsersService authUsersService;


    
    //============================================= User Register Controller =====================================
    @PostMapping("/api/v1/auth/RegisterUser")
    public ResponseEntity<WebResponeModel<UserRegisterModel>> RegisterUser(@RequestBody UserRegisterModel request) {
    
   try {
    var result = authUsersService.UserRegisterService(request);
   
    WebResponeModel<UserRegisterModel> response = WebResponeModel.<UserRegisterModel>builder()
    .status(201)
    .data(result)
    .message("success data created")
    .build();
 
     return new ResponseEntity<>(response, HttpStatus.CREATED);
    
   } catch (Exception e) {
    

    WebResponeModel<UserRegisterModel> ErrorResponse = WebResponeModel.<UserRegisterModel>builder()
    .status(400)
    .message("failed data created")
    .errors(e.getMessage())
    .data(null)
    .build();

    return new ResponseEntity<>(ErrorResponse,HttpStatus.BAD_REQUEST);
    

   }
    
    }

    //============================================= End User Register Controller =====================================

    //============================================= User Login Controller =====================================

    @PostMapping("/api/v1/auth/LoginUser")
    public ResponseEntity<WebResponeModel<UserLoginModel>> LoginUser(@RequestBody UserLoginModel request) {
        try {
            var result = authUsersService.UserLoginService(request);
            WebResponeModel<UserLoginModel> response = WebResponeModel.<UserLoginModel>builder()
            .status(200)
            
            .message("success login")
            .build();
            return new ResponseEntity<>(response,HttpStatus.OK);
            
        } catch (Exception e) {
            WebResponeModel<UserLoginModel> ErrorResponse = WebResponeModel.<UserLoginModel>builder()
            .status(400)
            .message("failed login")
            .errors(e.getMessage())
            .data(null)
            .build();
            return new ResponseEntity<>(ErrorResponse,HttpStatus.BAD_REQUEST);
            
        }
    }

    //============================================= End User Login Controller =====================================
    @GetMapping("/api/v1/auth/test")
    public String getMethodName() {
        return "Hello World";
    }
    



    
    
}

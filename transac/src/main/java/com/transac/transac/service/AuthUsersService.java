package com.transac.transac.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.transac.transac.entity.UserEntity;
import com.transac.transac.model.UserLoginModel;
import com.transac.transac.model.UserRegisterModel;
import com.transac.transac.repository.UsersRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
@Transactional
public class AuthUsersService {


    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private Validator validator;

    // ====================================== User Register ======================================
    // This func for register  
    public UserRegisterModel UserRegisterService(UserRegisterModel request) {

        System.out.println("dari service request : " + request);

        Set<ConstraintViolation<UserRegisterModel>> constraintViolations = validator.validate(request);
        
        if(constraintViolations.size() > 0) {
            throw new ConstraintViolationException(constraintViolations);
        }

        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        var result = usersRepository.save(user);
        System.out.println("result123 : " + result);


         return UserRegisterModel.builder()
        .name(user.getName())
        .email(user.getEmail())
        .password(user.getPassword())
        .build();
    }
    // ====================================== End User Register ======================================


    // ====================================== User Login =======================================
    public UserLoginModel UserLoginService(UserLoginModel request) {
        Set<ConstraintViolation<UserLoginModel>> constraintViolations = validator.validate(request);
        
        if(constraintViolations.size() > 0) {
            throw new ConstraintViolationException(constraintViolations);
        }
        UserEntity user = usersRepository.findByEmail(request.getEmail());
        if(user == null) {
            throw new RuntimeException("User And Password Wrong");
        }

        if(!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("User And Password Wrong");
        }
        return UserLoginModel.builder()
        .email(user.getEmail())
        .password(user.getPassword())
        .build();


    }

    // ====================================== End User Login ======================================


    
}

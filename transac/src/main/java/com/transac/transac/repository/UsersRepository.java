package com.transac.transac.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transac.transac.entity.UserEntity;


@Repository
public interface UsersRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByEmail(String email);

    
}

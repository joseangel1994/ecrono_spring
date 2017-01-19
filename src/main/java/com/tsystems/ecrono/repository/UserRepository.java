package com.tsystems.ecrono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsystems.ecrono.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String name);
}

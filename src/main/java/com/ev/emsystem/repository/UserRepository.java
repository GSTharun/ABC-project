package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

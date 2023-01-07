package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}

package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}

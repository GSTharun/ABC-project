package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}

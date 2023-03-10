package com.ev.emsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ev.emsystem.dto.Address;
import com.ev.emsystem.service.AddressService;
import com.ev.emsystem.util.ResponseStructure;

@RestController
@RequestMapping("address")
public class AddressController {

	@Autowired
	private AddressService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id) {
		return service.getAddressById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@PathVariable int id) {
		return service.deleteAddressById(id);
	}

}

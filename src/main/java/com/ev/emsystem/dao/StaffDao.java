package com.ev.emsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ev.emsystem.dto.Staff;
import com.ev.emsystem.repository.StaffRepository;

@Repository
public class StaffDao {
	@Autowired
	private StaffRepository staffRepository;

	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	public Staff updateStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	public Optional<Staff> getStaffById(int id) {
		return staffRepository.findById(id);
	}

	public void deleteStaff(Staff staff) {
		staffRepository.delete(staff);

	}
}

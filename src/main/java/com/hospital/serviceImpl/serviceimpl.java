package com.hospital.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hospital.entity.Patient;
import com.hospital.repo.PatientRepository;
import com.hospital.service.PatientService;

@Service
public class serviceimpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient stored(Patient patient) {
		return patientRepository.save(patient);
	}

	@Cacheable("users")
	@Override
	public Patient fetch(Integer id) {
		System.err.println("cache mechanism");
		return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
	}

	@Override
	public Patient update(Integer id,Patient patient) {
		Optional<Patient> byId = patientRepository.findById(id);
		Patient orelse = byId.orElseThrow(() -> new RuntimeException("id not found"));
		orelse.setPatientName(patient.getPatientName());
		orelse.setAge(patient.getAge());
		orelse.setGender(patient.getGender());
		orelse.setDisease(patient.getDisease());
		return patientRepository.save(orelse);
	}
}

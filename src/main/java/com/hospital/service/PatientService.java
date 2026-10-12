package com.hospital.service;

import com.hospital.entity.Patient;

public interface PatientService 
{

	Patient stored(Patient patient);

	Patient fetch(Integer id);

	Patient update(Integer id,Patient patient);

	
	
}

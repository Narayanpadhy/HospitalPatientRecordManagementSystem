package com.hospital.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.ResponseMessage;
import com.hospital.entity.Patient;
import com.hospital.service.PatientService;
import com.hospital.utility.Responsemess;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@PostMapping("/save")
	@Operation(summary = "Post user",description = "create new user")
    @ApiResponses({
    @ApiResponse(responseCode = "201",description = "User created successfully"),
    @ApiResponse(responseCode = "400",description = "Badrequest"),
    @ApiResponse(responseCode = "500",description = "Interbal server Error")
   })
	
	public ResponseEntity<ResponseMessage> postMethodName(@RequestBody Patient patient) {

		try {
			if (patient.getAge() == null || patient.getGender().isEmpty())
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,
						Responsemess.failed.name(), "Age and gender cannot be null"));
			Patient patient2 = patientService.stored(patient);
			if (patient2 != null) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED,
						Responsemess.success.name(), "patient deatils added", "patient register successfully"));
			} else {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,
						Responsemess.failure.name(), "patient deatils not added", "patient register unsuccessfully"));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR,
					Responsemess.failed.name(), "internal server error "));
		}
	}

	@GetMapping("/retrieve/{id}")
	public ResponseEntity<ResponseMessage> retriev(@PathVariable Integer id) {
		try {
		if(id==null)
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Responsemess.failed.name(), "id cannot be null"));
		 Patient patient = patientService.fetch(id);
		 
		 if(patient != null) {
			 return ResponseEntity.ok(new ResponseMessage(200, Responsemess.success.name(), "Patient found", patient));
		 }
		 else
		 {
			 return ResponseEntity.ok(new ResponseMessage(404, "failed", "Patient not found"));
		 }
		}
catch (Exception e) {
	 return ResponseEntity.ok(new ResponseMessage(500,Responsemess.failure.name(),"internal server error"));

}
	}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<ResponseMessage> retriev(@PathVariable Integer id, @RequestBody Patient patient ) {
			try {
			if(id==null || patient.getPatientName().isEmpty())
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Responsemess.failed.name(), "id,name cannot be null"));
			
			Patient updat =  patientService.update(id,patient);
			 
			 if(updat != null) {
				 return ResponseEntity.ok(new ResponseMessage(200, Responsemess.success.name(), "Patient updated successfully", patient));
			 }
			 else
			 {
				 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,Responsemess.failed.name(), "Patient not found"));
			 }
			}
	catch (Exception e) {
		 return ResponseEntity.ok(new ResponseMessage(500,Responsemess.failure.name(),"internal server error"));
	}
}
	
	}

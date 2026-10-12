package com.hospital.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;

	@Column(name = "patientName")
	private String patientName;

	private Integer age;

	private String gender;

	private String disease;

	@CreationTimestamp
	private LocalDate doctorAssigned;

	@UpdateTimestamp
	private LocalDate admissionDate;

}

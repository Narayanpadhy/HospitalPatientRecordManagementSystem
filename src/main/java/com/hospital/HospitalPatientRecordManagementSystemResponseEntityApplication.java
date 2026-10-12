package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
        title = "Hospital Patient Record Management System",
        version = "1.0",
        description = "Register Management App",
        contact = @Contact(name ="MKCG medical collage",email = "mkcg@gmail.com")))

@SpringBootApplication
@EnableCaching
public class HospitalPatientRecordManagementSystemResponseEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalPatientRecordManagementSystemResponseEntityApplication.class, args);
	}

}

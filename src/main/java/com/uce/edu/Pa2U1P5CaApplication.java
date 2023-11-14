package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;

@SpringBootApplication
public class Pa2U1P5CaApplication implements CommandLineRunner {

	@Autowired
	private Estudiante estudiante;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.estudiante.setNombre("Cristian");
		this.estudiante.setApellido("Olivares");
		this.estudiante.setCedula("175075651");
		this.estudiante.setSalario(new BigDecimal(100));
		System.out.println(estudiante);
	}

}

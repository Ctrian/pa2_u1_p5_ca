package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5CaApplication implements CommandLineRunner {

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//1. Crear cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("156453121354");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.bancariaService.guardar(ctaOrigen);
		
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("14561231546");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.bancariaService.guardar(ctaDestino);
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(20));
		System.out.println(ctaOrigen);
		System.out.println(ctaDestino);
		
//		CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("1234");
//		System.out.println(ctaOrigen1);
//		
//		
//		CuentaBancaria ctaDestino1 = this.bancariaService.buscar("5678");
//		System.out.println(ctaDestino1);
	}
}

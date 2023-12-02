package com.uce.edu;

import java.lang.reflect.InaccessibleObjectException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;
import com.uce.edu.ioc.di.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5CaApplication implements CommandLineRunner {
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IInventarioService iInventarioService;
	
//	DI por constructor
//	@Autowired
//	public Pa2U1P5CaApplication(ITransferenciaService iTransServi) {
//		this.iTransferenciaService = iTransServi;
//	}

//	DI por método
//	@Autowired
//	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
//		this.iTransferenciaService = iTransferenciaService;
//	}


	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear un prodcuto
		Producto p1 = new Producto();
		p1.setCodigoBarras("123");
		p1.setNombre("HP 15 laptot");
		p1.setStock(0);
		
		this.iProductoService.guardar(p1);
		
		Producto p2 = new Producto();
		p2.setCodigoBarras("546");
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		
		this.iProductoService.guardar(p2);
		
		Bodega b1 = new Bodega();
		b1.setCapacidad(100);
		b1.setCodigo("132");
		b1.setDireccion("Izq");
		b1.setNombre("Bodega 1");
		
		System.out.println("Antes de la insercion");
		Producto p = this.iProductoService.buscar("123");
		Producto q = this.iProductoService.buscar("546");
		System.out.println(p);
		System.out.println(q);
		
		this.iInventarioService.registrar("132", "123", 50);
		//System.out.println(p1);
		
		this.iInventarioService.registrar("132", "546", 100);
		//System.out.println(p2);
		
		this.iInventarioService.registrar("132", "123", 20);
		//System.out.println(p1);
		
		System.out.println("Después de la insercion");
		System.out.println(p);
		System.out.println(q);
		
		
	}
}

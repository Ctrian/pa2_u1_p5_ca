package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	private BigDecimal aux = new BigDecimal("0");

	@Override
	public Transferencia buscar(BigDecimal numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void eliminar(BigDecimal numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);

	}

	@Override
	public BigDecimal nroFcat(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.nroFcat(bigDecimal);
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// 1.Buscar cuenta de origen
		CuentaBancaria ctaOrigen = this.bancariaRepository.seleccionar(numeroOrigen);
		// 2. Consultar el saldo
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		// 3. Validar el saldo
		if (saldoOrigen.compareTo(monto) >= 0) {
			// 4. Restar el monto
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
			// 5. Actualizar cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.bancariaRepository.actualizar(ctaOrigen);
			// 6. Buscar cta destino
			CuentaBancaria ctaDestino = this.bancariaRepository.seleccionar(numeroDestino);
			// 7. Consultar el saldo
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			// 8. Sumar el monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			// 9. Actualizar cta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.bancariaRepository.actualizar(ctaDestino);
			// 10. Crear la tranferencia
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(ctaOrigen);
			transferencia.setCuentaDestino(ctaDestino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumero(aux);

			this.iTransferenciaRepository.insertar(transferencia);
			aux = aux.add(BigDecimal.ONE);
			System.out.println("Transferencia realizada con Exito!");
		} else {
			System.out.println("Saldo no disponible");
		}
		System.out.println("No de transferencia: " + this.iTransferenciaRepository.nroFcat(aux));

	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.reporteTransferencia();
	}
}

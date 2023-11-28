package com.uce.edu.transferencia.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	// CRUD
	public Transferencia seleccionar(BigDecimal numero);

	public void insertar(Transferencia transferencia);

	public void actualizar(Transferencia transferencia);

	public void eliminar(BigDecimal numero);
	
	public BigDecimal nroFcat(BigDecimal bigDecimal);
	
	public List<Transferencia> reporteTransferencia();
}

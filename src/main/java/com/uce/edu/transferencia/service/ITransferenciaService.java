package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

public interface ITransferenciaService {
	public Transferencia buscar(BigDecimal numero);

	public void guardar(Transferencia transferencia);

	public void actualizar(Transferencia transferencia);

	public void eliminar(BigDecimal numero);

	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto);

	public BigDecimal nroFcat(BigDecimal bigDecimal);
	
	public List<Transferencia> buscarTodos();
}

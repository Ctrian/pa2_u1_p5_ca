package com.uce.edu.transferencia.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {
	private static List<Transferencia> base = new ArrayList<>();

	@Override
	public Transferencia seleccionar(BigDecimal numero) {
		// TODO Auto-generated method stub
		for (Transferencia cuenta : base) {
			if (cuenta.getNumero().equals(numero)) {
				return cuenta;
			}
		}
		return null;
	}
//	@Override
//	public Transferencia seleccionar(String numero) {
//
//		for (Transferencia cuenta : base) {
//			if (cuenta.getNumero().equals(numero)) {
//				return cuenta;
//			}
//		}
//		return null;
//	}

	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		base.add(transferencia);

	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
	}

	@Override
	public void eliminar(BigDecimal numero) {
		// TODO Auto-generated method stub
		Transferencia transferencia = this.seleccionar(numero);
		base.remove(transferencia);
	}

	@Override
	public BigDecimal nroFcat(BigDecimal bigDecimal) {
		BigDecimal aux = BigDecimal.ZERO;
		aux = aux.add(bigDecimal);
		return aux;
	}

	@Override
	public List<Transferencia> reporteTransferencia() {
		// TODO Auto-generated method stub
		List<Transferencia> lista = base;
		int indice = 0;
		for (Transferencia trans : lista) {
			indice++;
			System.out.println(indice + ":" + trans);
		}
		return lista;
	}
}

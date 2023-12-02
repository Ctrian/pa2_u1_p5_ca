package com.uce.edu.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;

@Service
public class BodegaServiceImpl implements IBodegaService {

	@Autowired
	private IBodegaRepository bodegaService;

	@Override
	public Bodega buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.bodegaService.seleccionar(codigo);
	}

	@Override
	public void guardar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaService.insertar(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaService.actualizar(bodega);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.bodegaService.eliminar(codigo);
	}

}

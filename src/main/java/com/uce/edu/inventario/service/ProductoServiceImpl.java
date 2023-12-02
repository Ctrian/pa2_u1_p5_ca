package com.uce.edu.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepository iProductoService;
	
	@Override
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoService.seleccionar(codigoBarras);
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoService.insertar(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoService.actualizar(producto);
	}

	@Override
	public void eliminar(String codigoBarras) {
		// TODO Auto-generated method stub
		this.iProductoService.eliminar(codigoBarras);
	}

}

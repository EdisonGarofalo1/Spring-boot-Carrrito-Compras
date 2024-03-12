package com.sistema.carrito.services;

import java.util.List;

import com.sistema.carrito.models.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id) throws Exception;
	public Producto save(Producto producto) throws Exception;
	public List<Producto> search(String filtro);
	
}

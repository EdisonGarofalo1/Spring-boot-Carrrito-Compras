package com.sistema.carrito.services;

import java.util.List;

import com.sistema.carrito.models.Cliente;

public interface ClienteService {
	
	public List<Cliente> findAll();
	public Cliente findById(Long id) throws Exception;
	public Cliente save(Cliente cliente) throws Exception;
	public List<Cliente> search(String filtro);
	

}

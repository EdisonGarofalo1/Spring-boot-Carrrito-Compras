package com.sistema.carrito.services;

import java.util.List;

import com.sistema.carrito.models.Categoria;

public interface CategoriaService {
	
	public List<Categoria> findAll();
	public Categoria findById(Long id) throws Exception;
	public Categoria save(Categoria categoria) throws Exception;
	public List<Categoria> search(String filtro);
	


}

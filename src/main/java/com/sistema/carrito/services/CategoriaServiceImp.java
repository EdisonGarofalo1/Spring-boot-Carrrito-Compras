package com.sistema.carrito.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.carrito.models.Categoria;
import com.sistema.carrito.repository.CategoriaRepository;

@Service
public class CategoriaServiceImp  implements  CategoriaService{
	
	@Autowired
	   private 	CategoriaRepository categoriaRepository;

	@Override
	public Categoria findById(Long id) throws Exception {
	
		try {
			return categoriaRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Categoria save(Categoria categoria) throws Exception {
		
		try {
			return categoriaRepository.save(categoria);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Categoria> search(String filtro) {
		// TODO Auto-generated method stub
		return  null;
	}

	@Override
	public List<Categoria> findAll() {
		
		return (List<Categoria>) categoriaRepository.findAll();
	}
	
	

}

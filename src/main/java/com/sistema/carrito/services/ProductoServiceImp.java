package com.sistema.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.carrito.models.Producto;
import com.sistema.carrito.repository.ProductoRepository;
@Service
public class ProductoServiceImp  implements ProductoService{
	
	@Autowired
	   private ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public Producto findById(Long id) throws Exception {
		try {
			return productoRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Producto save(Producto producto) throws Exception {
		try {
			return productoRepository.save(producto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Producto> search(String filtro) {
		// TODO Auto-generated method stub
		return null;
	}
 
}

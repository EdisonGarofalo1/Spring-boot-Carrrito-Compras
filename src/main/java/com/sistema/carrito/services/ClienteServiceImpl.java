package com.sistema.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.carrito.models.Cliente;
import com.sistema.carrito.repository.ClienteRepository;

@Service
public class ClienteServiceImpl  implements ClienteService{
	
	@Autowired
	   private  ClienteRepository   clienteRepository;

	@Override
	public List<Cliente> findAll() {

		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) throws Exception {
		try {
			return clienteRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Cliente save(Cliente cliente) throws Exception {
		
		try {
			return clienteRepository.save(cliente);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Cliente> search(String filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}

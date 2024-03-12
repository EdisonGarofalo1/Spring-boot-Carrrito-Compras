package com.sistema.carrito.controllers;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.carrito.models.Categoria;
import com.sistema.carrito.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	
	@Autowired
	private  CategoriaService    categoriaService;
	
	@GetMapping("/listar")
	public List<Categoria> listar() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Categoria detalle(@PathVariable Long id) throws Exception {
		return categoriaService.findById(id);
	}
	
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria crear(@RequestBody Categoria categoria) throws Exception {
		return categoriaService.save(categoria);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria editar(@RequestBody Categoria categoria, @PathVariable Long id) throws Exception {

		try {
			Categoria categoriaDB = categoriaService.findById(id);
			categoriaDB.setNombre(categoria.getNombre());
		
			return categoriaService.save(categoriaDB);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

package com.sistema.carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.carrito.dtos.VentaDTO;
import com.sistema.carrito.models.Venta;
import com.sistema.carrito.services.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
	
	   @Autowired
	    private  VentaService ventaService;
	   
	   

		@GetMapping("/listar")
		public List<Venta> listar() {
			return ventaService.findAll();
		}
		
		@GetMapping("/ver/{id}")
		public Venta detalle(@PathVariable Long id) throws Exception {
			return ventaService.findById(id);
		}
	   @PostMapping("/realiarventa")
	    public ResponseEntity<Venta> procesarVenta(@RequestBody VentaDTO ventaDTO) {
		    Venta ventaGuardada =   ventaService.RealizarVenta(ventaDTO);
	        return new ResponseEntity<>( ventaGuardada,HttpStatus.CREATED);
	    }
	   
	   @PutMapping("/{id}")
	    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody VentaDTO ventaDTO) {
	        Venta ventaActualizada = ventaService.ActualizarVenta(id, ventaDTO);
	        if (ventaActualizada != null) {
	            return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}

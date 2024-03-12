package com.sistema.carrito.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.carrito.dtos.VentaDTO;
import com.sistema.carrito.models.Venta;

@Service
public interface VentaService {
	public List<Venta> findAll();
	public Venta findById(Long id) throws Exception;
	public Venta  RealizarVenta(VentaDTO  ventaDTO );
	public Venta  ActualizarVenta( Long id ,VentaDTO  ventaDTO );

}

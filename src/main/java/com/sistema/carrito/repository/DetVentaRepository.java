package com.sistema.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.carrito.models.DetalleVenta;

public interface DetVentaRepository   extends  JpaRepository<DetalleVenta , Long>{

}

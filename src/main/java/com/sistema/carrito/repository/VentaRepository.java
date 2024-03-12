package com.sistema.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.carrito.models.Venta;

public interface VentaRepository  extends  JpaRepository<Venta , Long> {

}

package com.sistema.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.carrito.models.Producto;

public interface ProductoRepository  extends  JpaRepository< Producto, Long>{

}

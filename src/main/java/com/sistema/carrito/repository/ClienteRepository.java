package com.sistema.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.carrito.models.Cliente;

public interface ClienteRepository   extends  JpaRepository< Cliente, Long>{

}

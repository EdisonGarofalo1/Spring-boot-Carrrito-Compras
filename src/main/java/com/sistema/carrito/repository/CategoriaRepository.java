package com.sistema.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.carrito.models.Categoria;

public interface CategoriaRepository  extends  JpaRepository< Categoria, Long>{

}

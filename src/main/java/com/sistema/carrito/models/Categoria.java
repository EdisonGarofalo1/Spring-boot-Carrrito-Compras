package com.sistema.carrito.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "categoria" , uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Categoria  implements Serializable{

	
	private static final long serialVersionUID = -7349799460745385651L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoria_id;


	@Column(name = "nombre")
	    private String nombre;


	
	
	
	public Categoria() {
		super();
	}


	public Long getCategoria_id() {
		return categoria_id;
	}


	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}

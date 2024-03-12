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
@Table(name = "cliente",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Cliente  implements Serializable{
	

	private static final long serialVersionUID = -3526304921921356729L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;


	@Column(name = "nombre")
	    private String nombre;
	


	@Column(name = "telefono")
	    private String telefono;
	
	
	@Column(name = "direccion")
    private String direccion;


	public Cliente() {
		super();
	}


	public Long getCliente_id() {
		return cliente_id;
	}


	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




}

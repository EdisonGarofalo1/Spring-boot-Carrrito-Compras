package com.sistema.carrito.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta  implements Serializable{
	
	
	private static final long serialVersionUID = -8570120739941986583L;



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venta_id;
   
	@OneToMany(mappedBy = "venta",cascade = CascadeType.ALL)
	private  Set<DetalleVenta> detVenta= new HashSet<>();
	
	
	
	public void agregarDetalleVenta(DetalleVenta detalleVenta) {
        this.detVenta.add(detalleVenta);
    }
	   @ManyToOne 
		@JoinColumn(name = "id_cliente")
		private Cliente cliente;
	  
		 
	   @Column(name = "Total")
       private Double Total;
	
	@Column(name = "fecha")
    private String fecha;

	public Venta() {
		super();
	}

	public Long getVenta_id() {
		return venta_id;
	}

	public void setVenta_id(Long venta_id) {
		this.venta_id = venta_id;
	}

	public Set<DetalleVenta> getDetVenta() {
		return detVenta;
	}

	public void setDetVenta(Set<DetalleVenta> detVenta) {
		this.detVenta = detVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}





}

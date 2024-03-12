package com.sistema.carrito.dtos;

public class DetalleVentaDTO {

	private Long  id_det_ventas;
	private Long  producto_id;
	   
    public Long getId_det_ventas() {
		return id_det_ventas;
	}


	public void setId_det_ventas(Long id_det_ventas) {
		this.id_det_ventas = id_det_ventas;
	}


	private Integer cantidad;

 
    private Double precioUnitario;
    

    private Double subtotal;


	public DetalleVentaDTO() {
		super();
	}


	public Long getProducto_id() {
		return producto_id;
	}


	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public Double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
    
    
    
    

}

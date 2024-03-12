package com.sistema.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.carrito.repository.ProductoRepository;
import com.sistema.carrito.repository.VentaRepository;
import com.sistema.carrito.dtos.DetalleVentaDTO;
import com.sistema.carrito.dtos.VentaDTO;
import com.sistema.carrito.models.Cliente;
import com.sistema.carrito.models.DetalleVenta;
import com.sistema.carrito.models.Producto;
import com.sistema.carrito.models.Venta;
import com.sistema.carrito.repository.ClienteRepository;
import com.sistema.carrito.repository.DetVentaRepository;

@Service
public class VentaServiceImp  implements VentaService{

	
	@Autowired
	   private  ClienteRepository   clienteRepository;
	@Autowired
	
	private VentaRepository ventaRepository;
	
	@Autowired
	   private ProductoRepository productoRepository;
	
	@Autowired
	private DetVentaRepository detVentaRepository;
	@Override
	public List<Venta> findAll() {
	      return(List<Venta>) ventaRepository.findAll();
	}

	
	
	
	@Override
	public Venta  RealizarVenta(VentaDTO ventaDTO) {
		
		Venta venta = new Venta();
		
		venta.setFecha(ventaDTO.getFecha()); 
		venta.setTotal(ventaDTO.getTotal()); 	
		
		  if (ventaDTO.getTotal() == null) {
              throw new IllegalArgumentException("El tota no puede ser nula");
          }
		Cliente cliente = clienteRepository.findById(ventaDTO.getCliente_id())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + ventaDTO.getCliente_id()));
		
		venta.setCliente(cliente); 
		
		
		 for (DetalleVentaDTO detalleDTO : ventaDTO.getDetallesVenta()) {
	            Producto producto = productoRepository.findById(detalleDTO.getProducto_id())
	                                                  .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + detalleDTO.getProducto_id()));
	            DetalleVenta detalleVenta = new DetalleVenta();
	            detalleVenta.setProducto(producto);
	            detalleVenta.setCantidad(detalleDTO.getCantidad());
	            detalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
	            detalleVenta.setSubtotal(detalleDTO.getSubtotal());
	            detalleVenta.setVenta(venta);
	            venta.agregarDetalleVenta(detalleVenta);
	        }
		 Venta ventaGuardada = ventaRepository.save(venta);
		 
		 return ventaGuardada;
	}




	@Override
	public Venta findById(Long id) throws Exception {
	
		try {
			return ventaRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}




	@Override
	public Venta ActualizarVenta(Long id, VentaDTO ventaDTO) {
	
	    Venta ventaExistente = ventaRepository.findById(id).orElse(null);
        if (ventaExistente != null) {
    		
        Cliente cliente = clienteRepository.findById(ventaDTO.getCliente_id())
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + ventaDTO.getCliente_id()));
    		

        ventaExistente.setCliente(cliente);
        ventaExistente.setFecha(ventaDTO.getFecha());
        ventaExistente.setTotal(ventaDTO.getTotal());
        // Actualizar los detalles de venta
       // List<DetalleVentaDTO> nuevosDetalles = ventaDTO.getDetallesVenta();

        // Eliminar los detalles de venta existentes
        //detVentaRepository.deleteAll(ventaExistente.getDetVenta());
        // Crear y asociar los nuevos detalles de venta
        for (DetalleVentaDTO detalleDTO : ventaDTO.getDetallesVenta()) {
            DetalleVenta detalleExistente = ventaExistente.getDetVenta()
                    .stream()
                    .filter(detalle -> detalle.getDetalleVenta_Id().equals(detalleDTO.getId_det_ventas()))
                    .findFirst()
                    .orElse(null);
        	
        	
            if (detalleExistente != null) {
              
                detalleExistente.setCantidad(detalleDTO.getCantidad());
                detalleExistente.setPrecioUnitario(detalleDTO.getPrecioUnitario());
                detalleExistente.setSubtotal(detalleDTO.getSubtotal());
            } else {
        	
            Producto producto = productoRepository.findById(detalleDTO.getProducto_id())
                                                  .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + detalleDTO.getProducto_id()));
            DetalleVenta NuevodetalleVenta = new DetalleVenta();
            NuevodetalleVenta.setProducto(producto);
            NuevodetalleVenta.setCantidad(detalleDTO.getCantidad());
            NuevodetalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
            NuevodetalleVenta.setSubtotal(detalleDTO.getSubtotal());
            NuevodetalleVenta.setVenta(ventaExistente);
            ventaExistente.agregarDetalleVenta(NuevodetalleVenta);
        }
            
        }

     
            return ventaRepository.save(ventaExistente);
        } else {
            return null;
        }   
	}

}

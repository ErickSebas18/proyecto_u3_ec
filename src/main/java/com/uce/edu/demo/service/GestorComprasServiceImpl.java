package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class GestorComprasServiceImpl implements IGestorComprasService{

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IDetalleFacturaRepository detalleRepository;
	
	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> listaCodigo) {
		// TODO Auto-generated method stub

		Cliente cliente = this.clienteRepository.buscar(cedula);
		
		Factura factura = this.facturaRepository.consultar(numeroFactura);
		
		List<DetalleFactura> detalles = new ArrayList<>();

		for (String codigoProd : listaCodigo) {
			DetalleFactura deta = new DetalleFactura();
			deta.setCantidad(1);
			deta.setFactura(factura);
			deta.setProducto(this.productoRepository.buscar(codigoProd));
			deta.setSubtotal(deta.getProducto().getPrecio());
			Producto producto = this.productoRepository.buscar(codigoProd);
			producto.setStock(producto.getStock() - deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
			this.detalleRepository.insertar(deta);

		}
		
		Factura fact = new Factura();
		fact.setCliente(cliente);
		fact.setDetalleFacturas(detalles);
		fact.setFecha(LocalDateTime.now());
		fact.setNumero(numeroFactura);
		
		this.facturaRepository.insertar(factura);
		
		FacturaElectronica electronica = new FacturaElectronica();
		BigDecimal totalPagar = new BigDecimal(0);
		electronica.setNumero(numeroFactura);
		electronica.setFecha(LocalDateTime.now());
		electronica.setNumeroItem(factura.getDetalleFacturas().size());
		for (DetalleFactura detalle : factura.getDetalleFacturas()) {
			totalPagar = totalPagar.add(detalle.getSubtotal());
		}
		electronica.setMonto(totalPagar);
		
		this.electronicaRepository.insertar(electronica);
	}

	
}

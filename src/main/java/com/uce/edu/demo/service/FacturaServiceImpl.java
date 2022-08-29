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
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaLeftJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaLeftJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaRightJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaRightJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaRightJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaRightJoin();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaWhereJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaFetchJoin(cantidad);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedula, String numeroFactura, List<String> codigo) {
		// TODO Auto-generated method stub
		BigDecimal totalPagar = BigDecimal.ZERO;
		
		Cliente cliente = this.clienteRepository.buscar(cedula);
		
		
		Factura fact = new Factura();
		fact.setCliente(cliente);
		fact.setFecha(LocalDateTime.now());
		fact.setNumero(numeroFactura);
		
		List<DetalleFactura> detalles = new ArrayList<>();

		for (String codigoProd : codigo) {
			DetalleFactura deta = new DetalleFactura();
			deta.setCantidad(1);
			deta.setFactura(fact);
			Producto producto = this.productoRepository.buscar(codigoProd);
			deta.setProducto(producto);
			deta.setSubtotal(deta.getProducto().getPrecio());
			totalPagar.add(deta.getSubtotal());
			producto.setStock(producto.getStock() - deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
			//this.detalleRepository.insertar(deta);

		}
		
		fact.setDetalleFacturas(detalles);
		
		this.facturaRepository.insertar(fact);
		
		return totalPagar;
	}
	

}

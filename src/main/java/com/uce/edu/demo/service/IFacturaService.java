package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaInnerJoin();
	
	public List<Factura> buscarFacturaLeftJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaLeftJoin();
	
	public List<Factura> buscarFacturaRightJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaRightJoin();
	
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad);
	
	public BigDecimal procesarFactura(String cedula, String numeroFactura, List<String> codigo);
	
}

package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaInnerJoin();
	
	public List<Factura> buscarFacturaLeftJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaLeftJoin();
	
	public List<Factura> buscarFacturaRightJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaRightJoin();
	
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad);
	
	public Factura consultar(String numeroFactura);
	
	public void insertar(Factura factura);
	
	public void actualizar(Factura factura);

}

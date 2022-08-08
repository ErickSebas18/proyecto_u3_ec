package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

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
		return this.buscarFacturaWhereJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.buscarFacturaFetchJoin(cantidad);
	}
	

}

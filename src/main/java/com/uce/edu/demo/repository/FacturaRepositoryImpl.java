package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f inner join f.detalleFacturas fa where fa.cantidad > :cantidad", Factura.class);
		query.setParameter("cantidad", cantidad);
		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f inner join f.detalleFacturas fa", Factura.class);
		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaLeftJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f left join f.detalleFacturas fa where fa.cantidad > :cantidad", Factura.class);
		query.setParameter("cantidad", cantidad);
		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f left join f.detalleFacturas fa", Factura.class);
		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaRightJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f right join f.detalleFacturas fa where fa.cantidad > :cantidad", Factura.class);
		query.setParameter("cantidad", cantidad);
		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f right join f.detalleFacturas fa", Factura.class);
		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f join f.detalleFacturas fa where f = fa.factura and fa.cantidad > :cantidad", Factura.class);
		query.setParameter("cantidad", cantidad);
		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f join fetch f.detalleFacturas fa where fa.cantidad > :cantidad", Factura.class);
		query.setParameter("cantidad", cantidad);
		return query.getResultList();
	}

	@Override
	public Factura consultar(String numeroFactura) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"Select f from Factura f where f.numero = :numeroFactura", Factura.class);
		query.setParameter("numeroFactura", numeroFactura);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	
}

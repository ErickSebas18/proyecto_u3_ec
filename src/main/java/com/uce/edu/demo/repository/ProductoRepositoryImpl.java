package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Producto>query=this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.numero=: datoNumero", Producto.class);
		query.setParameter("datoNumero", numero);
		return query.getSingleResult();
	}

}

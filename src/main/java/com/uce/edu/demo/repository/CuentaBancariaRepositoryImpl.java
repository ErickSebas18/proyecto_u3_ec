package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static Logger logJava = Logger.getLogger(CuentaBancariaRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		logJava.error("Transacción activa BuscarPorNumero: " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> query = this.entityManager
				.createQuery("Select c from CuentaBancaria c where c.numero = :numero", CuentaBancaria.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

}

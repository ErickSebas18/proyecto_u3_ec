package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static Logger logJava = Logger.getLogger(HotelRepositoryImpl.class);

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h inner join h.habitaciones ha where ha.tipo = :tipoHabitacion", Hotel.class);
		query.setParameter("tipoHabitacion", tipoHabitacion);
		List<Hotel> hoteles = query.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("Select h from Hotel h inner join h.habitaciones ha",
				Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelLeftJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h left join h.habitaciones ha where ha.tipo = :tipoHabitacion", Hotel.class);
		query.setParameter("tipoHabitacion", tipoHabitacion);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("Select h from Hotel h left join h.habitaciones ha ",
				Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelRightJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h right join h.habitaciones ha where ha.tipo = :tipoHabitacion", Hotel.class);
		query.setParameter("tipoHabitacion", tipoHabitacion);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("Select h from Hotel h right join h.habitaciones ha",
				Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h join h.habitaciones ha where h = ha.hotel and ha.tipo = :tipoHabitacion",
				Hotel.class);
		query.setParameter("tipoHabitacion", tipoHabitacion);
		return query.getResultList();
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		logJava.info("Transacción activa Repository: " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h join fetch h.habitaciones ha where ha.tipo = :tipoHabitacion", Hotel.class);
		query.setParameter("tipoHabitacion", tipoHabitacion);
		return query.getResultList();
	}

}

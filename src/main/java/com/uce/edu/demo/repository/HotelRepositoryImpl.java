package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h inner join h.habitaciones ha where ha.tipo = :tipoHabitacion", Hotel.class);
		query.setParameter("tipoHabitacion", tipoHabitacion);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h inner join h.habitaciones ha", Hotel.class);
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
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h left join h.habitaciones ha ", Hotel.class);
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
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"Select h from Hotel h right join h.habitaciones ha", Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.uce.edu.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository;
	
	private static Logger logJava = Logger.getLogger(HotelServiceImpl.class);

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelLeftJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelLeftJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelRightJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelRightJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelLeftJoin();
	}

	@Override
	public List<Hotel> buscarHotelRightJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelRightJoin();
	}

	@Override
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelWhereJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		logJava.error("Transacción activa Service: " + TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRepository.buscarHotelFetchJoin(tipoHabitacion);
	}
	
	

}

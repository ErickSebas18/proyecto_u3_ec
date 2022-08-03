package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelService {

	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarHotelLeftJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelLeftJoin();

	public List<Hotel> buscarHotelRightJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelRightJoin();
}

package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelInnerJoin();
	
	public List<Hotel> buscarHotelLeftJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelLeftJoin();
	
	public List<Hotel> buscarHotelRightJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelRightJoin();
	
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion);
	
}

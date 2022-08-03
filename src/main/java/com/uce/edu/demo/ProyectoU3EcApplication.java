package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3EcApplication implements CommandLineRunner {

	private static Logger logJava = Logger.getLogger(ProyectoU3EcApplication.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Individual");

		for (Hotel h : listaHoteles) {
			logJava.info("Los hoteles individuales con Inner Join (Con parámetro) son: " + h);
		}
		
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelLeftJoin("Individual");
		
		for (Hotel h : listaHoteles2) {
			logJava.info("Los hoteles individuales con Left Join (Con parámetro) son: " + h);
		}
		
		List<Hotel> listaHoteles3 = this.hotelService.buscarHotelRightJoin("Individual");
		
		for (Hotel h : listaHoteles3) {
			logJava.info("Los hoteles individuales con Right Join (Con parámetro) son: " + h);
		}
		
		List<Hotel> listaHoteles4 = this.hotelService.buscarHotelInnerJoin();

		for (Hotel h : listaHoteles4) {
			logJava.info("Los hoteles individuales con Inner Join son: " + h);
		}
		
		List<Hotel> listaHoteles5 = this.hotelService.buscarHotelLeftJoin();
		
		for (Hotel h : listaHoteles5) {
			logJava.info("Los hoteles individuales con Left Join son: " + h);
		}
		
		List<Hotel> listaHoteles6 = this.hotelService.buscarHotelRightJoin();
		
		for (Hotel h : listaHoteles6) {
			logJava.info("Los hoteles individuales con Right Join son: " + h);
		}
		
	}

}

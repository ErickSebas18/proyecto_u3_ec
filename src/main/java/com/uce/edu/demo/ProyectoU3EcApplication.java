package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3EcApplication implements CommandLineRunner {

	private static Logger logJava = Logger.getLogger(ProyectoU3EcApplication.class);

	@Autowired
	private IFacturaService facturaService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	
		List<Factura> listaFacturas7 = this.facturaService.buscarFacturaWhereJoin(5);

		for (Factura f : listaFacturas7) {
			logJava.info("Las Facturas con Join Where (Con parámetro) son: " + f);
		}
		
		List<Factura> listaFacturas8 = this.facturaService.buscarFacturaFetchJoin(2);

		for (Factura f : listaFacturas8) {
			logJava.info("Las Facturas con Join Fetch (Con parámetro) son: " + f);
		}
	}

}

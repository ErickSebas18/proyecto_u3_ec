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

		List<Factura> listaFacturas = this.facturaService.buscarFacturaInnerJoin(2);

		for (Factura f : listaFacturas) {
			logJava.info("Los hoteles individuales con Inner Join (Con parámetro) son: " + f);
		}
		
		List<Factura> listaFacturas2 = this.facturaService.buscarFacturaLeftJoin(5);
		
		for (Factura f : listaFacturas2) {
			logJava.info("Los hoteles individuales con Left Join (Con parámetro) son: " + f);
		}
		
		List<Factura> listaFacturas3 = this.facturaService.buscarFacturaRightJoin(2);
		
		for (Factura f : listaFacturas3) {
			logJava.info("Los hoteles individuales con Right Join (Con parámetro) son: " + f);
		}
		
		List<Factura> listaFacturas4 = this.facturaService.buscarFacturaInnerJoin();

		for (Factura f : listaFacturas4) {
			logJava.info("Los hoteles individuales con Inner Join son: " + f);
		}
		
		List<Factura> listaFacturas5 = this.facturaService.buscarFacturaLeftJoin();
		
		for (Factura f : listaFacturas5) {
			logJava.info("Los hoteles individuales con Left Join son: " + f);
		}
		
		List<Factura> listaFacturas6 = this.facturaService.buscarFacturaRightJoin();
		
		for (Factura f : listaFacturas6) {
			logJava.info("Los hoteles individuales con Right Join son: " + f);
		}
		
		/*List<Factura> listaFacturas7 = this.facturaService.buscarFacturaWhereJoin(2);

		for (Factura f : listaFacturas7) {
			logJava.info("Los Hoteles con Join Where (Con parámetro) son: " + f);
		}
		
		List<Factura> listaFacturas8 = this.facturaService.buscarFacturaFetchJoin(2);

		for (Factura f : listaFacturas8) {
			logJava.info("Los hoteles con Join Fetch (Con parámetro) son: " + f);
		}*/
	}

}

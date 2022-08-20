package com.uce.edu.demo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.repository.modelo.Transferencia;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootTest
class ProyectoU3EcApplicationTests {

	private static Logger logJava = Logger.getLogger(ProyectoU3EcApplicationTests.class);
	
	@Autowired
	private IHotelRepository iHotelRepository;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	
	@Test
	public void testRealizarTransferencia() throws SQLException {
		
		/*List<Hotel> hoteles = this.iHotelRepository.buscarHotelWhereJoin("Individual");
		
		for (Hotel hotel : hoteles) {
			logJava.info("Los hoteles son: " + hoteles);
		}*/
		
		this.transferenciaService.realizarTransferencia("451234", "613456", new BigDecimal(5));
		
	}
	
	

}

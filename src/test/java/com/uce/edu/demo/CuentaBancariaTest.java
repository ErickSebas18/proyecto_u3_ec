package com.uce.edu.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.CuentaBancariaRepositoryImpl;
import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@SpringBootTest
class CuentaBancariaTest {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	private static Logger logJava = Logger.getLogger(CuentaBancariaRepositoryImpl.class);

	// Comprobar que una cuenta bancaria exista en la base de datos
	@Test
	void testExiste() throws SQLException {

		CuentaBancaria cuenta = null;
		try {
			cuenta = this.bancariaRepository.buscarPorNumero("11212131");
		} catch (Exception e) {
			logJava.error(e.getMessage());
		}
		assertNotNull(cuenta);
	}

}

package com.uce.edu.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootTest
class TransferenciaTest {


	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	//Comprobar si se puede realizar una transferencia segun el saldo de una cuenta y el monto asignado
		@Test
		void testMontoTransferencia(){
			CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("451234");	
			BigDecimal monto = new BigDecimal(5);
			assertTrue(ctaOrigen.getSaldo().doubleValue() > monto.doubleValue(), "Comprobar Monto Válido");
		}

		//Comprobar validación de una transferencia
		@Test
		void testInsercion() {
			this.transferenciaService.realizarTransferenciaTest("15", "451234", "613456", new BigDecimal(5));
			Transferencia transferenciaDB = this.transferenciaRepository.buscarPorNumero("15");
			
			CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("451234");	
			CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("613456");	
			
			assertEquals(transferenciaDB.getCuentaOrigen().getNumero(), ctaOrigen.getNumero(),"Validar cuenta origen");
			assertEquals(transferenciaDB.getCuentaDestino().getNumero(), ctaDestino.getNumero(), "Validar cuenta destino");	
		}
		
		@Test
		void testInsercionCuentasIguales() {
			CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("451234");	
			CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("613456");	
			
			assertNotEquals(ctaOrigen.getNumero(), ctaDestino.getNumero(),"Validación misma cuenta");
			
			this.transferenciaService.realizarTransferenciaTest("649", ctaOrigen.getNumero(), ctaDestino.getNumero(), new BigDecimal(5));		
		}
		
		//Comprobar que se realizó la transferencia correctamente
		@Test
		void testResultadoTransferencia() {
			CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("613456");
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			BigDecimal monto = new BigDecimal(5);
			this.transferenciaService.realizarTransferenciaTest("25", "451234", "613456", monto);
			BigDecimal saldoFinal = this.bancariaRepository.buscarPorNumero("613456").getSaldo();
			
			assertTrue(saldoDestino.compareTo(saldoFinal.subtract(monto))==0, "Comprobar transferencia exitosa");
			
		}
}

package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String NumeroCuentaOrigen, String NumeroCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		// 1. Restar el monto a la cuenta de Origen
		CuentaBancaria cuentaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(NumeroCuentaOrigen);
		BigDecimal resto = cuentaOrigen.getSaldo().subtract(monto);
		cuentaOrigen.setSaldo(resto);
		this.iCuentaBancariaRepository.actualizar(cuentaOrigen);
		// 2. Sumar el monto a la cuenta de Destino
		CuentaBancaria cuentaDestino = this.iCuentaBancariaRepository.buscarPorNumero(NumeroCuentaDestino);
		BigDecimal saldoFinal = cuentaDestino.getSaldo().add(monto);
		cuentaDestino.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(cuentaDestino);
		// 3. Insertar la transferencia
		Transferencia transferencia = new Transferencia();
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		transferencia.setCuentaOrigen(cuentaOrigen);
		transferencia.setCuentaDestino(cuentaDestino);
		this.iTransferenciaRepository.insertar(transferencia);

//		if (cuentaOrigen.getTipo().equals("Ahorros")) {
//			throw new RuntimeException();
//		}
		if (monto.compareTo(cuentaOrigen.getSaldo()) > 0) {
			throw new RuntimeException();
		} 
	}

	@Override
	// @Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED) // REQUIRED es por defecto
	public void realizarTransferenciaTest(String numero, String numeroCuentaOrigen, String numeroCuentaDestino,
			BigDecimal monto) {
		// TODO Auto-generated method stub
		// 0. Buscar las cuentas origen y destino
		// 1. Restar el monto de la cuenta origen
		// 2. Sumar el monto a la cuenta destino
		// 3. Insertar transferencia

		// 0.
		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(numeroCuentaOrigen);
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.buscarPorNumero(numeroCuentaDestino);

		// 1.
		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);
		// 2.
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.iCuentaBancariaRepository.actualizar(ctaDestino);

		// 3.
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaOrigen(ctaOrigen);
		transferencia.setCuentaDestino(ctaDestino);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setNumero(numero);
		transferencia.setMonto(monto);
		// id es secuencia desde la base de datos
		this.iTransferenciaRepository.insertar(transferencia);

	}
}

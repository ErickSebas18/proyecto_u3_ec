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
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String NumeroCuentaOrigen, String NumeroCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//1. Restar el monto a la cuenta de Origen
		CuentaBancaria cuentaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(NumeroCuentaOrigen);
		BigDecimal resto = cuentaOrigen.getSaldo().subtract(monto);
		cuentaOrigen.setSaldo(resto);
		this.iCuentaBancariaRepository.actualizar(cuentaOrigen);
		//2. Sumar el monto a la cuenta de Destino
		CuentaBancaria cuentaDestino = this.iCuentaBancariaRepository.buscarPorNumero(NumeroCuentaDestino);
		BigDecimal saldoFinal = cuentaDestino.getSaldo().add(monto);
		cuentaDestino.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(cuentaDestino);
		//3. Insertar la transferencia
		Transferencia transferencia = new Transferencia();
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		transferencia.setCuentaOrigen(cuentaOrigen);
		transferencia.setCuentaDestino(cuentaDestino);
		this.iTransferenciaRepository.insertar(transferencia);
	}

	@Override
	//@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
	}

}

package com.uce.edu.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertar(cliente);
	}

	
}

package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IGestorComprasService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3EcApplication implements CommandLineRunner {

	private static Logger logJava = Logger.getLogger(ProyectoU3EcApplication.class);

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private IGestorComprasService comprasService;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		this.iTransferenciaService.realizarTransferencia("451234", "613456", new BigDecimal(1));
		
		Cliente cliente=new Cliente();
		cliente.setCedula("1720223031");
		cliente.setNumeroTarjeta("1234567");
		//this.clienteRepository.insertar(cliente);
		
		Producto producto=new Producto();
		producto.setNombre("Arroz");
		producto.setNumero("45");
		producto.setPrecio(new BigDecimal(1.50));
		producto.setStock(50);
		//this.iProductoRepository.insertar(producto);
		
		Producto producto2=new Producto();
		producto2.setNombre("Chicles");
		producto2.setNumero("05");
		producto2.setPrecio(new BigDecimal(5.00));
		producto2.setStock(75);
		//this.iProductoRepository.insertar(producto2);
		
		Producto producto3=new Producto();
		producto3.setNombre("Chocolate");
		producto3.setNumero("01");
		producto3.setPrecio(new BigDecimal(0.50));
		producto3.setStock(100);
		//this.iProductoRepository.insertar(producto3);
		
		List<String>detalles=new ArrayList<>();
		detalles.add(producto.getNumero());
		detalles.add(producto2.getNumero());
		detalles.add(producto3.getNumero());
		
		this.comprasService.registrarCompraProducto("1720223031", "6543214", detalles);
	}

}

package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajeroParalelo;
	
	public PCCajeroParalelo(CajeroParalelo cajeroParalelo) {
		this.cajeroParalelo = cajeroParalelo;
	}
	
	@Override
	public void run() {
		this.procesar(this.cajeroParalelo);
	}

	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando cajero: " + cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Ha terminado de ejecutar: " + cajero.getNombre()+ " en: "+ tiempoTranscurrido + "seg");
	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

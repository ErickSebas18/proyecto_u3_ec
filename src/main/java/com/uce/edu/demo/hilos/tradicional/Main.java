package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Edison", Arrays.asList("Pepito", "Daniela", "Juan", "Pedro", "Erick"));
		Cajero cajero2 = new Cajero("Luis", Arrays.asList("Pepito2", "Daniela2", "Juan2", "Pedro2"));
		Cajero cajero3 = new Cajero("Paul", Arrays.asList("Pepito3", "Daniela3", "Juan3"));
		
		PCCajero  gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		
		System.out.println("Tiempo Transcurrido: " + tiempoTranscurrido + "seg");
		
		
	}

}
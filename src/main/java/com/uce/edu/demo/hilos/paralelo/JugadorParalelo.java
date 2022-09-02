package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class JugadorParalelo extends Thread {

	private Jugador jugador;

	public JugadorParalelo(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void run() {
		this.ejecutar(this.jugador);

	}

	public void ejecutar(Jugador jugador) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName());
		System.out.println("Ejecutando accion...........");
		String accion = this.ejecutarAccion(jugador.getAcción(), jugador.getNombre());
		for (int i = 1; i<10; i++) {
			if (accion.equals("saltar")) {
				jugador.setPuntaje(jugador.getPuntaje() + 1);
			} else if (accion.equals("correr")) {
				jugador.setPuntaje(jugador.getPuntaje() + 2);
			} else {
				jugador.setPuntaje(jugador.getPuntaje() + 3);
			}
		}
		
		System.out.println("Su puntaje es: " + jugador.getPuntaje());
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Ha terminado de ejecutar: " + jugador.getNombre() + " en: " + tiempoTranscurrido + "seg");
	}

	private String ejecutarAccion(String accion, String nombre) {
		System.out.println("El jugador " + nombre + " su acción es: " + accion);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return jugador.getAcción();
	}
}

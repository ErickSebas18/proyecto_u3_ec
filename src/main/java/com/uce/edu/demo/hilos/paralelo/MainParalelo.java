package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jugador jugador1 = new Jugador("Erick", "correr", 0);
		Jugador jugador2 = new Jugador("Paúl", "saltar", 0);
		Jugador jugador3 = new Jugador("Cristian", "agacharse", 0);
		Jugador jugador4 = new Jugador("Kevin", "saltar", 0);
		Jugador jugador5 = new Jugador("Alexander", "agacharse", 0);
		
		JugadorParalelo empezar = new JugadorParalelo(jugador1);
		empezar.start();
		JugadorParalelo empezar2 = new JugadorParalelo(jugador2);
		empezar2.start();
		JugadorParalelo empezar3 = new JugadorParalelo(jugador3);
		empezar3.start();
		JugadorParalelo empezar4 = new JugadorParalelo(jugador4);
		empezar4.start();
		JugadorParalelo empezar5 = new JugadorParalelo(jugador5);
		empezar5.start();
		
		
		/*CajeroParalelo cajero1 = new CajeroParalelo("Edison",
				Arrays.asList("Pepito", "Daniela", "Juan", "Pedro", "Erick"));
		CajeroParalelo cajero2 = new CajeroParalelo("Luis", Arrays.asList("Pepito2", "Daniela2", "Juan2", "Pedro2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Paul", Arrays.asList("Pepito3", "Daniela3", "Juan3"));

		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();*/

	
	}

}

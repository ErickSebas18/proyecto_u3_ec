package com.uce.edu.demo.hilos.paralelo;

public class Jugador {

	private String nombre;
	private String acción;
	private Integer puntaje;
	
	
	public Jugador(String nombre, String acción, Integer puntaje) {
		super();
		this.nombre = nombre;
		this.acción = acción;
		this.puntaje = puntaje;
	}
	
	//SET Y GET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAcción() {
		return acción;
	}
	public void setAcción(String acción) {
		this.acción = acción;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
	
	
}

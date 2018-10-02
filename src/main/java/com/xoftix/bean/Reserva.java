package com.xoftix.bean;
/*
 * Clase Reserva: Representa reserva de pel�culas
 * */

import java.sql.Timestamp;

public class Reserva {
	
	private Long IDMovie;
	private Long IDCliente;
	private Timestamp date;
	
	public Reserva() {
		
	}

	public Long getIDMovie() {
		return IDMovie;
	}

	public void setIDMovie(Long iDMovie) {
		IDMovie = iDMovie;
	}

	public Long getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(Long iDCliente) {
		IDCliente = iDCliente;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}

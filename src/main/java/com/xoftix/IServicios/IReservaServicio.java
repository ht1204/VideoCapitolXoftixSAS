package com.xoftix.IServicios;

import com.xoftix.bean.Reserva;
import java.util.List;

public interface IReservaServicio {
	
	//M�todo para guardar reserva de pel�culas
	void guardarReserva(Reserva reserve);
	
	//M�todo para encontrar reserva
	Reserva findReservaId(Long IDReserva);
	
	//M�todo para obtener lista de reservas por cliente
	List<Reserva> findReservaPorCliente(Long IDCliente);
	
	//M�todo para borrar reserva
	int borrarReserva(Long IDReserve);
	
}

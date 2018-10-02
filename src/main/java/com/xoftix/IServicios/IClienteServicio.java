package com.xoftix.IServicios;

import com.xoftix.bean.Cliente;

public interface IClienteServicio {
	
	//M�todo guardar registro cliente
	void guardarCliente(Cliente cli);
	
	//M�todo encontrar cliente
	Cliente findClienteID(Long IDCliente);
}

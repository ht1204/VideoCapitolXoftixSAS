package com.xoftix.controller;

import java.util.List;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.ClienteService;
import com.xoftix.Services.ReservaService;
import com.xoftix.bean.Reserva;

public class ReservaListClienteController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8318633773444678469L;
	
		
	@Wire
	private Textbox txtRUT;
	
	private ClienteService cliS=new ClienteService();
	private ReservaService rs=new ReservaService();
	
	@Listen("onClick = #btnbtnReservaCliente")
	public void cargarLista(){
		if(!txtRUT.getText().equals("")) {
			String rut=txtRUT.getText();
			int idCliente=cliS.findClienteRUT(rut);
			long idc= (long) idCliente;
			List<Reserva> rList=rs.findReservaPorCliente(idc);
			
			//Cargar lista
			
		}
		
	}
}

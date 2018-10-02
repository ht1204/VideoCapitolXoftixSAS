package com.xoftix.controller;

import java.util.List;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Window;

import com.xoftix.Services.ReservaService;
import com.xoftix.Services.UserService;
import com.xoftix.bean.Reserva;

public class ReservaListController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1055979036360051352L;
	
	ReservaService rs=new ReservaService();
	
	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		List<Reserva> resList=rs.reservaLista();
		
		//cargar lista reserva
	}
		

}

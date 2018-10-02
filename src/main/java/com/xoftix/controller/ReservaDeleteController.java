package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.ReservaService;
import com.xoftix.Services.UserService;

public class ReservaDeleteController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5778373567099168456L;
	
	@Wire
	private Textbox txtIDReserva;
	
	private ReservaService rs =  new ReservaService();
	
	@Listen("onClick = #btnDeleteReserva")
	public void borrar(){
		if(!txtIDReserva.getText().equals("")) {
			String idRes=txtIDReserva.getText();
			boolean eliminado = rs.borrarReserva(Long.parseLong(idRes));
			String mensaje = eliminado ? "Registro eliminado con éxito" : "Error al eliminar el registro";
			
			alert(mensaje);
			txtIDReserva.setText("");
		}else {
			alert("No debe ingresar campo vacío");
		}
	}
	
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtIDReserva.setText("");
	}

}

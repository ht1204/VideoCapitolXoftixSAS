package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.ClienteService;

public class ClienteDeleteController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5249252409557018740L;
	
	@Wire
	private Textbox txtRUT;
	
	private ClienteService cliS=new ClienteService();
	
	@Listen("onClick = #btnDeleteCliente")
	public void borrar(){
		if(!txtRUT.getText().equals("")) {
			String rut=txtRUT.getText();
			boolean eliminado =cliS.deleteCliente(rut);
			String mensaje = eliminado ? "Registro eliminado con éxito" : "Error al eliminar el registro";
			
			alert(mensaje);
			txtRUT.setText("");
		}else {
			alert("No debe ingresar campo vacío");
		}
	}
	
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtRUT.setText("");
	}

}

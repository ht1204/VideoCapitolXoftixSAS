package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.UserService;

public class UserDeleteController extends SelectorComposer<Window>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1040020161937023841L;
	@Wire
	private Textbox txtUsername;
	
	private UserService userService =  new UserService();
	
	@Listen("onClick = #btnDeleteUser")
	public void borrar(){
		if(!txtUsername.getText().equals("")) {
			String userName=txtUsername.getText();
			boolean eliminado = userService.deleteUser(userName);
			String mensaje = eliminado ? "Registro eliminado con éxito" : "Error al eliminar el registro";
			
			alert(mensaje);
			txtUsername.setText("");
		}else {
			alert("No debe ingresar campo vacío");
		}
	}
	
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtUsername.setText("");
	}
}

package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.UserService;
import com.xoftix.bean.User;

public class UserAddController extends SelectorComposer<Window> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8342746015142247142L;

	
	@Wire
	private Textbox txtUsername;
	@Wire
	private Textbox txtPassword;
	@Wire
	private Combobox typeUser;

	private UserService userService =  new UserService();
	
	
	@Listen("onClick = #btnAddUser")
	public void guardar(){
		User user = new User();
		user.setLogin(txtUsername.getText());
		user.setUserName(txtUsername.getText());
		user.setPass(txtPassword.getText());
		user.setTipoUsuario(typeUser.getSelectedIndex());
		
		boolean guardado = userService.guardarUser(user);
		String mensaje = guardado ? "Registro guardado con éxito" : "Error al guardar el registro";
		
		alert(mensaje);
		txtUsername.setText("");
		txtPassword.setText("");
		typeUser.setSelectedIndex(0);

	}
	
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtUsername.setText("");
		txtPassword.setText("");
		typeUser.setSelectedIndex(0);
	}

	
}

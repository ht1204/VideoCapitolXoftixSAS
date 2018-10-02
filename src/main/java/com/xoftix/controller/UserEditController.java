package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.UserService;
import com.xoftix.bean.User;

public class UserEditController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5916272684587413926L;
	
	@Wire
	private Textbox txtIdUser;
	@Wire
	private Textbox txtUsername;
	@Wire
	private Textbox txtPassword;
	@Wire
	private Combobox typeUser;
	
	private UserService userService =  new UserService();
	
	@Listen("onClick = #btnEditUser")
	public void editar(){
		User user = new User();
		user.setIDUser(Integer.parseInt(txtIdUser.getText()));
		user.setLogin(txtUsername.getText());
		user.setUserName(txtUsername.getText());
		user.setPass(txtPassword.getText());
		user.setTipoUsuario(typeUser.getSelectedIndex());
		
		boolean editado = userService.editUser(user);
		String mensaje = editado ? "Registro editar con éxito" : "Error al editar el registro";
		
		alert(mensaje);
		txtIdUser.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
		typeUser.setSelectedIndex(0);
		
	}

	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtIdUser.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
		typeUser.setSelectedIndex(0);
	}
}

package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.ClienteService;
import com.xoftix.bean.Cliente;
import com.xoftix.bean.User;

public class ClienteAddController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Wire
	private Textbox txtNombre;
	
	@Wire
	private Textbox txtRUT;
	
	@Wire
	private Textbox txtDireccion;
	
	@Wire
	private Textbox txtTelefono;
	
	
	
	
	private ClienteService cliS=new ClienteService();
	
	@Listen("onClick = #btnAddCliente")
	public void guardar(){
		Cliente cli=new Cliente();
		cli.setRut(txtRUT.getText());
		cli.setName(txtNombre.getText());
		cli.setAddress(txtDireccion.getText());
		cli.setTel(Long.parseLong(txtTelefono.getText()));
		cli.setIDUser(2);
		boolean guardado = cliS.guardarCliente(cli);
		String mensaje = guardado ? "Registro guardado con éxito" : "Error al guardar el registro";
		
		alert(mensaje);
		
		txtNombre.setText("");
		txtRUT.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}

	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtNombre.setText("");
		txtRUT.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}

}

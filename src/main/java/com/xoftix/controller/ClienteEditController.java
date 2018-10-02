package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.ClienteService;
import com.xoftix.bean.Cliente;

public class ClienteEditController  extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2823814345549744558L;
	
	@Wire
	private Textbox txtIdCliente;
	
	@Wire
	private Textbox txtNombre;
	
	@Wire
	private Textbox txtRUT;
	
	@Wire
	private Textbox txtDireccion;
	
	@Wire
	private Textbox txtTelefono;
	
	
	private ClienteService cliS=new ClienteService();
	
	@Listen("onClick = #btnEditCliente")
	public void editar(){
		Cliente cli=new Cliente();
		cli.setIDCliente(Integer.parseInt(txtIdCliente.getText()));
		cli.setRut(txtRUT.getText());
		cli.setName(txtNombre.getText());
		cli.setAddress(txtDireccion.getText());
		cli.setTel(Long.parseLong(txtTelefono.getText()));
		//cli.setIDUser(2);
		boolean editado = cliS.editarCliente(cli);
		String mensaje = editado ? "Registro editado con éxito" : "Error al editar el registro";
		
		alert(mensaje);
		
		txtIdCliente.setText("");
		txtNombre.setText("");
		txtRUT.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
	
	
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtIdCliente.setText("");
		txtNombre.setText("");
		txtRUT.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
}

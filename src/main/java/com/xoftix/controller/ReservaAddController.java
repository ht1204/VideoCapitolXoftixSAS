package com.xoftix.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.ClienteService;
import com.xoftix.Services.MovieService;
import com.xoftix.Services.ReservaService;
import com.xoftix.Services.UserService;
import com.xoftix.bean.Reserva;

public class ReservaAddController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -709209458937637042L;
	
	@Wire
	private Textbox txtRutCliente;
	
	@Wire
	private Textbox txtIdPelicula;
	
	
	private ReservaService resService =  new ReservaService();
	private ClienteService cliS =  new ClienteService();
	private MovieService movS=new MovieService();
	
	@Listen("onClick = #btnAddReserva")
	public void guardar() {
		int idCli=cliS.findClienteRUT(txtRutCliente.getText());
		Reserva res=new Reserva();
		if(idCli!=-1) {
			long idC=(long) idCli;
			res.setIDCliente(idC);
		}else {
			alert("Cliente no existe");
		}
		
		int idMov=movS.findMovieID(Integer.parseInt(txtIdPelicula.getText()));
		if(idMov!=-1) {
			long idM=(long)idMov;
			res.setIDMovie(idM);
		}else {
			alert("Pelicula no existe");
		}
		
		if(idCli!=-1 && idMov!=-1) {
			Date date = new Date();
			Timestamp ts=new Timestamp(date.getTime());  
			res.setDate(ts);
			boolean guardado = resService.guardarReserva(res);
			String mensaje = guardado ? "Registro guardado con éxito" : "Error al guardar el registro";
			alert(mensaje);
			
			txtRutCliente.setText("");
			txtIdPelicula.setText("");
		}
	}
	
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtRutCliente.setText("");
		txtIdPelicula.setText("");
	}
}

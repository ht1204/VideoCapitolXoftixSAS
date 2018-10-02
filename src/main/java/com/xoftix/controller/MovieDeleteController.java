package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.MovieService;

public class MovieDeleteController extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8112963507313881286L;
	
	@Wire
	private Textbox txtTitle;
	
	private MovieService ms=new MovieService();
	
	@Listen("onClick = #btnDeletePelicula")
	public void borrar(){
		if(!txtTitle.getText().equals("")) {
			String title=txtTitle.getText();
			boolean eliminado = ms.deleteMovie(title);
			String mensaje = eliminado ? "Registro eliminado con éxito" : "Error al eliminar el registro";
			
			alert(mensaje);
			txtTitle.setText("");
		}else {
			alert("No debe ingresar campo vacío");
		}
		
	}
		
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtTitle.setText("");
	}

}

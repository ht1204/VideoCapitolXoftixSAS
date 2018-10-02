package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.MovieService;
import com.xoftix.bean.Movie;

public class MovieEditController  extends SelectorComposer<Window>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -121389098147513494L;
	
	@Wire
	private Textbox txtIdPelicula;
	
	@Wire
	private Textbox txtTitle;
	
	@Wire
	private Textbox txtDescription;
	
	@Wire
	private Textbox txtActorList;
	
	@Wire
	private Textbox txtDirector;
	
	@Wire
	private Textbox txtStockMin;
	
	@Wire
	private Textbox txtStockMax;
	
	private MovieService ms=new MovieService();
	
	@Listen("onClick = #btnEditPelicula")
	public void editar(){
		Movie mov=new Movie();
		mov.setIDMovie(Integer.parseInt(txtIdPelicula.getText()));
		mov.setTitle(txtTitle.getText());
		mov.setDescription(txtDescription.getText());
		mov.setActorList(txtActorList.getText());
		mov.setDirector(txtDirector.getText());
		if(Integer.parseInt(txtStockMax.getText())>Integer.parseInt(txtStockMin.getText())) {
			mov.setStockMax(Integer.parseInt(txtStockMax.getText()));
			mov.setStockMin(Integer.parseInt(txtStockMin.getText()));
			
			
			boolean editado =ms.editarMovie(mov);
			String mensaje = editado ? "Registro editado con éxito" : "Error al editar el registro";
			alert(mensaje);
			
			txtIdPelicula.setText("");
			txtTitle.setText("");
			txtDescription.setText("");
			txtActorList.setText("");
			txtDirector.setText("");
			txtStockMax.setText("");
			txtStockMin.setText("");
		
		}else {
			alert("StockMax debe ser mayor a StockMin");
		}
	}
	
	@Listen("onClick = #btnLimpiar")
	public void clear() {
		txtIdPelicula.setText("");
		txtTitle.setText("");
		txtDescription.setText("");
		txtActorList.setText("");
		txtDirector.setText("");
		txtStockMax.setText("");
		txtStockMin.setText("");
	}

}

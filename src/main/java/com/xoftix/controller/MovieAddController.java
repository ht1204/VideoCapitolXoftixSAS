package com.xoftix.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.MovieService;
import com.xoftix.bean.Movie;

public class MovieAddController extends SelectorComposer<Window> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647772144711342070L;


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
	
	@Listen("onClick = #btnAddPelicula")
	public void guardar() {
		Movie mov=new Movie();
		mov.setTitle(txtTitle.getText());
		mov.setDescription(txtDescription.getText());
		mov.setActorList(txtActorList.getText());
		mov.setDirector(txtDirector.getText());
		if(Integer.parseInt(txtStockMax.getText())>Integer.parseInt(txtStockMin.getText())) {
			mov.setStockMax(Integer.parseInt(txtStockMax.getText()));
			mov.setStockMin(Integer.parseInt(txtStockMin.getText()));
			
			
			boolean guardado =ms.guardarMovie(mov);
			String mensaje = guardado ? "Registro guardado con éxito" : "Error al guardar el registro";
			alert(mensaje);
			
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
		txtTitle.setText("");
		txtDescription.setText("");
		txtActorList.setText("");
		txtDirector.setText("");
		txtStockMax.setText("");
		txtStockMin.setText("");
	}

}

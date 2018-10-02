package com.xoftix.bean;
/**
 *Clase Movie: Representa entidad de pel�cula 
 * */

public class Movie {
	
	private int IDMovie;
	private String title;
	private String description;
	private String actorList;
	private String director;
	private Integer stockMin;
	private Integer stockMax;
	
	public Movie() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActorList() {
		return actorList;
	}

	public void setActorList(String actorList) {
		this.actorList = actorList;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getStockMin() {
		return stockMin;
	}

	public void setStockMin(Integer stockMin) {
		this.stockMin = stockMin;
	}

	public Integer getStockMax() {
		return stockMax;
	}

	public void setStockMax(Integer stockMax) {
		this.stockMax = stockMax;
	}

	public int getIDMovie() {
		return IDMovie;
	}

	public void setIDMovie(int iDMovie) {
		IDMovie = iDMovie;
	}
	
	
	
}

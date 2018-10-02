package com.xoftix.Services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.xoftix.bean.Cliente;
import com.xoftix.bean.Movie;

public class MovieService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String NAMESPACE_MAPPER = "com.xoftix.mapper.MovieMapper";
	
	public boolean guardarMovie(Movie mov){
		boolean record=true;
		try {
			SQLService.getSQLService().insert(NAMESPACE_MAPPER+".guardarMovie",mov);
			record=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
	
	public boolean editarMovie(Movie mov){
		boolean record=true;
		try {
			SQLService.getSQLService().update(NAMESPACE_MAPPER+".editarMovie",mov);
			record=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
	
	public boolean deleteMovie(String title){
		boolean record=true;
		try {
			SQLService.getSQLService().delete(NAMESPACE_MAPPER+".deleteMovie",title);
			record=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
	
	public List<Movie> findAll(Movie movie){
		List<Movie> listMovie=new ArrayList<>();
		try {
			listMovie=SQLService.getSQLService().selectList(NAMESPACE_MAPPER+".findAll", movie);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		return listMovie;
	}
	
	public Integer getStock(Long IDMovie) {
		Integer amount = 0;
		try {
			amount=SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".getStock", IDMovie);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	public int findMovieID(int IDMovie) {
		int record=-1;
		try {
			record=(int) SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".findMovieID",IDMovie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return record;
	}

}

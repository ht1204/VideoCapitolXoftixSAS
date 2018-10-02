package com.xoftix.IServicios;

import java.util.List;
import java.util.Map;
import com.xoftix.bean.Movie;

public interface IMovieServicio {
	
	//Obtener Lista de Pel�culas	
	List<Movie> findAll(Integer pagina, Integer size);
	
	List<Movie> findAllByMap(Map<String, Object> arg, Integer pagina, Integer size);
	
	//Obtener Cantidades disponibles
	Integer getStock(Long IDMovie);
	
}

package com.xoftix.Services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.xoftix.bean.Reserva;



public class ReservaService implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String NAMESPACE_MAPPER = "com.xoftix.mapper.ReservaMapper";
	
	public boolean guardarReserva(Reserva res){
		boolean record=false;
		try {
			SQLService.getSQLService().insert(NAMESPACE_MAPPER+".guardarReserva",res);
			record=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
	
	public boolean borrarReserva(long idReserva) {
		boolean record=false;
		try {
			SQLService.getSQLService().delete(NAMESPACE_MAPPER+".deleteReserva",idReserva);
			record=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return record;		
	}
	
	public Reserva findReservaId(Long IDReserve) {
		Reserva res=new Reserva();
		try {
			res=SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".findReservaId",IDReserve);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<Reserva> findReservaPorCliente(Long IDCliente){
		List<Reserva> res = new ArrayList<>();
		
		try {
			res= SQLService.getSQLService().selectList(NAMESPACE_MAPPER+".findReservaPorCliente",IDCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<Reserva> reservaLista(){
		List<Reserva> res = new ArrayList<>();
		
		try {
			res= SQLService.getSQLService().selectList(NAMESPACE_MAPPER+".reserveList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}


}

package com.xoftix.Services;

import com.xoftix.bean.Cliente;
import java.io.Serializable;

public class ClienteService implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String NAMESPACE_MAPPER = "com.xoftix.mapper.ClienteMapper";
	
	
	public boolean guardarCliente(Cliente cli){
		boolean recordCli=true;
		try {
			SQLService.getSQLService().insert(NAMESPACE_MAPPER+".guardarCliente",cli);
			recordCli=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordCli;
	}
	
	public boolean editarCliente(Cliente cli){
		boolean recordCli=true;
		try {
			SQLService.getSQLService().update(NAMESPACE_MAPPER+".editCliente",cli);
			recordCli=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordCli;
	}
	
	public boolean deleteCliente(String rut){
		boolean record=true;
		try {
			SQLService.getSQLService().delete(NAMESPACE_MAPPER+".deleteCliente",rut);
			record=true;
		} catch (Exception e) {
			e.printStackTrace();
			record=false;
		}
		return record;
	}
	
	public Cliente findClienteID(Long IDCliente) {
		Cliente cli=new Cliente();
		try {
			cli=(Cliente) SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".findClienteID",IDCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cli;
	}
	
	public int findClienteRUT(String rut) {
		int record=-1;
		try {
			record=(int) SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".findClienteRUT",rut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return record;
	}
}

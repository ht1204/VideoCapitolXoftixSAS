package com.xoftix.Services;

public class DDLService {

	private static final String NAMESPACE_MAPPER = "com.xoftix.mapper.DDLMapper";
	
	
	public void creartablas(){
		try{
			SQLService.getSQLService().insert(NAMESPACE_MAPPER+".createTable");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertUsuario(){
		try{
			SQLService.getSQLService().insert(NAMESPACE_MAPPER+".insertUsuario");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

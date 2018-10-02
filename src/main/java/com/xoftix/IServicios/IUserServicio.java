package com.xoftix.IServicios;

import com.xoftix.bean.User;

public interface IUserServicio {
	
	//	M�todo inicio sesi�n (login)
	User login(String login, String pass);
	
	//M�todo para encontrar usuario
	User findUserId(Long IDUser);
	
	//M�todo validar login
	boolean userLogin(String login);
}

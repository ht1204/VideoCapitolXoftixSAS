package com.xoftix.controller;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.xoftix.Services.DDLService;
import com.xoftix.Services.UserService;
import com.xoftix.bean.Cliente;
import com.xoftix.bean.User;

public class IndexController extends SelectorComposer<Window> {

	
	private static final long serialVersionUID = -8976153346409132968L;
	
	@Wire
	private Window winLogin;
	@Wire
	private Textbox txtUsername;
	@Wire
	private Textbox txtPassword;
	
	
	UserService userService =  new UserService();
	
	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		
		DDLService ddlService =  new DDLService();
		ddlService.creartablas();
		ddlService.insertUsuario();
	}
	
	@Listen("onClick = #btnLogin")
	public void onLogin(){
		User user = new User();
		user.setLogin(txtUsername.getText());
		user.setPass(txtPassword.getText());
		
		User userLogueado = userService.userLogin(user);
		
		if(userLogueado != null){
			alert("Usuario logueado");
			UserService us=new UserService();
			int usT=(int) us.findUserType(userLogueado.getUserName());
			System.out.println("userType: "+usT);
			if(usT==1) {
				Executions.sendRedirect("/MenuAdmin.zul");
			}else if(usT==2) {
				Executions.sendRedirect("/MenuCliente.zul");
			}

		}else{
			alert("Usuario no logueado");
		}
	}

}

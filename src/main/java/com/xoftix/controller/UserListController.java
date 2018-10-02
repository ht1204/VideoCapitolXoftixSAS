package com.xoftix.controller;

import javax.faces.render.FacesBehaviorRenderer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.xoftix.Services.UserService;
import com.xoftix.bean.User;

public class UserListController extends GenericForwardComposer {
	private static final long serialVersionUID = -8976153346409132968L;
	
	
	@Wire
	private Listbox userListBox;
	private UserService uServ;
	private User us;
	private ListModelList<User> lst;
	
	@SuppressWarnings({"rawtypes"})
	
	public void doAfterCompose(Window comp) throws Exception{
		super.doAfterCompose(comp);
		fillData();
		  userListBox.setItemRenderer(new ListitemRenderer() {
				@Override
				public void render(Listitem item, Object data, int index) throws Exception {
					User userAux=(User) data;
					String tipoUser="";
					item.appendChild(new Listcell(userAux.getUserName()));
					item.appendChild(new Listcell(userAux.getPass()));
					item.appendChild(new Listcell(userAux.getLogin()));
					if(userAux.getTipoUsuario()==1) {
						tipoUser="Administrador";
					}else {
						tipoUser="Cliente";
					}
					item.appendChild(new Listcell(tipoUser));
					item.setValue(userAux);
				}
			});
		  userListBox.setModel(new ListModelList<User>(lst));
			 
		}
		
			private void fillData(){
				uServ=new UserService();
				us=new User();
				lst=new ListModelList<User>(uServ.getAll(),true);
				
			}
	
	}
	


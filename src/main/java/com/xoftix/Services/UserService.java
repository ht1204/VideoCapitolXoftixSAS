package com.xoftix.Services;


import com.xoftix.bean.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserService implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String NAMESPACE_MAPPER = "com.xoftix.mapper.UserMapper";
	
	public boolean guardarUser(User us){
		boolean recordUser=true;
		try {
			SQLService.getSQLService().insert(NAMESPACE_MAPPER+".guardarUser",us);
			recordUser=true;
		} catch (Exception e) {
			e.printStackTrace();
			recordUser=false;
		}
		return recordUser;
	}
	
	public boolean editUser(User us){
		boolean recordUser=true;
		try {
			SQLService.getSQLService().update(NAMESPACE_MAPPER+".editUser",us);
			recordUser=true;
		} catch (Exception e) {
			e.printStackTrace();
			recordUser=false;
		}
		return recordUser;
	}
	
	public boolean deleteUser(String username){
		boolean recordUser=true;
		try {
			SQLService.getSQLService().delete(NAMESPACE_MAPPER+".deleteUser",username);
			recordUser=true;
		} catch (Exception e) {
			e.printStackTrace();
			recordUser=false;
		}
		return recordUser;
	}
	
	public User findUserId(Long IDUser) {
		User us=new User();
		try {
			us=SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".findUserId",IDUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return us;
		
	}
	
	
	public boolean userLogin(String login) {
		boolean userLog=false;
		try {
			userLog=SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".userLogin",login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userLog;
	}
	
	
	public User userLogin(User user) {
		User userLog = null;
		try {
			userLog=SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".login",user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userLog;
	}
	
	public Integer findUserType(String username){
		Integer userType=0;
		try{
			userType=SQLService.getSQLService().selectOne(NAMESPACE_MAPPER+".selectUserType",username);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userType;
	}
	
	public List<User> getAll() {
		List<User> us=new ArrayList<>();
		try {
			us=SQLService.getSQLService().selectList(NAMESPACE_MAPPER+".selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return us;
		
	}
}

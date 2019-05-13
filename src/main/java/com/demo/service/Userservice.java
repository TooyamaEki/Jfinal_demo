package com.demo.service;

import com.demo.common.model.User;

public class Userservice {
public static final Userservice me = new Userservice();
private  User dao=new User().dao();
	

public boolean add(String account,String psw) {
	
	User m=new User();
	m.set("account", account);
	m.set("psw", psw);
	m.set("create_time", "2019-05-10 21:13:56");
	return m.save();
	
	
	
}



public boolean add(User m){
	
	m.removeNullValueAttrs();
	m.keep("account","psw");
	m.set("create_time", "2019-05-10 22:13:56");
	
	
	return m.save();
}





}

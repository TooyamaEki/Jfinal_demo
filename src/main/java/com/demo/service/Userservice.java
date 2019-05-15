package com.demo.service;

import java.io.Console;
import java.util.List;

import com.demo.common.model.User;
import com.jfinal.plugin.activerecord.Record;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import sun.management.counter.Variability;

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

  
/**
 * 这里的keep是保留返回的指定字段a
 * @param accound
 * @param psw
 * @return 
 */
public Record login(String account,String psw){
Record r = get(account);
if(r!=null&&psw.equals(r.getStr("psw"))){
	r.keep("account","name","id");
	return r;
}
return null;
}

/**
 * 获取用户信息
 * @param account
 * @return
 */
public  Record get(String account){
	Record r = dao.get(account);
	return r;
}


/**
 * Record可以keep住想要的值
 * @return
 */
public List<Record> userList(){
List<Record> list = dao.list();
if(list==null){
	return list;
}
	for(Record i :list){
		i.keep("id","account","name","state");
	}
	
	return list;
	
	
	
}





}

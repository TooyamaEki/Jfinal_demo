package com.demo.common.model;

import java.util.List;

import com.demo.common.model.base.BaseUser;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	/**
	 * 问号对应db.findFirst(sql,account)里的第二个参数
	 */
	public Record get(String account){
		String sql = "SELECT * FROM `user` WHERE account = ? LIMIT 1";
		
		return Db.findFirst(sql, account);
	}
	
	
	
	public List<Record> list(){
		String sql = "SELECT * FROM `user`";
		return	Db.find(sql);
	}
}

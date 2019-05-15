package com.demo.controller;


import java.io.Console;
import java.util.List;

import com.alibaba.druid.stat.TableStat.Mode;
import com.demo.common.model.User;
import com.demo.service.Userservice;
import com.demo.validator.user.RegValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

public class UserController extends Controller{
	/**
	 * getModel(User.class, "m") 获取前端发送前缀m的值
	 */
	@Before(RegValidator.class)
	public void reg(){
//		boolean r = Userservice.me.add(getPara("account"), getPara("psw"));
		
		boolean r = Userservice.me.add(getModel(User.class, "m"));
		
			if(r){
				renderText("注册成功");
			}else{
				renderText("注册失败");
			}
		
	}
	public void login(){
		Record r= Userservice.me.login(getPara("account"), getPara("psw"));

		if(r==null){
			renderJson("账号或者密码错误");
			System.err.println(r);
		}else{
			setSessionAttr("UserInfo", r);

			renderJson(r);
		}	
	}
	public void allUser(){
	List<Record> list=Userservice.me.userList();
	renderJson(list);
	}
}

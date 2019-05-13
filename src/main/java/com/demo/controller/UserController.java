package com.demo.controller;


import com.demo.common.model.User;
import com.demo.service.Userservice;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

public class UserController extends Controller{
	/**
	 * getModel(User.class, "m") 获取前端发送前缀m的值
	 */
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
			renderJson("登陆失败");
		}else{
			renderJson(r);
		}
		
		
		
		
	}
}

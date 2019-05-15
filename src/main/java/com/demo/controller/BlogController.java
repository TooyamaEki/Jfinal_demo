package com.demo.controller;


import java.util.List;

import com.demo.service.Blogservice;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

public class BlogController extends Controller{
	public void myblog(){
		Record userInfo = getSessionAttr("UserInfo");
		System.err.println(userInfo);
	 List<Record> myblog= Blogservice.me.myList(userInfo.getInt("id"));
renderJson(myblog);
	}
}

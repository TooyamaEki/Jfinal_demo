package com.demo.service;

import java.util.List;

import com.demo.common.model.Blog;
import com.jfinal.plugin.activerecord.Record;

public class Blogservice {

public static final Blogservice me = new Blogservice();
private Blog dao = new Blog().dao();

	
	public List<Record> myList(int id){
		List<Record> list=	dao.get(id);
		return list;
		
	}
	
	
}

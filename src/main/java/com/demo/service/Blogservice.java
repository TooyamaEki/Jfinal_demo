package com.demo.service;

import java.io.Console;
import java.util.List;

import com.demo.common.model.Blog;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class Blogservice {

public static final Blogservice me = new Blogservice();
private Blog dao = new Blog().dao();

	
	public Page<Record> myList(int id){
		
		
		 Page<Record> r=dao.get(id);
		 System.err.println(r);
		return null;
			

		
	}
	
	
}

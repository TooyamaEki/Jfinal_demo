package com.demo.common;

import com.demo.controller.UserController;
import com.jfinal.config.Routes;

public class UserRoutes extends Routes{

	@Override
	public void config() {
		// TODO Auto-generated method stub
		add("/user",UserController.class);
	}

}

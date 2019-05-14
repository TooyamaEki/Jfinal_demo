package com.demo.validator.user;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.sun.org.apache.regexp.internal.recompile;

public class RegValidator extends Validator{
/**
 * 正常校验逻辑
 */
	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		
		
//		validateRegex("account", "^[1-9]\d*$", "20047", "号码长度不够");
//		validateRegex(field, regExpression, errorKey, errorMessage);
	
		this.setShortCircuit(true);
		validateInteger("account", "10092", "请输入数字");
//		String s=c.getPara("account");
//		if(s.length()<=10){
//			addError("10086", "长度不够");
//		}
		
		

	}
/**
 * 校验异常
 */
	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.renderJson();
	}


}

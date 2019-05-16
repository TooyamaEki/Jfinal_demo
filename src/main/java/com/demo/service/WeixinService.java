package com.demo.service;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;

public class WeixinService {
	private static String DDAPIURL = "https://api.weixin.qq.com/cgi-bin/token";
	public static String afterScenceBindQrcodeCode(String appid,String secret){

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("grant_type", "client_credential");
		paramMap.put("appid", appid);
		paramMap.put("secret", secret);
		String postUrl = DDAPIURL;
//		String postUrl = DDAPIURL+"/test/afterScenceBindQrcodeCode";
		String result = HttpUtil.get(postUrl, paramMap);
		System.err.println("微信的接口地址为:\n"+postUrl);
		System.err.println("微信2流量主通知账号的接口地址参数为:\n"+paramMap.toString());
		System.err.println("微信3流量主通知账号的接口返回值为:\n"+result);
		return result;
	}

	
	public static String weixinPOST(String accessToken){
		String postUrl="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
		
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_list", "[{'openid': 'o7TbM5tefSsO-sOvuqOmnj3FKd28', 'lang': 'zh_CN'}, {'openid': 'o7TbM5uKnSzsBfbsFbF8B6zk7xAE', 'lang': 'zh_CN'}]");
		JSONObject json = new JSONObject(paramMap);
        HttpRequest hutoolReq = new HttpRequest(postUrl+accessToken);
        hutoolReq.body(json.toJSONString());
        hutoolReq.method(Method.POST);
        return hutoolReq.execute().body();
	}

}







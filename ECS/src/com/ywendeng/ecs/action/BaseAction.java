package com.ywendeng.ecs.action;


import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public  abstract class BaseAction extends ActionSupport {
	//声明一个用于存储用户提示消息的Map 
    Map<String, Boolean> megMap;
   
   
	public String jsonString(Object map) throws Exception{
		 ObjectMapper jsonMapper=new ObjectMapper();
		 //将jsonMapper转换为Json字符串
		 String jsonString=jsonMapper.writeValueAsString(map);
		
		 HttpServletResponse  response=ServletActionContext.getResponse();
		 response.setContentType("text/json;charset=UTF-8");
		
		 response.getWriter().println(jsonString);
		 //输出形成的json数据格式
		
		return null;
		
	}
}

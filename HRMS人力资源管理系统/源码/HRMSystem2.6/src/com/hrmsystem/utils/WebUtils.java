package com.hrmsystem.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/*
 * 该类的主要功能是封装客户端提交的表单数据到fromBean中
 */

public class WebUtils {
  
	/*
	 * 将request 对象转换为T对象
	 */
	@SuppressWarnings("unchecked")
	public static <T>T requestToBean(HttpServletRequest request, Class<T>class1){
		 try{
			 //声明当前运行时类 实例
			 T bean=class1.newInstance();
			 //获取当前request 中的所有属性
			 Enumeration<String> enumeration=request.getParameterNames();
			 //遍历取出属性值 ,将其封装为 运行时类对象
			 while (enumeration.hasMoreElements()) {
				String name = (String) enumeration.nextElement();
				String  value=request.getParameter(name).trim();
				BeanUtils.setProperty(bean, name, value);
			}
			 return bean;
		 }catch(Exception  e){
			 throw new RuntimeException(e);
			 
		 }
	}
	
}

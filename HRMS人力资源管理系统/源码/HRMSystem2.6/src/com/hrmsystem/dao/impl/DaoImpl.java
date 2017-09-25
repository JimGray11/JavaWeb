package com.hrmsystem.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hrmsystem.dao.Dao;
import com.hrmsystem.utils.ReflectionUtils;


public class DaoImpl<T> implements Dao<T> {
    QueryRunner queryRunner=null;
    Class<T> type;
    //① 在构造器 初始化变量 同时获取泛型T的具体类型
    public DaoImpl(){
    	queryRunner=new QueryRunner();
    	//this.getClass()是具体继承该类的子类 的类对象
    	type=ReflectionUtils.getSuperGenericType(this.getClass());
    
    }
    
	@Override
	public T getObject(Connection connection, String sql, Object...args) {
		
		T entity=null;
		try {
			entity=queryRunner.query(connection, sql, new BeanHandler<T>(type),args);
			
		} catch (Exception e) {
	      e.printStackTrace();
		}
		return entity;
	}

	@Override
	public List<T> getListObject(Connection connection, String sql,
			Object... args) {
		List<T> list=null;
		try {
			 list=queryRunner.query(connection, sql, new BeanListHandler<T>(type),args);
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return list;
	}

	@Override
	public <E> E getRowCount(Connection connection, String sql) {
		E rowCount= null;
		try {
			rowCount=queryRunner.query(connection, sql, new ScalarHandler<E>());
		} catch (SQLException e) {
		    System.out.println("统计数据记录时出现错误");
			
		}
		return rowCount;
	}

	@Override
	public boolean  updateDataRecord(Connection connection, String sql,
			Object... args) {
		try {
			queryRunner.update(connection, sql, args);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}



}

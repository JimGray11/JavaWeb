package com.hrmsystem.dao;

import java.sql.Connection;
import java.util.List;
   //数据库的连接


public interface Dao<T> {
    //①查询数据库 ,并返回一个数据对象
	T getObject(Connection connection,String sql,Object...args);
	
	//② 查询数据库中的所有数据 
	List<T> getListObject(Connection connection,String sql,Object...args);
	
	//③ 返回数据库中总的数据条数
	<E>E  getRowCount(Connection connection,String sql);
	
	//④ 对数据库增、删、改 操作
	boolean updateDataRecord(Connection connection,String sql,Object...args);

}

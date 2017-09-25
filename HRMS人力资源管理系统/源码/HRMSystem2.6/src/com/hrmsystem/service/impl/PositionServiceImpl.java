package com.hrmsystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.hrmsystem.dao.impl.PositionsImpl;
import com.hrmsystem.domain.Positions;
import com.hrmsystem.service.PositionService;
import com.hrmsystem.utils.DbUtils;

public class PositionServiceImpl  implements  PositionService {
    PositionsImpl positionsImpl;
    Connection  connection;
    public PositionServiceImpl(){
    	positionsImpl=new PositionsImpl();
    	connection=DbUtils.getConnection();
    }
	@Override
	public List<Positions> getAllPostions() {
	    String  indexSql="select id,position_name as name,taskDesc from positions";
	    //获取数据库中的所有岗位信息
	    List<Positions> list= positionsImpl.getListObject(connection, indexSql);
	   
		return list;
	}
	//插入岗位信息 
	@Override
	public Boolean savePositionInfo(Positions position) {
		String insertSql="insert into positions(id,position_name,taskdesc)values(position_id.nextVal,?,?)";
         Boolean b= positionsImpl.updateDataRecord(connection, insertSql,position.getName(),position.getTaskDesc());
		return b;
	}
	//删除数据库中的数据记录
	@Override
	public  Boolean deletePositionInfo(String postName) {
		String deleteSql="delete positions where POSITION_NAME=?";
		Boolean b=positionsImpl.updateDataRecord(connection,deleteSql, postName);
		return b ;
		
		
	}

}

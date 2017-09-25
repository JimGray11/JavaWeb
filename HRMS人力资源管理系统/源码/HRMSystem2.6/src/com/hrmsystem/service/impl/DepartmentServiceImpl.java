package com.hrmsystem.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hrmsystem.dao.impl.DeparmentsShowImpl;
import com.hrmsystem.dao.impl.DepartmentsImpl;
import com.hrmsystem.domain.DeparmentsShow;
import com.hrmsystem.domain.Departments;
import com.hrmsystem.service.DepartmentService;
import com.hrmsystem.utils.DbUtils;

public class DepartmentServiceImpl implements DepartmentService {
   //声明操作数据库的对象
	DepartmentsImpl departmentsImpl;
	DeparmentsShowImpl deparmentsShow;
	Connection  connection;
	
	public DepartmentServiceImpl(){
		departmentsImpl=new DepartmentsImpl();
		connection=DbUtils.getConnection();
		deparmentsShow=new DeparmentsShowImpl();
	}
	@Override
	public Boolean saveDepartmentInfo(Departments department) {
		 //创建 向数据库表中插入数据的语句
		String  insertSql="insert into departments(id,depName,parentId,taskDesc)values(department_id.nextVal,?,?,?)";
		//向数据库中插入数据
		 Boolean boolean1=departmentsImpl.updateDataRecord(connection, insertSql, department.getDepName(),department.getParentId(),department.getTaskDesc());
		
		return boolean1;
		
	}
	@Override
	public List<DeparmentsShow> getAllDeparmentsShows() {
		//查询数据库的sql 语句
		List<DeparmentsShow> list=new ArrayList<DeparmentsShow>();
		String indexSql="select a.depName,b.depName as parentName,a.taskDesc from departments a," +
				"departments b where a.parentId=b.Id";
		
		list=deparmentsShow.getListObject(connection, indexSql);
		//返回从数据库中查询到的部门集合
		
		return list;
	}
	public Boolean deleteDepRecord(String delName) {
		String deleteSql="delete from  departments  where parentId in(select Id from departments where DEPNAME=?)";
		Boolean boolean1=deparmentsShow.updateDataRecord(connection, deleteSql, delName);
		
		
		return  boolean1;
		
	}
	@Override
	public  List<Departments>  getAllDepRelation() {
		String  indexAllSql="select*from departments";
		List<Departments> depList=departmentsImpl.getListObject(connection, indexAllSql);
		
		return depList;
	}

}

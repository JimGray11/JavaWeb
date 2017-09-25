package com.hrmsystem.service;


import java.util.List;

import com.hrmsystem.domain.DeparmentsShow;
import com.hrmsystem.domain.Departments;

public interface DepartmentService {
	/*
	 * 将新建的部门保存到数据库
	 */
    Boolean saveDepartmentInfo(Departments department);
    
    /*
     * 查询数据库中的所有部门信息
     */
   List<DeparmentsShow> getAllDeparmentsShows();
   /*
    * 删除数据库中的部门记录
    */
    Boolean deleteDepRecord(String delName);
   /*
    * 获取部门部门中id 和parentId
    */
    List<Departments> getAllDepRelation();
    
}

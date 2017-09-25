package com.hrmsystem.service;

import java.util.List;

import com.hrmsystem.domain.Positions;

public interface PositionService {
   /*
    * 获取数据库中的岗位表
    */
	List<Positions> getAllPostions();
	/*
	 * 保存岗位信息
	 */
	Boolean savePositionInfo(Positions position);
	/*
	 * 删除数据库中的数据记录
	 */
	Boolean deletePositionInfo(String postName);
}

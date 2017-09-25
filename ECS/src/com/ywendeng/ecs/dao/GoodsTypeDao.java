package com.ywendeng.ecs.dao;

import java.util.List;

import com.ywendeng.ecs.domain.OneGoodsType;

public interface GoodsTypeDao {
  /*
   * 获取所有的目录
   */
	public List<OneGoodsType> getAllOneGoodsType();
}

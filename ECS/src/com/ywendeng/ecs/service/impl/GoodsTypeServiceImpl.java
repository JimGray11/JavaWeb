package com.ywendeng.ecs.service.impl;

import java.util.List;

import com.ywendeng.ecs.dao.GoodsTypeDao;
import com.ywendeng.ecs.domain.OneGoodsType;
import com.ywendeng.ecs.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements  GoodsTypeService{
   GoodsTypeDao  goodsTypeDao;
	@Override
	public List<OneGoodsType> getAllOneGoodsType() {
		 
		return goodsTypeDao.getAllOneGoodsType();
	}
	
	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}
  
}

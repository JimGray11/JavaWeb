package com.ywendeng.ecs.service.impl;

import java.util.List;

import com.ywendeng.ecs.dao.CategoryDao;
import com.ywendeng.ecs.domain.OneGoodsType;
import com.ywendeng.ecs.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao  categoryDao;
	@Override
	public List<OneGoodsType> findAllOneGoodsType() {
	
		return categoryDao.findAllOneGoodsType();
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	@Override
	public void delete(OneGoodsType oneGoodsType) {
		categoryDao.delete(oneGoodsType);
		
	}
	@Override
	public void save(OneGoodsType oneGoodsType) {
		
		categoryDao.save(oneGoodsType);
		
	}
	@Override
	public OneGoodsType findOneGoodsType(String oid) {
		
		return categoryDao.findOneGoodsType(oid);
	}
	@Override
	public void update(OneGoodsType oneGoodsType) {
		categoryDao.update(oneGoodsType);
		
	}
	
   
}

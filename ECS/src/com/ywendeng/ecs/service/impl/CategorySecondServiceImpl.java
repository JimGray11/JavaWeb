package com.ywendeng.ecs.service.impl;

import java.util.List;

import com.ywendeng.ecs.dao.CategorySecondDao;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.service.CategorySecondService;
import com.ywendeng.ecs.utils.PageBean;

public class CategorySecondServiceImpl implements CategorySecondService {
	 CategorySecondDao categorySecondDao;
	 
	 

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}



	@Override
	public PageBean<TwoGoodsType> findTwoGoodsType(int page) {
		PageBean<TwoGoodsType> pageBean=new PageBean<>();
		//获取二级分类总的数据记录条数
		int total=categorySecondDao.getCount();
		//设置每页显示的数据记录条数
		int limit=15;
		if(total%limit==0){
			pageBean.setTotalPage(total/limit);
		}else{
			pageBean.setTotalPage(total/limit+1);
		}
		int begin=(page-1)*limit;
				
		List<TwoGoodsType> twoTypeList=categorySecondDao.getTwoGoodsTypeByPage(begin,limit);
		
		pageBean.setList(twoTypeList);
		pageBean.setPage(page);
	   
		return pageBean;
	}



	@Override
	public List<TwoGoodsType> getTwoGoodsTyeByOid(String oid) {
		
		return categorySecondDao.getTwoGoodsTyeByOid(oid);
	}


	@Override
	public void save(TwoGoodsType twoGoodsType) {
	  categorySecondDao.save(twoGoodsType);
		
	}



	@Override
	public void delete(TwoGoodsType twoGoodsType) {
		categorySecondDao.delete(twoGoodsType);
		
	}



	@Override
	public TwoGoodsType getTwoGoodsType(String tid) {
		
		return categorySecondDao.getTwoGoodsType(tid);
	}



	@Override
	public void update(TwoGoodsType twoGoodsType) {
		 categorySecondDao.update(twoGoodsType);
		
	}



}

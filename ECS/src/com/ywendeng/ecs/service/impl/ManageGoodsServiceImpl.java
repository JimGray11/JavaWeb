package com.ywendeng.ecs.service.impl;

import java.util.List;

import com.ywendeng.ecs.dao.ManageGoodsDao;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.service.ManageGoodsService;
import com.ywendeng.ecs.utils.PageBean;

public class ManageGoodsServiceImpl implements ManageGoodsService {
	ManageGoodsDao manageGoodsDao;
	

	public void setManageGoodsDao(ManageGoodsDao manageGoodsDao) {
		this.manageGoodsDao = manageGoodsDao;
	}

	@Override
	public PageBean<Goods> findAllGoods(int page) {
		PageBean<Goods> pageBean=new PageBean<>();
		//获取二级分类总的数据记录条数
		int total=manageGoodsDao.getCount();
		//设置每页显示的数据记录条数
		int limit=10;
		if(total%limit==0){
			pageBean.setTotalPage(total/limit);
		}else{
			pageBean.setTotalPage(total/limit+1);
		}
		int begin=(page-1)*limit;
				
		List<Goods> gList=manageGoodsDao.findAllGoods(begin,limit);
		
		pageBean.setList(gList);
		pageBean.setPage(page);
	   
		return pageBean;
	}


	@Override
	public void delete(Goods goods) {
	
		manageGoodsDao.delete(goods);
	}
	
	
	
	

}

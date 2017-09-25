package com.ywendeng.ecs.service.impl;

import java.util.List;

import com.ywendeng.ecs.dao.GoodsDao;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.service.GoodsService;
import com.ywendeng.ecs.utils.PageBean;

public class GoodsServiceImpl implements  GoodsService{
	GoodsDao  goodsDao;

	@Override
	public List<Goods> getGoodsMostLower() {
		
		return goodsDao.getGoodsMostLower();
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public List<Goods> getLatest() {
		
		return goodsDao.getLatest();
	}
   
	@Override
	public List<Goods> getHotGoods() {
		
		return goodsDao.getHotGoods();
	}

	@Override
	public Goods findByGid(String gid) {
		
		return goodsDao.findByGid(gid);
	}
	//带有分页的对数据进行查询
	@Override
	public PageBean<Goods> getAllGoodsBytwoType(String tid, int page) {
		PageBean<Goods> pageBean=new PageBean<>();
		//在此进行义务逻辑处理
		//① 获取商品的总页数
		int total=goodsDao.getCount(tid);
		//②设置每页数据记录的条数
		int pageSize=6;
		//③ 计算总页数
		int totalPage=0;
		
		if(total%pageSize==0){
			totalPage=total/pageSize;
		}else{
			totalPage=total/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置当前页
		pageBean.setPage(page);
		//④ 获取该页相应的数据集合
		     //计算开始的数据记录条数 
		 int begin=(page-1)*pageSize;
		 
		List<Goods> list=goodsDao.getAllGoodsBytwoType(tid, begin, pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void save(Goods goods) {
		goodsDao.save(goods);
		
	}

	@Override
	public PageBean<Goods> findByName(String goodsName,int page) {
		PageBean<Goods> pageBean=new PageBean<>();
		//在此进行义务逻辑处理
		//① 获取商品的总页数
		int total=goodsDao.getCountByName(goodsName);
		//②设置每页数据记录的条数
		int pageSize=6;
		//③ 计算总页数
		int totalPage=0;
		
		if(total%pageSize==0){
			totalPage=total/pageSize;
		}else{
			totalPage=total/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置当前页
		pageBean.setPage(page);
		//④ 获取该页相应的数据集合
		     //计算开始的数据记录条数 
		 int begin=(page-1)*pageSize;
		 
		List<Goods> list=goodsDao.findByName(goodsName, begin, pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void update(Goods goods) {
		goodsDao.update(goods);
		
	}

	
}

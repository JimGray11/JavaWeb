package com.ywendeng.ecs.service;

import java.util.List;

import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.utils.PageBean;

public interface GoodsService {
	   /*
	    * 获取所有商品中最便宜的三件商品
	    */
		public List<Goods> getGoodsMostLower();
		/*
		 * 获取最新商品
		 */
		public List<Goods> getLatest();
		/*
		 * 获取取热卖的产品
		 */
		public List<Goods> getHotGoods();
		/*
		 * 根据Id值查询到商品信息
		 */
		public Goods findByGid(String gid);
		/*
		 * 根据商品类型的id值获取得当前页商品
		 */
		PageBean<Goods> getAllGoodsBytwoType(String tid, int page);
		/*
		 * 保存商品信息
		 */
		public void save(Goods goods);
		
		public PageBean<Goods> findByName(String goodsName, int page);
		
		public void update(Goods goods);
}

package com.ywendeng.ecs.dao;

import java.util.List;

import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.utils.PageBean;

public interface GoodsDao {
   /*
    * 获取所有商品中最便宜的三件商品
    */
	public List<Goods> getGoodsMostLower();
	/*
	 * 获取最新产品
	 */

	public List<Goods> getLatest();
    /*
     * 获取热售商品
     */
	public List<Goods> getHotGoods();

	public Goods findByGid(String gid);

	List<Goods> getAllGoodsBytwoType(String tid, int begin, int pageSize);
	/*
	 * 根据tid获取该类商品总的记录条数
	 */
	 public int getCount(String tid);

	public void save(Goods goods);

	public List<Goods> findByName(String goodsName, int begin, int pageSize);

	public int getCountByName(String goodsName);

	public void update(Goods goods);
}

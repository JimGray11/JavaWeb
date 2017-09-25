package com.ywendeng.ecs.dao;

import java.util.List;

import com.ywendeng.ecs.domain.TwoGoodsType;

public interface CategorySecondDao {
	/*
	 * 获取数据记录总的数据记录条数
	 */
	int getCount();
    /*
     * 获取当前页的数据
     */
	List<TwoGoodsType> getTwoGoodsTypeByPage(int begin, int limit);
	
	void save(TwoGoodsType twoGoodsType);
	
	void delete(TwoGoodsType twoGoodsType);
	
	TwoGoodsType getTwoGoodsType(String tid);
	
	
	void update(TwoGoodsType twoGoodsType);
	/*
	 * 根据一级分类来获取二级分类
	 */
	List<TwoGoodsType> getTwoGoodsTyeByOid(String oid);

}

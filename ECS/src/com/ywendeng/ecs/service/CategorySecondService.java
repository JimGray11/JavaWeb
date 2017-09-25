package com.ywendeng.ecs.service;

import java.util.List;

import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.utils.PageBean;

public interface CategorySecondService {
	/*
	 * 查询当前页的信息
	 */

	PageBean<TwoGoodsType> findTwoGoodsType(int page);

	void save(TwoGoodsType twoGoodsType);

	void delete(TwoGoodsType twoGoodsType);

	TwoGoodsType getTwoGoodsType(String tid);

	void update(TwoGoodsType twoGoodsType);
	/*
	 * 根据一级分类来获取二级分类
	 */

	List<TwoGoodsType> getTwoGoodsTyeByOid(String oid);


}

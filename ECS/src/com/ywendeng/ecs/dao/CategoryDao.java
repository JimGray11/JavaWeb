package com.ywendeng.ecs.dao;

import java.util.List;

import com.ywendeng.ecs.domain.OneGoodsType;

public interface CategoryDao {
	/*
	 * 查找出所有的一级分类
	 */
	public List<OneGoodsType> findAllOneGoodsType();
	/*
	 * 删除一级目录
	 */

	public void delete(OneGoodsType oneGoodsType);
	/*
	 * 添加一级商品目录
	 */
	public void save(OneGoodsType oneGoodsType);

	public OneGoodsType findOneGoodsType(String oid);

	public void update(OneGoodsType oneGoodsType);

}

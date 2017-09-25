package com.ywendeng.ecs.dao;

import java.util.List;

import com.ywendeng.ecs.domain.Goods;

public interface ManageGoodsDao {

	int getCount();

	List<Goods> findAllGoods(int begin, int limit);

	void delete(Goods goods);
    
}

package com.ywendeng.ecs.service;

import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.utils.PageBean;

public interface ManageGoodsService {

	PageBean<Goods> findAllGoods(int page);

	void delete(Goods goods);

}

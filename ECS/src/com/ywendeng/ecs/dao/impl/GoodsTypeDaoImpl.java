package com.ywendeng.ecs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ywendeng.ecs.dao.GoodsTypeDao;
import com.ywendeng.ecs.domain.OneGoodsType;

public class GoodsTypeDaoImpl extends HibernateDaoSupport implements GoodsTypeDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<OneGoodsType> getAllOneGoodsType() {
		
		return this.getHibernateTemplate().find("from OneGoodsType");
	}

}

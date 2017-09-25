package com.ywendeng.ecs.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ywendeng.ecs.dao.CategoryDao;
import com.ywendeng.ecs.domain.OneGoodsType;

public class CategoryImpl extends HibernateDaoSupport implements CategoryDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<OneGoodsType> findAllOneGoodsType() {
		
		return this.getHibernateTemplate().find("from OneGoodsType");
	}

	@Override
	public void delete(OneGoodsType oneGoodsType) {
	 this.getHibernateTemplate().delete(oneGoodsType);
		
	}

	@Override
	public void save(OneGoodsType oneGoodsType) {
		
		this.getHibernateTemplate().save(oneGoodsType);
		
	}

	@Override
	public OneGoodsType findOneGoodsType(String oid) {
		DetachedCriteria  criteria=DetachedCriteria.forClass(OneGoodsType.class);
		 criteria.add(Restrictions.idEq(oid));
		 
		return  (OneGoodsType) this.getHibernateTemplate().findByCriteria(criteria).get(0) ;
	}

	@Override
	public void update(OneGoodsType oneGoodsType) {
		this.getHibernateTemplate().update(oneGoodsType);
		
	}

}

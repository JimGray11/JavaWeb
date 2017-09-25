package com.ywendeng.ecs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ywendeng.ecs.dao.ManageGoodsDao;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.utils.PageHibernateCallback;

public class ManageGoodsDaoImpl extends HibernateDaoSupport implements ManageGoodsDao {

	@Override
	public int getCount() {
		   String hql="select count(*) from Goods";
		   @SuppressWarnings("unchecked")
		  List<Long> list=this.getHibernateTemplate().find(hql);
		   if(list!=null&&list.size()>0){
			  return  list.get(0).intValue();
		   }
			return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findAllGoods(int begin, int limit) {
		String  hql="from Goods order by pdate desc";
		return (List<Goods>) this.getHibernateTemplate().execute(new PageHibernateCallback<Goods>(hql, null, begin, limit));
	}

	@Override
	public void delete(Goods goods) {
		this.getHibernateTemplate().delete(goods);
		
	}

}

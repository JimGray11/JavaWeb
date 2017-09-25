package com.ywendeng.ecs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ywendeng.ecs.dao.CategorySecondDao;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.utils.PageHibernateCallback;

public class CategorySecondDaoImpl extends HibernateDaoSupport  implements CategorySecondDao{

	@SuppressWarnings("unchecked")
	@Override
	public int getCount() {
	   String hql="select count(*) from TwoGoodsType";
	   List<Long> list=this.getHibernateTemplate().find(hql);
	   if(list!=null&&list.size()>0){
		  return  list.get(0).intValue();
	   }
	   
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TwoGoodsType> getTwoGoodsTypeByPage(int begin, int limit) {
		String  hql="from TwoGoodsType order by tid desc";
		return (List<TwoGoodsType>) this.getHibernateTemplate().execute(new PageHibernateCallback<TwoGoodsType>(hql, null, begin, limit));
	}

	@Override
	public void save(TwoGoodsType twoGoodsType) {
		this.getHibernateTemplate().save(twoGoodsType);
		
	}

	@Override
	public void delete(TwoGoodsType twoGoodsType) {
		this.getHibernateTemplate().delete(twoGoodsType);
		
	}

	@Override
	public TwoGoodsType getTwoGoodsType(String tid) {
		DetachedCriteria  criteria=DetachedCriteria.forClass(TwoGoodsType.class);
		criteria.add(Restrictions.idEq(tid));
		return   (TwoGoodsType) this.getHibernateTemplate().findByCriteria(criteria).get(0) ;
	}

	@Override
	public void update(TwoGoodsType twoGoodsType) {
		this.getHibernateTemplate().update(twoGoodsType);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TwoGoodsType> getTwoGoodsTyeByOid(final String oid) {
		
		return (List<TwoGoodsType>) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery("from TwoGoodsType t where t.oneGoodsType.oid=? ")
						.setParameter(0, oid)
						.list();
			}
		});
	}

}

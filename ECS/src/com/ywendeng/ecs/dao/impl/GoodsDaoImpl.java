package com.ywendeng.ecs.dao.impl;

import java.sql.SQLException;
import java.util.List;import org.apache.struts2.components.Head;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.puppycrawl.tools.checkstyle.checks.javadoc.PackageHtmlCheck;
import com.ywendeng.ecs.dao.GoodsDao;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.utils.PageBean;
import com.ywendeng.ecs.utils.PageHibernateCallback;

public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao {

	@Override
	public List<Goods> getGoodsMostLower() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		criteria.addOrder(Order.asc("price"));
		@SuppressWarnings("unchecked")
		List<Goods> lowList=this.getHibernateTemplate().findByCriteria(criteria,0,3);
		
		return lowList;
	}

	@Override
	public List<Goods> getLatest() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		criteria.addOrder(Order.desc("pdate"));
		@SuppressWarnings("unchecked")
		List<Goods> lowList=this.getHibernateTemplate().findByCriteria(criteria,0,3);
		
		return lowList;
	}

	@Override
	public List<Goods> getHotGoods() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Goods.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.asc("pdate"));
		@SuppressWarnings("unchecked")
		List<Goods> hotList=this.getHibernateTemplate().findByCriteria(criteria,0,2);
		
		return hotList;
	}

	@Override
	public Goods findByGid(final String gid) {
		return  (Goods) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				return session.createQuery("from Goods where gid=?")
						.setParameter(0, gid)
						.uniqueResult();
			}
		});
	}

	@Override
	public List<Goods> getAllGoodsBytwoType(String tid, int begin,int pageSize ) {
		 //需要在此设置pageBean的相关信息
		String hql="from Goods where tid=?";
		@SuppressWarnings("unchecked")
		List<Goods> glist=(List<Goods>) this.getHibernateTemplate().execute(new PageHibernateCallback<Goods>(hql,new Object[]{tid},begin, pageSize));
		
		if(glist != null && glist.size() > 0){
			return glist;
		}
		return null;
	}
	
	
	/*
	 * 根据tid 查询商品的总的记录数
	 */
	public int getCount(String tid){
		String  hql="select count(*) from Goods where tid=?";
		@SuppressWarnings("unchecked")
		List<Long> list=this.getHibernateTemplate().find(hql, tid);
		if(list!=null&&list.size()>0){
		  return list.get(0).intValue();
		}
		return 0;
		
	}

	@Override
	public void save(Goods goods) {
		this.getHibernateTemplate().save(goods);
		
	}

	@Override
	public List<Goods> findByName(String goodsName, int begin, int pageSize) {
		 //需要在此设置pageBean的相关信息
		String hql="from Goods where name like '%"+goodsName+"%'";
		@SuppressWarnings("unchecked")
		List<Goods> glist=(List<Goods>) this.getHibernateTemplate().execute(new PageHibernateCallback<Goods>(hql,null,begin, pageSize));
		
		if(glist != null && glist.size() > 0){
			return glist;
		}
		return null;
	}

	@Override
	public int getCountByName(String goodsName) {
		String  hql="select count(*) from Goods where name like '%"+goodsName+"%'";
		@SuppressWarnings("unchecked")
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
		  return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void update(Goods goods) {
		
		this.getHibernateTemplate().update(goods);
		
	}

}

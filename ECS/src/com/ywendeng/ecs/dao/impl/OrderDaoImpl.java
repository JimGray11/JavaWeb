package com.ywendeng.ecs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.istack.internal.FinalArrayList;
import com.ywendeng.ecs.dao.OrderDao;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.domain.Orders;
import com.ywendeng.ecs.utils.PageHibernateCallback;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {


	@Override
	public void saveOrder(Orders order) {
		   this.getHibernateTemplate().save(order);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> findAllOrder(final String uid) {
		
		return (List<Orders>) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				return session.createQuery("from Orders where uid=?")
						.setParameter(0, uid)
						.list();
			}
		});
	}

	@Override
	public Orders findOrderById( final  String orid) {
	return (Orders) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				return session.createQuery("from Orders where orid=?")
						.setParameter(0, orid)
						.uniqueResult();
						
			}
		});
	}

	@Override
	public void updateOrder(Orders curOrder) {
		this.getHibernateTemplate().save(curOrder);
		
	}

	@Override
	public int getCount() {
		 String hql="select count(*) from Orders";
		   @SuppressWarnings("unchecked")
		  List<Long> list=this.getHibernateTemplate().find(hql);
		   if(list!=null&&list.size()>0){
			  return  list.get(0).intValue();
		   }
			return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getAllOrder(int begin, int limit) {
		String  hql="from Orders order by ordertime desc";
		return (List<Orders>) this.getHibernateTemplate().execute(new PageHibernateCallback<Goods>(hql, null, begin, limit));
	}

}

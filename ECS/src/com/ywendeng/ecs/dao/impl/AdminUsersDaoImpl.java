package com.ywendeng.ecs.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ywendeng.ecs.dao.AdminUsersDao;
import com.ywendeng.ecs.domain.AdminUsers;

public class AdminUsersDaoImpl extends HibernateDaoSupport implements AdminUsersDao {

	@Override
	public AdminUsers login(final AdminUsers adminUsers) {
		final String hql="from AdminUsers where userName=? and password=?";
		
		return (AdminUsers) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				return session.createQuery(hql)
						.setParameter(0, adminUsers.getUserName())
						.setParameter(1, adminUsers.getPassword())
						.uniqueResult();
			}
		});
	}

}

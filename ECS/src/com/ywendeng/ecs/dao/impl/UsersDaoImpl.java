package com.ywendeng.ecs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ywendeng.ecs.dao.UsersDao;
import com.ywendeng.ecs.domain.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {

	@Override
	public Users getUserName(String userName) {
		String hql="from Users where userName=?";
		@SuppressWarnings("unchecked")
		List<Users> list=this.getHibernateTemplate().find(hql, userName);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void save(Users user) {
		this.getHibernateTemplate().save(user);
		
	}

	@Override
	public Users login(final Users user) {
		
		return (Users) this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Users doInHibernate(Session session) throws HibernateException, SQLException {
				
				return (Users) session.createQuery("from Users where userName=? and password=?")
						.setParameter(0, user.getUserName())
						.setParameter(1, user.getPassword())
						.uniqueResult();
			}
		});
	}

	@Override
	public Users getUserByStateCode(final String stateCode) {
		
		return (Users) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				return session.createQuery("from Users where stateCode=?")
						.setParameter(0, stateCode)
						.uniqueResult();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAllUser() {
		
		return this.getHibernateTemplate().find("from Users");
	}

	@Override
	public void deleteUserById(Users user) {
       this.getHibernateTemplate().delete(user);
	}
   
}

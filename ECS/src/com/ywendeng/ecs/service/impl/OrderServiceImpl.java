package com.ywendeng.ecs.service.impl;



import java.util.List;

import com.ywendeng.ecs.dao.OrderDao;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.domain.Orders;
import com.ywendeng.ecs.service.OrderService;
import com.ywendeng.ecs.utils.PageBean;

public class OrderServiceImpl implements OrderService {
	OrderDao  orderDao;

	@Override
	public void saveOrder(Orders order) {
		orderDao.saveOrder(order);
	}
	

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	@Override
	public List<Orders> findAllOrder(String uid) {
	
		return orderDao.findAllOrder(uid);
	}


	@Override
	public Orders findOrderById(String orid) {
		
		return orderDao.findOrderById(orid);
	}


	@Override
	public void updateOrder(Orders curOrder) {
		
		orderDao.updateOrder(curOrder);
		
	}


	@Override
	public PageBean<Orders> getAllOrder(int page) {
		PageBean<Orders> pageBean=new PageBean<>();
		//获取二级分类总的数据记录条数
		int total=orderDao.getCount();
		//设置每页显示的数据记录条数
		int limit=10;
		if(total%limit==0){
			pageBean.setTotalPage(total/limit);
		}else{
			pageBean.setTotalPage(total/limit+1);
		}
		int begin=(page-1)*limit;
				
		List<Orders> gList=orderDao.getAllOrder(begin,limit);
		
		pageBean.setList(gList);
		pageBean.setPage(page);
	   
		return pageBean;
	}
    
}

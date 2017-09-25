package com.ywendeng.ecs.service;


import java.util.List;

import com.ywendeng.ecs.domain.Orders;
import com.ywendeng.ecs.utils.PageBean;

public interface OrderService {
  /*
   * 保存订单
   */
	public  void  saveOrder(Orders order);
	/*
	 * 根据用户id值获取当前的所有订单
	 */

	public List<Orders> findAllOrder(String uid);
	/*
	 * 根据订单的Id号查询订单
	 */

	public Orders findOrderById(String orid);
	/*
	 * 更新订单信息
	 */

	public void updateOrder(Orders curOrder);

	public PageBean<Orders> getAllOrder(int page);
}

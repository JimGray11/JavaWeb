package com.ywendeng.ecs.dao;

import java.util.List;

import com.ywendeng.ecs.domain.Orders;

public interface OrderDao {
  
	/*
	 * 保存订单
	 */
	public void saveOrder(Orders order);
	/*
	 *更加用户id获取所有的订单
	 */

	public List<Orders> findAllOrder(String uid);
	/*
	 * 根据订单id号查询订单
	 */
	public Orders findOrderById(String orid);
	/*
	 * 更新订单
	 */

	public void updateOrder(Orders curOrder);

	public int getCount();

	public List<Orders> getAllOrder(int begin, int limit);
}

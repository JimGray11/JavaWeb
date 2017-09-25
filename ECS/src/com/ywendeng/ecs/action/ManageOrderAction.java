package com.ywendeng.ecs.action;

import com.ywendeng.ecs.domain.Orders;
import com.ywendeng.ecs.service.OrderService;
import com.ywendeng.ecs.utils.PageBean;

@SuppressWarnings("serial")
public class ManageOrderAction extends BaseAction{
	OrderService orderService;
	int page;
	PageBean<Orders> pageBean;
	 private  Orders order;
	
	
	public  String  showList(){
		pageBean=orderService.getAllOrder(page);
	
		return "list";
	}
	
	public String  updateState(){
		
		order=orderService.findOrderById(order.getOrid());
		order.setOrderState(3);
		orderService.updateOrder(order);
		  //从新查询订单信息
	 	pageBean=orderService.getAllOrder(page);
		return "list";
		
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public PageBean<Orders> getPageBean() {
		return pageBean;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}

	public Orders getOrder() {
		return order;
	}
	
	
	

}

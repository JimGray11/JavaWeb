package com.ywendeng.ecs.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.ywendeng.ecs.domain.Cart;
import com.ywendeng.ecs.domain.CartItem;
import com.ywendeng.ecs.domain.OrderItem;
import com.ywendeng.ecs.domain.Orders;
import com.ywendeng.ecs.domain.Users;
import com.ywendeng.ecs.service.OrderService;
import com.ywendeng.ecs.utils.PaymentUtil;


@SuppressWarnings("serial")
public class OrderAction extends  BaseAction implements ModelDriven<Orders> {
    OrderService  orderService;
    Orders order=new Orders();
    //用于接收银行付款类型
    private  String  pd_FrpId;
    //用于接收付款成功后穿回来的参数
	private String r3_Amt;
	private String r6_Order;
	Users user;
    //在用户提交订单的时候需要保存订单
    public  String save(){
    	//先判断用户是否登录
    	Users user=(Users) ServletActionContext.getRequest().getSession().getAttribute("user");
    	 if(user==null){
    		 this.addActionMessage("您尚未登录，请先登录...");
    		 return "login";
    	 }
    	 //设置关联用户
    	 order.setUser(user);
    	 
    	// 接收付款成功后的参数:
    	
    	 order.setOrdertime(new Date());
    	 order.setOrderState(1);
    	 //从购物车中取出相应的信息设置到订单中
    	Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
    	 if(cart!=null){
    		//从购物车中取出相关的信息设置到order中
    		 order.setTotal(cart.getTotal());
             //取出购物车中商品存入到数据库 中
    		Set<OrderItem> oItem=new  HashSet<>();
    		 for(CartItem c:cart.getCartItems()){
    			 OrderItem orderItem=new OrderItem();
    			 orderItem.setCount(c.getCount());
    			 orderItem.setGoods(c.getGoods());
    			 orderItem.setSubtotal(c.getSubtotal());
    			 orderItem.setOrder(order);
    			 //需要把该商品添加到order中取
    			 oItem.add(orderItem);
    		 }
    		 order.setOrderItems(oItem);
    		 orderService.saveOrder(order);
    		 return  "save";
    	 }
		return null;
    	
    }
    
    public String myOrder(){
    	//先判断用户是否登录
    	user=getExitUser();
    	 if(user==null){
       		 this.addActionMessage("您尚未登录，请先登录...");
       		 return "login";
       	 }
    	 //根据的Id查询所有的订单，然后再查找该订单对应的OrderItem
    	 List<Orders> orderList=orderService.findAllOrder(user.getUid());
    	//将该值存放到值栈中
    	 ActionContext.getContext().getValueStack().set("orderList",orderList);
    	 
    	return "myOrder";
    }
    private Users getExitUser() {
    	user=(Users) ServletActionContext.getRequest().getSession().getAttribute("user");
   	
		return user;
	}

	/*
     * 根据订单号来查询付款订单
     */
    public String findByOid(){
    	order=orderService.findOrderById(order.getOrid());
    	return "save";
    	
    }
     /*
      *更新订单中的用户信息,并进行付款请求
      */
      public String payOrder(){
    	  
    	  Orders curOrder=orderService.findOrderById(order.getOrid());
    	  curOrder.setAddr(order.getAddr());
    	  curOrder.setName(order.getName());
    	  curOrder.setPhone(order.getPhone());
    	//更新订单信息
    	  orderService.updateOrder(curOrder);
    	// 2.完成付款:
  		// 付款需要的参数:
  		String p0_Cmd = "Buy"; // 业务类型:
  		String p1_MerId = "10001126856";// 商户编号:
  		String p2_Order = order.getOrid().toString();// 订单编号:
  		String p3_Amt = "0.01"; // 付款金额:
  		String p4_Cur = "CNY"; // 交易币种:
  		String p5_Pid = ""; // 商品名称:
  		String p6_Pcat = ""; // 商品种类:
  		String p7_Pdesc = ""; // 商品描述:
  		String p8_Url = "http://192.168.36.69:8080/shop/order_callBack.action"; // 商户接收支付成功数据的地址:
  		String p9_SAF = ""; // 送货地址:
  		String pa_MP = ""; // 商户扩展信息:
  		String pd_FrpId = this.pd_FrpId;// 支付通道编码:
  		String pr_NeedResponse = "1"; // 应答机制:
  		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
  		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
  				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
  				pd_FrpId, pr_NeedResponse, keyValue); // hmac
  		// 向易宝发送请求:
  		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
  		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
  		sb.append("p1_MerId=").append(p1_MerId).append("&");
  		sb.append("p2_Order=").append(p2_Order).append("&");
  		sb.append("p3_Amt=").append(p3_Amt).append("&");
  		sb.append("p4_Cur=").append(p4_Cur).append("&");
  		sb.append("p5_Pid=").append(p5_Pid).append("&");
  		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
  		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
  		sb.append("p8_Url=").append(p8_Url).append("&");
  		sb.append("p9_SAF=").append(p9_SAF).append("&");
  		sb.append("pa_MP=").append(pa_MP).append("&");
  		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
  		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
  		sb.append("hmac=").append(hmac);
  		
  		// 重定向:向易宝出发:
  		try {
  			//*****************假设付款成功********************
  			curOrder.setOrderState(2);
  	  		orderService.updateOrder(curOrder);
  			
			ServletActionContext.getResponse().sendRedirect(sb.toString());
			
		} catch (IOException e) {
			System.out.println("找不到该页面....");
		}
    	  
    	   return  null;
    	  
      }
      
      //修改订单状态
     public  String updateState(){
    	 //获取当前订单
    	 order=orderService.findOrderById(order.getOrid());
    	 order.setOrderState(4);
    	 orderService.updateOrder(order);
    	 //根据的Id查询所有的订单，然后再查找该订单对应的OrderItem
    	 user=getExitUser();
    	 List<Orders> orderList=orderService.findAllOrder(user.getUid());
    	//将该值存放到值栈中
    	 ActionContext.getContext().getValueStack().set("orderList",orderList);
    	 return "myOrder";
     }
      
   // 付款成功后跳转回来的路径:
  	public String callBack(){
  		// 修改订单的状态:
  		Orders currOrder = orderService.findOrderById(r6_Order);
  		// 修改订单状态为2:已经付款:
  		currOrder.setOrderState(2);
  		orderService.updateOrder(currOrder);
  		this.addActionMessage("支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
  		
  		return  null;
  	}
  	
     
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}




	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}




	@Override
	public Orders getModel() {
		
		return order;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

      
}

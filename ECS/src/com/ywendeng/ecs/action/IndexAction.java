package com.ywendeng.ecs.action;

import java.util.List;

import org.hibernate.hql.ast.tree.FromClause;

import com.opensymphony.xwork2.ActionContext;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.domain.OneGoodsType;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.service.GoodsService;
import com.ywendeng.ecs.service.GoodsTypeService;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction {
   GoodsTypeService  goodsTypeService;
   GoodsService  goodsService;
   
	public String goodsType(){
		//从数据库中获取所有一级目录
		List<OneGoodsType>oneList=goodsTypeService.getAllOneGoodsType();
		
		 ActionContext.getContext().getSession().put("oneList", oneList);
		 //获取所有商品中最便宜的商品
		 List<Goods> gList=goodsService.getGoodsMostLower();
		 //将商品信息存放到值栈中
		 ActionContext.getContext().getValueStack().set("gList",gList);
		 
		 //获取最新产品
		 List<Goods> newList=goodsService.getLatest();
		 
		//将商品信息存放到值栈中
		 ActionContext.getContext().getValueStack().set("newList",newList);
		 //查询最热卖的产品
		 List<Goods> hotList=goodsService.getHotGoods();
		 
			//将商品信息存放到值栈中
	    ActionContext.getContext().getValueStack().set("hotList",hotList);
			 //查询最热卖的产品
			 
		return SUCCESS;
		
	}
	
	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	
}

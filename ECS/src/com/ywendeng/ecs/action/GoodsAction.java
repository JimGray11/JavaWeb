package com.ywendeng.ecs.action;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionContext;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.domain.OneGoodsType;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.service.GoodsService;
import com.ywendeng.ecs.utils.PageBean;


@SuppressWarnings("serial")
public class GoodsAction extends BaseAction{
   GoodsService  goodsService;
  
   Goods  goods;
   OneGoodsType  oneGoodsType;
   TwoGoodsType twoGoodsType;
    private int page;
    private  String goodsName;
    
    
    public String findByGid(){
    	goods=goodsService.findByGid(goods.getGid());
    	
		return "single";
	   
    }
   
    public String findAllGoodsBytwoType(){
    	 //根据tid获取查询需要获取是数据
    	PageBean<Goods> pageBean=goodsService.getAllGoodsBytwoType(twoGoodsType.getTid(),page);
    	 //将查询到的内容 ，存放到值栈
    	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "twoGoods";
    }
    //根据输入的商品名称模糊查询相关的商品
    public String findByname() throws Exception{
    	PageBean<Goods> pageBean=goodsService.findByName(goodsName,page);
    	if(pageBean.getList()!=null&&pageBean.getList().size()>0){
    		ActionContext.getContext().getValueStack().set("pageBean", pageBean);ActionContext.getContext().getValueStack().set("pageBean", pageBean);
    		return "twoGoods";
    	}else{
    		
    		return "notFind";
    	}
    	
    	
    }
    
    
  
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public OneGoodsType getOneGoodsType() {
		return oneGoodsType;
	}
	public void setOneGoodsType(OneGoodsType oneGoodsType) {
		this.oneGoodsType = oneGoodsType;
	}
	public TwoGoodsType getTwoGoodsType() {
		return twoGoodsType;
	}
	public void setTwoGoodsType(TwoGoodsType twoGoodsType) {
		this.twoGoodsType = twoGoodsType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
    
	
   
   
}

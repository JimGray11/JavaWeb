package com.ywendeng.ecs.action;


import java.util.List;

import com.ywendeng.ecs.domain.OneGoodsType;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.service.CategorySecondService;
import com.ywendeng.ecs.service.CategoryService;
import com.ywendeng.ecs.utils.PageBean;

@SuppressWarnings("serial")
public class CategorySecondAction  extends BaseAction {
   CategorySecondService categorySecondService;
   CategoryService categoryService;
   //用于接收需要查询的页
   int  page;
   PageBean<TwoGoodsType> pageBean;
   List<OneGoodsType> oneList;
   TwoGoodsType twoGoodsType;
   
   public String  showList(){
	 pageBean= categorySecondService.findTwoGoodsType(page);
	return "list";
   }
   
   public String add(){
	    oneList= categoryService.findAllOneGoodsType();
	   return "add";
   }
  
   public String  save(){
	   categorySecondService.save(twoGoodsType);
	return "add";  
   }
   public String delete(){
	   categorySecondService.delete(twoGoodsType);
	   pageBean= categorySecondService.findTwoGoodsType(page);
	   return "list";
   }
   public  String edit(){
	   twoGoodsType=categorySecondService.getTwoGoodsType(twoGoodsType.getTid());
	   
	   return "edit";
	   
   }
   public String update(){
	   categorySecondService.update(twoGoodsType);
	   return  "edit";
   }
 
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public PageBean<TwoGoodsType> getPageBean() {
		return pageBean;
	}

	public List<OneGoodsType> getOneList() {
		return oneList;
	}

	public TwoGoodsType getTwoGoodsType() {
		return twoGoodsType;
	}

	public void setTwoGoodsType(TwoGoodsType twoGoodsType) {
		this.twoGoodsType = twoGoodsType;
	}
    
	
   
   
   
   
}

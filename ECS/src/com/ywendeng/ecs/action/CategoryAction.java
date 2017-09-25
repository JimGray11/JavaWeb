package com.ywendeng.ecs.action;

import java.util.List;

import com.ywendeng.ecs.domain.OneGoodsType;
import com.ywendeng.ecs.service.CategoryService;

@SuppressWarnings("serial")
public class CategoryAction extends BaseAction {
	CategoryService  categoryService;
	List<OneGoodsType> oneList;
	OneGoodsType  oneGoodsType;
	
	
	public String showList(){
		oneList=categoryService.findAllOneGoodsType();
		
		return  "category";
	}
	/*
	 * 删除一级目录
	 */
	public  String delete(){
		 categoryService.delete(oneGoodsType);
		 oneList=categoryService.findAllOneGoodsType();
		return "category";
		
	}
	/*
	 * 添加一级商品目录
	 */
	public  String  save(){
		categoryService.save(oneGoodsType);
		oneList=categoryService.findAllOneGoodsType();
		return "save";
		
	}
   public  String edit(){
	   oneGoodsType=categoryService.findOneGoodsType(oneGoodsType.getOid());
	   return  "edit";
   }
   public String update(){
	      categoryService.update(oneGoodsType);
	      oneList=categoryService.findAllOneGoodsType();
	   return "update";
   }
	
	
	

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<OneGoodsType> getOneList() {
		return oneList;
	}

	public OneGoodsType getOneGoodsType() {
		return oneGoodsType;
	}

	public void setOneGoodsType(OneGoodsType oneGoodsType) {
		this.oneGoodsType = oneGoodsType;
	}
   
	
	
}

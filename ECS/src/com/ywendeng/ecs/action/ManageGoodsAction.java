package com.ywendeng.ecs.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.domain.OneGoodsType;
import com.ywendeng.ecs.domain.TwoGoodsType;
import com.ywendeng.ecs.service.CategorySecondService;
import com.ywendeng.ecs.service.CategoryService;
import com.ywendeng.ecs.service.GoodsService;
import com.ywendeng.ecs.service.ManageGoodsService;
import com.ywendeng.ecs.utils.PageBean;

@SuppressWarnings("serial")
public class ManageGoodsAction extends BaseAction {
    ManageGoodsService manageGoodsService;
    CategoryService  categoryService;
    CategorySecondService  categorySecondService;
    GoodsService  goodsService;
    List<OneGoodsType> oneList;
    List<TwoGoodsType> twoList;
    Goods  goods;
    //需要接受上传的文件 
   private  File up;
   //用于接收文件的路径
   private  String upFileName;
    
    private  String oid;
    
    PageBean<Goods> pageBean;
    int  page;
    
    public String showList(){
    	pageBean=manageGoodsService.findAllGoods(page);
    	
    	return "list";
    }
    public String add(){
    	//查询所有的一级分类
    	oneList=categoryService.findAllOneGoodsType();
		return "add";
    	
    }
    
    //保存添加的商品信息
    public String save() throws Exception{

    	goods.setPdate(new Date());
    	//实现文件的上传
    	//解析文件名
    			int pointPos=upFileName.indexOf('.');
    			//取出上传文件的类型
    			String ext=upFileName.substring(pointPos);
    			String fileName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+ext;
    			//文件路径
    			String header = "products/"+fileName;
    			
    			//上传文件路径
    					String path = ServletActionContext.getRequest()
    						.getSession().getServletContext().getRealPath("/products");
    				
    					File outFile = new File(path,fileName);
    					//上传文件
    					FileUtil.copyFile(up, outFile);
    			//设置商品的图片路径
    			 goods.setImage(header);
    			 //保存商品信息
    			 goodsService.save(goods);
    			 
		return "add";
    }
    //删除商品信息
    public String delete(){
    	manageGoodsService.delete(goods);
    	pageBean=manageGoodsService.findAllGoods(page);
    	
		return "list";
    }
    public String edit(){
    	//根据商品id获取该商品
    	goods=goodsService.findByGid(goods.getGid());
  
     return "edit";
    	
    }
    public String update(){
     return "list";
    }
    
    
    public String getTwoGoodsType() throws Exception{
    	Thread.currentThread().sleep(1000L);
    	  Map<String,Object> tMap;
          twoList=categorySecondService.getTwoGoodsTyeByOid(oid);
  		 List<Map<String, Object>> jsonList = new ArrayList<Map<String,Object>>();
          for(TwoGoodsType t:twoList){
        	  tMap=new HashMap<>();
        	  tMap.put("tid", t.getTid());
        	  tMap.put("name", t.getName());
        	  jsonList.add(tMap);
          }
    	  return jsonString(jsonList);
    }

	public void setManageGoodsService(ManageGoodsService manageGoodsService) {
		this.manageGoodsService = manageGoodsService;
	}


	public PageBean<Goods> getPageBean() {
		return pageBean;
	}



	public void setPage(int page) {
		this.page = page;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	public List<OneGoodsType> getOneList() {
		return oneList;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public void setUp(File up) {
		this.up = up;
	}
	public void setUpFileName(String upFileName) {
		this.upFileName = upFileName;
	}
	public List<TwoGoodsType> getTwoList() {
		return twoList;
	}
	public Goods getGoods() {
		return goods;
	}
    
    
    
}

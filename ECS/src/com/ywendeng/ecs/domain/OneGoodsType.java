package com.ywendeng.ecs.domain;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class OneGoodsType implements Serializable {
   private  String oid;
   private  String name;
   
   private  Set<TwoGoodsType> twoGoodsType;
   
   
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Set<TwoGoodsType> getTwoGoodsType() {
		return twoGoodsType;
	}
	public void setTwoGoodsType(Set<TwoGoodsType> twoGoodsType) {
		this.twoGoodsType = twoGoodsType;
	}
	
	
   
   
}

package com.hrmsystem.domain;

public class Page {
	private int Pagesize;
	private int Pagenum;
	private int Pagecount;
	private int Recordcount;
	public int getPagesize() {
		return Pagesize;
	}
	public void setPagesize(int pagesize) {
		Pagesize = pagesize;
	}
	public int getPagenum() {
		return Pagenum;
	}
	public void setPagenum(int pagenum) {
		Pagenum = pagenum;
	}
	public int getPagecount() {
		return Pagecount;
	}
	public void setPagecount(int pagecount) {
		Pagecount = pagecount;
	}
	public int getRecordcount() {
		return Recordcount;
	}
	public void setRecordcount(int recordcount) {
		Recordcount = recordcount;
	}
	
	
}


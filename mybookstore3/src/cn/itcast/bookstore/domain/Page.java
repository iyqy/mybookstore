package cn.itcast.bookstore.domain;

import java.util.List;

public class Page {
	
	private List pageData;
	private int pageNum;
	private int totalPageNum;
	private int totalRecord;
	private int firstPageNum;
	private int lastPageNum;
	public List getPageData() {
		return pageData;
	}
	public void setPageData(List pageData) {
		this.pageData = pageData;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getFirstPageNum() {
		return firstPageNum;
	}
	public void setFirstPageNum(int firstPageNum) {
		this.firstPageNum = firstPageNum;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	
	

}

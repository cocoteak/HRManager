package com.Util;

public class PageShow {
int pageNow;
int pageSize;
int totalSize;

public PageShow(int pageNow, int pageSize, int totalSize) {
	super();
	this.pageNow = pageNow;
	this.pageSize = pageSize;
	this.totalSize = totalSize;
}

int totalPage;
boolean hasFirst;
boolean hasPre;
boolean hasNext;
boolean hasLast;

public int getPageNow() {
	return pageNow;
}
public void setPageNow(int pageNow) {
	this.pageNow = pageNow;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getTotalSize() {
	return totalSize;
}
public void setTotalSize(int totalSize) {
	this.totalSize = totalSize;
}
public int getTotalPage() {
	totalPage=totalSize/pageSize;
	if(totalSize%pageSize!=0){
		totalPage+=1;
	}
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public boolean isHasFirst() {
	if(pageNow>1){
		return true;
	}else{
		return false;
	}
}
public void setHasFirst(boolean hasFirst) {
	this.hasFirst = hasFirst;
}
public boolean isHasPre() {
	if(pageNow>1){
		return true;
	}else{
		return false;
	}
}
public void setHasPre(boolean hasPre) {
	this.hasPre = hasPre;
}
public boolean isHasNext() {
	if(pageNow< getTotalPage()){
		return true;
	}else{
		return false;
	}
}
public void setHasNext(boolean hasNext) {
	this.hasNext = hasNext;
}
public boolean isHasLast() {
	if(pageNow< getTotalPage()){
		return true;
	}else{
		return false;
	}
}
public void setHasLast(boolean hasLast) {
	this.hasLast = hasLast;
}

}

package com.Domian;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Notice {
	 @Override
	public String toString() {
		return "Notice [CONTENT=" + CONTENT + ", CREATE_DATE=" + CREATE_DATE
				+ ", ID=" + ID + ", TITLE=" + TITLE + ", USER_ID=" + USER_ID
				+ ", User=" + User + "]";
	}

	Integer ID;
	 
	 @NotBlank(message="公告标题名不能为空") @Length(message="登录名长度为1-12个字符",min=1,max=12)
	 String TITLE;
	 @NotBlank(message="公告内容不能为空")
	 String CONTENT;
	 Date CREATE_DATE; 
	
	 Integer USER_ID;
	 User User;
	 
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public Date getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(Date cREATEDATE) {
		CREATE_DATE = cREATEDATE;
	}
	public Integer getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(Integer uSERID) {
		USER_ID = uSERID;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}

	
}

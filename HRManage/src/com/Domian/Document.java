package com.Domian;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class Document {
	 Integer ID;
	 String TITLE;
	 String filename;
	 @Override
	public String toString() {
		return "Document [CREATE_DATE=" + CREATE_DATE + ", ID=" + ID
				+ ", REMARK=" + REMARK + ", TITLE=" + TITLE + ", USER_ID="
				+ USER_ID + ", filename=" + filename + ", user=" + user + "]";
	}

	String REMARK;
	 Date CREATE_DATE;
	 Integer USER_ID;
	 User user;

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSERID) {
		USER_ID = uSERID;
	}

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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public Date getCREATE_DATE() {
		return CREATE_DATE;
	}

	public void setCREATE_DATE(Date cREATEDATE) {
		CREATE_DATE = cREATEDATE;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

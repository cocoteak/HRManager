package com.Domian;

public class Job {
	private Integer ID;
	private  String NAME;
	private  String REMARK;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	@Override
	public String toString() {
		return "Job [ID=" + ID + ", NAME=" + NAME + ", REMARK=" + REMARK + "]";
	}
	
	
}

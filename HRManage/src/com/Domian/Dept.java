package com.Domian;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Dept {
	  Integer ID;
	  @NotBlank(message="部门名不能为空") @Length(message="登录名长度为1-6个字符",min=1,max=6)
	  String NAME;
	  String REMARK;
	
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
		return "Dept [ID=" + ID + ", NAME=" + NAME + ", REMARK=" + REMARK + "]";
	}
}

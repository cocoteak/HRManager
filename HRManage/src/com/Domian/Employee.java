package com.Domian;

import java.util.Date;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	  Integer ID;
	  
	  @NotNull(message="所属部门不能为空")
	  Integer DEPT_ID;
	  @NotNull(message="职位不能为空")
	  Integer JOB_ID;
	  
	  @NotBlank(message="员工姓名不能为空") @Length(message="登录名长度为1-8个字符",min=1,max=8)
	  String NAME;
	  
	  @NotBlank(message="身份证号码不能为空") @Length(message="身份证号码长度为18个字符",min=18,max=18)
	  String CARD_ID;
	  
	  @NotBlank(message="联系地址不能为空")
	  String ADDRESS;
	  
	  String POST_CODE;
	  String TEL;
	  
	  @NotBlank(message="电话号码不能为空")@Length(message="联系电话长度为5-12个字符",min=5,max=12)
	  String PHONE;
	  String QQ_NUM;
	  
	  @NotBlank(message="email不能为空")@Length(message="email长度为5-20个字符",min=5,max=20)
	  String EMAIL;
	  
	  @NotNull(message="性别不能为空")
	  Integer SEX;
	  String PARTYl;
	  
	  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	  Date BIRTHDAY;
	  
	  String RACE;
	  String EDUCATION;
	  String SPECIALITY;
	  String HOBBY;
	  String REMARK;
	  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	  Date CREATE_DATE;
	  Dept dept;
	  Job job;
	  
	  
	  public Date getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(Date cREATEDATE) {
		CREATE_DATE = cREATEDATE;
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getDEPT_ID() {
		return DEPT_ID;
	}
	public void setDEPT_ID(Integer dEPTID) {
		DEPT_ID = dEPTID;
	}
	public Integer getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(Integer jOBID) {
		JOB_ID = jOBID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCARD_ID() {
		return CARD_ID;
	}
	public void setCARD_ID(String cARDID) {
		CARD_ID = cARDID;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getPOST_CODE() {
		return POST_CODE;
	}
	public void setPOST_CODE(String pOSTCODE) {
		POST_CODE = pOSTCODE;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getQQ_NUM() {
		return QQ_NUM;
	}
	public void setQQ_NUM(String qQNUM) {
		QQ_NUM = qQNUM;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public Integer getSEX() {
		return SEX;
	}
	public void setSEX(Integer sEX) {
		SEX = sEX;
	}
	public String getPARTYl() {
		return PARTYl;
	}
	public void setPARTYl(String pARTYl) {
		PARTYl = pARTYl;
	}
	public Date getBIRTHDAY() {
		return BIRTHDAY;
	}
	public void setBIRTHDAY(Date bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}
	public String getRACE() {
		return RACE;
	}
	public void setRACE(String rACE) {
		RACE = rACE;
	}
	public String getEDUCATION() {
		return EDUCATION;
	}
	public void setEDUCATION(String eDUCATION) {
		EDUCATION = eDUCATION;
	}
	public String getSPECIALITY() {
		return SPECIALITY;
	}
	public void setSPECIALITY(String sPECIALITY) {
		SPECIALITY = sPECIALITY;
	}
	public String getHOBBY() {
		return HOBBY;
	}
	public void setHOBBY(String hOBBY) {
		HOBBY = hOBBY;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
}

package com.Domian;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
	  Integer ID;
	  
	  @NotBlank(message="��¼������Ϊ��") @Length(message="��¼������Ϊ1-12���ַ�",min=1,max=12)
	  String loginname;
	  
	  @Length(message="���볤��Ϊ6-12���ַ�",min=6,max=12)
	  String PASSWORD;
	  
	  @Max(2)
	  @Min(1)
	  Integer STATUS;
	  
	  @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	  @Past(message="�����û���ʱ������ǹ�ȥ������")
	  Date createdate;
	  
	  @NotBlank(message="�û�������Ϊ��,�����û������¼��һ��")@Length(message="�û�������Ϊ1-12���ַ�",min=1,max=12)
	  String username;
	  
	@Override
	public String toString() {
		return "User [ID=" + ID + ", PASSWORD=" + PASSWORD + ", STATUS="
				+ STATUS + ", createdate=" + createdate + ", loginname="
				+ loginname + ", username=" + username + "]";
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public Integer getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(Integer sTATUS) {
		STATUS = sTATUS;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}

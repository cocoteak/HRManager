package com.Provider;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.Domian.Employee;


public class EmployeeProvider {
	//分页查询
	public String selectEmployeeWithPage(final Map map){
		String str=new SQL(){{
			SELECT("*");
			FROM("employee_inf");
			Employee employee=(Employee)map.get("employee");
			if(employee!=null){
			if(employee.getNAME()!=null&&!employee.getNAME().equals("")){
				WHERE("NAME like concat('%',#{employee.NAME},'%')");
			}
			if(employee.getCARD_ID()!=null&&!employee.getCARD_ID().equals("")){
				WHERE("CARD_ID like concat('%',#{employee.CARD_ID},'%')");
			}
			if(employee.getPHONE()!=null&&!employee.getPHONE().equals("")){
				WHERE("PHONE like concat('%',#{employee.PHONE},'%')");
			}
			if(employee.getJOB_ID()!=null){
				WHERE("JOB_ID=#{employee.JOB_ID}");
			}
			if(employee.getSEX()!=null){
				WHERE("SEX=#{employee.SEX}");
			}
			if(employee.getDEPT_ID()!=null){
				WHERE("DEPT_ID=#{employee.DEPT_ID}");
			}
	      }
	    }}.toString();
	    int pageNow=(Integer)map.get("pageNow");
	    int pageSize=(Integer)map.get("pageSize");
	    str=str+" limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str;	      
  }
	
	//查询总数
	public String selectEmployeeAcount(final Map map){
		return new SQL(){{
			SELECT("*");
			FROM("employee_inf");
			Employee employee=(Employee)map.get("employee");
			if(employee!=null){
			if(employee.getNAME()!=null&&!employee.getNAME().equals("")){
				WHERE("NAME like concat('%',#{employee.NAME},'%')");
			}
			if(employee.getCARD_ID()!=null&&!employee.getCARD_ID().equals("")){
				WHERE("CARD_ID like concat('%',#{employee.CARD_ID},'%')");
			}
			if(employee.getPHONE()!=null&&!employee.getPHONE().equals("")){
				WHERE("PHONE like concat('%',#{employee.PHONE},'%')");
			}
			if(employee.getJOB_ID()!=null){
				WHERE("JOB_ID=#{employee.JOB_ID}");
			}
			if(employee.getSEX()!=null){
				WHERE("SEX=#{employee.SEX}");
			}
			if(employee.getDEPT_ID()!=null){
				WHERE("DEPT_ID=#{employee.DEPT_ID}");
			}
	      }
	    }}.toString();
  }
	
	//动态插入
	public String insertEmployee(final Employee employee){
		return new SQL(){{
			INSERT_INTO("employee_inf");
			if(employee.getNAME()!=null&&!employee.getNAME().equals("")){
				VALUES("NAME","#{NAME}");
			}
			if(employee.getREMARK()!=null&&!employee.getREMARK().equals("")){
				VALUES("REMARK","#{REMARK}");
			}
			if(employee.getCARD_ID()!=null&&!employee.getCARD_ID().equals("")){
				VALUES("CARD_ID","#{CARD_ID}");
			}
			if(employee.getSEX()!=null&&!employee.getSEX().equals("")){
				VALUES("SEX","#{SEX}");
			}
			if(employee.getJOB_ID()!=null){
				VALUES("JOB_ID","#{JOB_ID}");
			}
			if(employee.getEDUCATION()!=null&&!employee.getEDUCATION().equals("")){
				VALUES("EDUCATION","#{EDUCATION}");
			}
			if(employee.getEMAIL()!=null&&!employee.getEMAIL().equals("")){
				VALUES("EMAIL","#{EMAIL}");
			}
			if(employee.getPHONE()!=null&&!employee.getPHONE().equals("")){
				VALUES("PHONE","#{PHONE}");
			}
			if(employee.getTEL()!=null&&!employee.getTEL().equals("")){
				VALUES("TEL","#{TEL}");
			}
			if(employee.getPARTYl()!=null&&!employee.getPARTYl().equals("")){
				VALUES("PARTYl","#{PARTYl}");
			}
			if(employee.getQQ_NUM()!=null&&!employee.getQQ_NUM().equals("")){
				VALUES("QQ_NUM","#{QQ_NUM}");
			}
			if(employee.getADDRESS()!=null&&!employee.getADDRESS().equals("")){
				VALUES("ADDRESS","#{ADDRESS}");
			}
			if(employee.getPOST_CODE()!=null&&!employee.getPOST_CODE().equals("")){
				VALUES("POST_CODE","#{POST_CODE}");
			}
			if(employee.getBIRTHDAY()!=null&&!employee.getBIRTHDAY().equals("")){
				VALUES("BIRTHDAY","#{BIRTHDAY}");
			}
			if(employee.getRACE()!=null&&!employee.getRACE().equals("")){
				VALUES("RACE","#{RACE}");
			}
			if(employee.getSPECIALITY()!=null&&!employee.getSPECIALITY().equals("")){
				VALUES("SPECIALITY","#{SPECIALITY}");
			}
			if(employee.getHOBBY()!=null&&!employee.getHOBBY().equals("")){
				VALUES("HOBBY","#{HOBBY}");
			}
			if(employee.getDEPT_ID()!=null){
				VALUES("DEPT_ID","#{DEPT_ID}");
			}
	      }
	    }.toString();
  }
	//动态更新
	public String updateEmployee(final Employee employee){
		return new SQL(){{
			UPDATE("employee_inf");
			if(employee.getNAME()!=null&&!employee.getNAME().equals("")){
				SET("NAME=#{NAME}");
			}
			if(employee.getREMARK()!=null&&!employee.getREMARK().equals("")){
				SET("REMARK=#{REMARK}");
			}
			if(employee.getCARD_ID()!=null&&!employee.getCARD_ID().equals("")){
				SET("CARD_ID=#{CARD_ID}");
			}
			if(employee.getSEX()!=null&&!employee.getSEX().equals("")){
				SET("SEX=#{SEX}");
			}
			if(employee.getJOB_ID()!=null){
				SET("JOB_ID=#{JOB_ID}");
			}
			if(employee.getEDUCATION()!=null&&!employee.getEDUCATION().equals("")){
				SET("EDUCATION=#{EDUCATION}");
			}
			if(employee.getEMAIL()!=null&&!employee.getEMAIL().equals("")){
				SET("EMAIL=#{EMAIL}");
			}
			if(employee.getPHONE()!=null&&!employee.getPHONE().equals("")){
				SET("PHONE=#{PHONE}");
			}
			if(employee.getTEL()!=null&&!employee.getTEL().equals("")){
				SET("TEL=#{TEL}");
			}
			if(employee.getPARTYl()!=null&&!employee.getPARTYl().equals("")){
				SET("PARTYl=#{PARTYl}");
			}
			if(employee.getQQ_NUM()!=null&&!employee.getQQ_NUM().equals("")){
				SET("QQ_NUM=#{QQ_NUM}");
			}
			if(employee.getADDRESS()!=null&&!employee.getADDRESS().equals("")){
				SET("ADDRESS=#{ADDRESS}");
			}
			if(employee.getPOST_CODE()!=null&&!employee.getPOST_CODE().equals("")){
				SET("POST_CODE=#{POST_CODE}");
			}
			if(employee.getBIRTHDAY()!=null&&!employee.getBIRTHDAY().equals("")){
				SET("BIRTHDAY=#{BIRTHDAY}");
			}
			if(employee.getRACE()!=null&&!employee.getRACE().equals("")){
				SET("RACE=#{RACE}");
			}
			if(employee.getSPECIALITY()!=null&&!employee.getSPECIALITY().equals("")){
				SET("SPECIALITY=#{SPECIALITY}");
			}
			if(employee.getHOBBY()!=null&&!employee.getHOBBY().equals("")){
				SET("HOBBY=#{HOBBY}");
			}
			if(employee.getDEPT_ID()!=null){
				SET("DEPT_ID=#{DEPT_ID}");
			}
			WHERE("ID=#{ID}");
	      } 
	    }.toString();
  }
	
	
	
}

package com.Provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.Domian.Dept;


public class DeptProvider {
	//��ҳ��ѯ
	public String selectDeptWithPage(final Map map){
		String str=new SQL(){{
			SELECT("*");
			FROM("dept_inf");
			Dept dept=(Dept)map.get("dept");
			if(dept!=null){
			if(dept.getNAME()!=null&&!dept.getNAME().equals("")){
				WHERE("NAME like concat('%',#{dept.NAME},'%')");
			}
	      }
	    }}.toString();
	    int pageNow=(Integer)map.get("pageNow");
	    int pageSize=(Integer)map.get("pageSize");
	    str=str+" limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str;	      
  }
	
	//��ѯ����
	public String selectDeptAcount(final Map map){
		return new SQL(){{
			SELECT("*");
			FROM("dept_inf");
			Dept dept=(Dept)map.get("dept");
			if(dept!=null){
			if(dept.getNAME()!=null&&!dept.getNAME().equals("")){
				WHERE("NAME like concat('%',#{dept.NAME},'%')");
			}
	      }
	    }}.toString();
  }
	
	//��̬����
	public String insertDept(final Dept dept){
		return new SQL(){{
			INSERT_INTO("dept_inf");
			if(dept.getNAME()!=null&&!dept.getNAME().equals("")){
				VALUES("NAME","#{NAME}");
			}
			if(dept.getREMARK()!=null&&!dept.getREMARK().equals("")){
				VALUES("REMARK","#{REMARK}");
			}
	      }
	    }.toString();
  }
	//��̬����
	public String updateDept(final Dept dept){
		return new SQL(){{
			UPDATE("dept_inf");
			if(dept.getNAME()!=null){
				SET("NAME=#{NAME}");
			}
			if(dept.getREMARK()!=null){
				SET("REMARK=#{REMARK}");
			}
			 WHERE("ID=#{ID}");
	      }
	    }.toString();
  }
}

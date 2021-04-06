package com.Provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.Domian.User;

public class UserProvider {
	//动态查询
	public String selectUser(final User user){
		return new SQL(){{
			SELECT("*");
			FROM("user_inf");
			if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
				WHERE("loginname like concat('%',#{loginname},'%')");
			}
			if(user.getSTATUS()!=null&&!user.getSTATUS().equals("")){
				WHERE("STATUS like concat('%',#{STATUS},'%')");
			}
	      }
	    }.toString();
  }
	
	//分页查询
	public String selectUserWithPage(final Map map){
		String str=new SQL(){{
			SELECT("*");
			FROM("user_inf");
			User user=(User)map.get("user");
			if(user!=null){
			if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
				WHERE("loginname like concat('%',#{user.loginname},'%')");
			}
			if(user.getSTATUS()!=null&&!user.getSTATUS().equals("")){
				WHERE("STATUS like concat('%',#{user.STATUS},'%')");
			}
	      }
	    }}.toString();
	    int pageNow=(Integer)map.get("pageNow");
	    int pageSize=(Integer)map.get("pageSize");
	    str=str+" limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str;	      
  }
	
	//查询总数
	public String selectUserAcount(final Map map){
		return new SQL(){{
			SELECT("*");
			FROM("user_inf");
			User user=(User)map.get("user");
			if(user!=null){
			if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
				WHERE("loginname like concat('%',#{user.loginname},'%')");
			}
			if(user.getSTATUS()!=null&&!user.getSTATUS().equals("")){
				WHERE("STATUS like concat('%',#{user.STATUS},'%')");
			}
	      }
	    }}.toString();
  }
	
	//动态插入
	public String insertUser(final User user){
		return new SQL(){{
			INSERT_INTO("user_inf");
			if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
				VALUES("loginname","#{loginname}");
			}
			if(user.getPASSWORD()!=null&&!user.getPASSWORD().equals("")){
				VALUES("PASSWORD","#{PASSWORD}");
			}
			if(user.getUsername()!=null&&!user.getUsername().equals("")){
				VALUES("username","#{username}");
			}
			if(user.getSTATUS()!=null&&!user.getSTATUS().equals("")){
				VALUES("STATUS","#{STATUS}");
			}
	      }
	    }.toString();
  }
	//动态更新(未更新ID)
	public String updateUser(final User user){
		return new SQL(){{
			UPDATE("user_inf");
			if(user.getLoginname()!=null){
				SET("loginname=#{loginname}");
			}
			if(user.getPASSWORD()!=null){
				SET("PASSWORD=#{PASSWORD}");
			}
			if(user.getSTATUS()!=null){
				SET("STATUS=#{STATUS}");
			}
			if(user.getCreatedate()!=null){
				SET("createdate=#{createdate}");
			}
			if(user.getUsername()!=null){
				SET("username=#{username}");
			}
				WHERE("ID=#{ID}");
	      }
	    }.toString();
  }
}

package com.Provider;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.Domian.Notice;


public class NoticeProvider {
	//分页查询
	public String selectNoticeWithPage(final Map map){
		String str=new SQL(){{
			SELECT("*");
			FROM("notice_inf");
			Notice notice=(Notice)map.get("notice");
			if(notice!=null){
			if(notice.getTITLE()!=null&&!notice.getTITLE().equals("")){
				WHERE("TITLE like concat('%',#{notice.TITLE},'%')");
			}
			if(notice.getCONTENT()!=null&&!notice.getCONTENT().equals("")){
				WHERE("CONTENT like concat('%',#{notice.CONTENT},'%')");
			}
	      }
	    }}.toString();
	    int pageNow=(Integer)map.get("pageNow");
	    int pageSize=(Integer)map.get("pageSize");
	    str=str+" limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str;	      
  }
	
	//查询总数
	public String selectNoticeAcount(final Map map){
		return new SQL(){{
			SELECT("*");
			FROM("notice_inf");
			Notice notice=(Notice)map.get("notice");
			if(notice!=null){
			if(notice.getTITLE()!=null&&!notice.getTITLE().equals("")){
				WHERE("TITLE like concat('%',#{notice.TITLE},'%')");
			}
			if(notice.getCONTENT()!=null&&!notice.getCONTENT().equals("")){
				WHERE("CONTENT like concat('%',#{notice.CONTENT},'%')");
			}
	      }
	    }}.toString();
}

	//动态插入
	public String insertNotice(final Notice notice){
		return new SQL(){{
			INSERT_INTO("notice_inf");
			if(notice.getTITLE()!=null&&!notice.getTITLE().equals("")){
				VALUES("TITLE","#{TITLE}");
			}
			if(notice.getCONTENT()!=null&&notice.getCONTENT().equals("")){
				VALUES("CONTENT","#{CONTENT}");
			}
			if(notice.getUSER_ID()!=null){
				VALUES("USER_ID","#{USER_ID}");
			}
	      }
	    }.toString();
  }
	//动态更新
	public String updateNotice(final Notice notice ){
		return new SQL(){{
			UPDATE("notice_inf");
			if(notice.getTITLE()!=null&&!notice.getTITLE().equals("")){
				SET("TITLE=#{TITLE}");
			}
			if(notice.getCONTENT()!=null&&!notice.getCONTENT().equals("")){
				SET("CONTENT=#{CONTENT}");
			}
			 WHERE("ID=#{ID}");
	      }
	    }.toString();
  }
}

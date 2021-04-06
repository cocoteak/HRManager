package com.Provider;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.Domian.Document;

public class DocumentProvider {
	//分页查询
	public String selectDocumentWithPage(final Map map){
		String str=new SQL(){{
			SELECT("*");
			FROM("document_inf");
			Document document=(Document)map.get("document");
			if(document!=null){
			if(document.getTITLE()!=null&&!document.getTITLE().equals("")){
				WHERE("TITLE like concat('%',#{document.TITLE},'%')");
			}
	      }
	    }}.toString();
	    int pageNow=(Integer)map.get("pageNow");
	    int pageSize=(Integer)map.get("pageSize");
	    str=str+" limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str;	      
  }
	
	//查询总数
	public String selectDocumentAcount(final Map map){
		return new SQL(){{
			SELECT("*");
			FROM("document_inf");
			Document document=(Document)map.get("document");
			if(document!=null){
			if(document.getTITLE()!=null&&!document.getTITLE().equals("")){
				WHERE("TITLE like concat('%',#{document.TITLE},'%')");
			}
	      }
	    }}.toString();
}


	
	//动态插入
	public String insertDocument(final Document document){
		return new SQL(){{
			INSERT_INTO("document_inf");
			if(document.getTITLE()!=null&&!document.getTITLE().equals("")){
				VALUES("TITLE","#{TITLE}");
			}
			if(document.getREMARK()!=null&&!document.getREMARK().equals("")){
				VALUES("REMARK","#{REMARK}");
			}
			if(document.getFilename()!=null&&!document.getFilename().equals("")){
				VALUES("filename","#{filename}");
			}
			if(document.getCREATE_DATE()!=null&&!document.getCREATE_DATE().equals("")){
				VALUES("CREATE_DATE","#{CREATE_DATE}");
			}
			if(document.getUSER_ID()!=null){
				VALUES("USER_ID","#{USER_ID}");
			}
	      }
	    }.toString();
  }
	//动态更新
	public String updateDocument(final Document document){
		return new SQL(){{
			UPDATE("document_inf");
			if(document.getTITLE()!=null&&!document.getTITLE().equals("")){
				SET("TITLE=#{TITLE}");
			}
			if(document.getREMARK()!=null&&!document.getREMARK().equals("")){
				SET("REMARK=#{REMARK}");
			}
			if(document.getFilename()!=null&&!document.getFilename().equals("")){
				SET("filename=#{filename}");
			}
			 WHERE("ID=#{ID}");
	      }
	    }.toString();
  }
}

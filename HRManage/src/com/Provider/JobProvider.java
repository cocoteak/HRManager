package com.Provider;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.Domian.Job;
public class JobProvider {
	//��ҳ��ѯ
	public String selectJobWithPage(final Map map){
		String str=new SQL(){{
			SELECT("*");
			FROM("job_inf");
			Job job=(Job)map.get("job");
			if(job!=null){
			if(job.getNAME()!=null&&!job.getNAME().equals("")){
				WHERE("NAME like concat('%',#{job.NAME},'%')");
			}
	      }
	    }}.toString();
	    int pageNow=(Integer)map.get("pageNow");
	    int pageSize=(Integer)map.get("pageSize");
	    str=str+" limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str;	      
  }
	
	//��ѯ����
	public String selectJobAcount(final Map map){
		return new SQL(){{
			SELECT("*");
			FROM("job_inf");
			Job job=(Job)map.get("job");
			if(job!=null){
			if(job.getNAME()!=null&&!job.getNAME().equals("")){
				WHERE("NAME like concat('%',#{job.NAME},'%')");
			}
	      }
	    }}.toString();
  }
	
	//��̬����
	public String insertJob(final Job job){
		return new SQL(){{
			INSERT_INTO("job_inf");
			if(job.getNAME()!=null&&!job.getNAME().equals("")){
				VALUES("NAME","#{NAME}");
			}
			if(job.getREMARK()!=null&&!job.getREMARK().equals("")){
				VALUES("REMARK","#{REMARK}");
			}
	      }
	    }.toString();
  }
	//��̬����
	public String updateJob(final Job job){
		return new SQL(){{
			UPDATE("job_inf");
			if(job.getNAME()!=null){
				SET("NAME=#{NAME}");
			}
			if(job.getREMARK()!=null){
				SET("REMARK=#{REMARK}");
			}
			 WHERE("ID=#{ID}");
	      }
	    }.toString();
  }
}

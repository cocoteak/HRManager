package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.Domian.Job;

public interface JobService {
    //分页查询
	List<Job> selectJobWithParamPage(Map map);
	
	//查询数据总数
	List<Job> selectJobAccount(Map map);
	
	//全部查询
    public List<Job> selectAllJob();
	
	//通过部门名查询
    public Job selectJobByName(String NAME);
    
  //通过id查询
    public Job selectJobById(Integer ID);
	
	//动态插入部门
	int InsertJob(Job job);

	//更新部门信息
	int updateJob(Job job);

	//通过id删除部门
    public int deleteJob(@Param("ID") Integer ID);
}

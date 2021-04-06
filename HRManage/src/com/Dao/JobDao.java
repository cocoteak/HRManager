package com.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.Domian.Dept;
import com.Domian.Job;
import com.Provider.JobProvider;

@Repository("jobDao")
public interface JobDao {
	//分页查询
	@SelectProvider(type=JobProvider.class,method="selectJobWithPage")
	List<Job> selectJobWithParamPage(Map map);
	
	//查询数据总数
	@SelectProvider(type=JobProvider.class,method="selectJobAcount")
	List<Job> selectJobAccount(Map map);
	
	//全部查询
	@Select("SELECT * FROM job_inf")
    public List<Job> selectAllJob();
	
	//通过部门名查询
	@Select("SELECT * FROM job_inf WHERE NAME=#{NAME}")
    public Job selectJobByName(@Param("NAME") String NAME);
	
	//通过id查询
	@Select("SELECT * FROM job_inf WHERE ID=#{ID}")
    public Job selectJobById(@Param("ID") Integer ID);
	
	
	//动态插入部门
	@InsertProvider(type=JobProvider.class,method="insertJob")
	@Options(useGeneratedKeys=true,keyProperty="ID")
	int InsertJob(Job job);

	//更新部门信息
	@UpdateProvider(type=JobProvider.class,method="updateJob")
	int updateJob(Job job);

	//通过id删除部门
	@Delete("delete from job_inf WHERE ID=#{ID}")
    public int deleteJob(@Param("ID") Integer ID);

}

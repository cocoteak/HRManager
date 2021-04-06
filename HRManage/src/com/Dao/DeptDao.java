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
import com.Provider.DeptProvider;

@Repository("deptDao")
public interface DeptDao {
	//分页查询
	@SelectProvider(type=DeptProvider.class,method="selectDeptWithPage")
	List<Dept> selectDeptWithParamPage(Map map);
	
	//查询数据总数
	@SelectProvider(type=DeptProvider.class,method="selectDeptAcount")
	List<Dept> selectDeptAccount(Map map);
	
	//全部查询
	@Select("SELECT * FROM dept_inf")
    public List<Dept> selectAllDept();
	
	//通过部门名查询
	@Select("SELECT * FROM dept_inf WHERE NAME=#{NAME}")
    public Dept selectDeptByName(@Param("NAME") String NAME);
	
	//通过id查询
	@Select("SELECT * FROM dept_inf WHERE ID=#{ID}")
    public Dept selectDeptById(@Param("ID") Integer ID);
	
	//动态插入部门
	@InsertProvider(type=DeptProvider.class,method="insertDept")
	@Options(useGeneratedKeys=true,keyProperty="ID")
	int InsertDept(Dept dept);

	//更新部门信息
	@UpdateProvider(type=DeptProvider.class,method="updateDept")
	int updateDept(Dept dept);

	//通过id删除部门
	@Delete("delete from dept_inf WHERE ID=#{ID}")
    public int deleteDept(@Param("ID") Integer ID);

}

package com.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.Domian.Employee;
import com.Provider.EmployeeProvider;

@Repository("employeeDao")
public interface EmployeeDao {
	//分页查询
	@SelectProvider(type=EmployeeProvider.class,method="selectEmployeeWithPage")
	@Results({
		@Result(column="JOB_ID",property="job",one=@One(select="com.Dao.JobDao.selectJobById",fetchType=FetchType.LAZY)),
		@Result(column="DEPT_ID",property="dept",one=@One(select="com.Dao.DeptDao.selectDeptById",fetchType=FetchType.LAZY)),
		@Result(column="DEPT_ID",property="DEPT_ID"),
		@Result(column="JOB_ID",property="JOB_ID")
	})
	List<Employee> selectEmployeeWithParamPage(Map map);
	
	//查询数据总数
	@SelectProvider(type=EmployeeProvider.class,method="selectEmployeeAcount")
	List<Employee> selectEmployeeAccount(Map map);
	

	//通过id查询
	@Select("SELECT * FROM employee_inf WHERE ID=#{ID}")
    public Employee selectEmployeeById(@Param("ID") Integer ID);
	
	//通过JOB_ID查询
	@Select("SELECT * FROM employee_inf WHERE JOB_ID=#{JOB_ID}")
    public List<Employee> selectEmployeeByJobId(Integer JOB_ID);
	
	//通过DEPT_ID查询
	@Select("SELECT * FROM employee_inf WHERE DEPT_ID=#{DEPT_ID}")
    public List<Employee> selectEmployeeByDeptId(Integer DEPT_ID);
	
	
	//动态插入部门
	@InsertProvider(type=EmployeeProvider.class,method="insertEmployee")
	@Options(useGeneratedKeys=true,keyProperty="ID")
	int InsertEmployee(Employee employee);

	//更新部门信息
	@UpdateProvider(type=EmployeeProvider.class,method="updateEmployee")
	int updateEmployee(Employee employee);

	//通过id删除部门
	@Delete("delete from employee_inf WHERE ID=#{ID}")
    public int deleteEmployee(@Param("ID") Integer ID);

}

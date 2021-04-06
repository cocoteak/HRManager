package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.Domian.Employee;

public interface EmployeeService {
    //分页查询
	List<Employee> selectEmployeeWithParamPage(Map map);
	
	//查询数据总数
	List<Employee> selectEmployeeAccount(Map map);
	
  //通过id查询员工
    public  Employee selectEmployeeById(Integer ID);
	
	//动态插入员工
    public int InsertEmployee(Employee employee);

	//更新员工信息
	int updateEmployee(Employee employee);

	//通过id删除员工
    public int deleteEmployee(@Param("ID") Integer ID);
    
  //通过JOB_ID查询
    public List<Employee> selectEmployeeByJobId(Integer JOB_ID);
	
	//通过DEPT_ID查询
    public List<Employee> selectEmployeeByDeptId(Integer DEPT_ID);
}

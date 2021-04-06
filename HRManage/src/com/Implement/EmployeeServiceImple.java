package com.Implement;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.Dao.EmployeeDao;
import com.Domian.Employee;
import com.Service.EmployeeService;

@Service("employeeServiceImple")
public class EmployeeServiceImple implements EmployeeService {
	@Resource(name="employeeDao")
	EmployeeDao employeeDao;

	@Override
	public List<Employee> selectEmployeeAccount(Map map) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmployeeAccount(map);
	}

	@Override
	public List<Employee> selectEmployeeWithParamPage(Map map) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmployeeWithParamPage(map);
	}

	@Override
	public int InsertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.InsertEmployee(employee);
	}

	@Override
	public Employee selectEmployeeById(Integer ID) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmployeeById(ID);
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public int deleteEmployee(Integer ID) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(ID);
	}

	@Override
	public List<Employee> selectEmployeeByDeptId(Integer DEPT_ID) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmployeeByDeptId(DEPT_ID);
	}

	@Override
	public List<Employee> selectEmployeeByJobId(Integer JOB_ID) {
		// TODO Auto-generated method stub
     	return employeeDao.selectEmployeeByJobId(JOB_ID);
	}


}

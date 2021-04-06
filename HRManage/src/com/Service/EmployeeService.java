package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.Domian.Employee;

public interface EmployeeService {
    //��ҳ��ѯ
	List<Employee> selectEmployeeWithParamPage(Map map);
	
	//��ѯ��������
	List<Employee> selectEmployeeAccount(Map map);
	
  //ͨ��id��ѯԱ��
    public  Employee selectEmployeeById(Integer ID);
	
	//��̬����Ա��
    public int InsertEmployee(Employee employee);

	//����Ա����Ϣ
	int updateEmployee(Employee employee);

	//ͨ��idɾ��Ա��
    public int deleteEmployee(@Param("ID") Integer ID);
    
  //ͨ��JOB_ID��ѯ
    public List<Employee> selectEmployeeByJobId(Integer JOB_ID);
	
	//ͨ��DEPT_ID��ѯ
    public List<Employee> selectEmployeeByDeptId(Integer DEPT_ID);
}

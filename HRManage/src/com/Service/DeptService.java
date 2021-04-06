package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.Domian.Dept;
import com.Domian.User;

public interface DeptService {
    //分页查询
	List<Dept> selectDeptWithParamPage(Map map);
	
	//查询数据总数
	List<Dept> selectDeptAccount(Map map);
	
	//全部查询
    public List<Dept> selectAllDept();
	
	//通过部门名查询
    public Dept selectDeptByName(String NAME);
    
  //通过id查询
    public Dept selectDeptById(Integer ID);
	
	//动态插入部门
	int InsertDept(Dept dept);

	//更新部门信息
	int updateDept(Dept dept);

	//通过id删除部门
    public int deleteDept(@Param("ID") Integer ID);
}

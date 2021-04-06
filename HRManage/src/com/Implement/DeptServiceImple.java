package com.Implement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.Dao.DeptDao;
import com.Domian.Dept;
import com.Service.DeptService;


@Service("deptServiceImple")
public class DeptServiceImple implements DeptService {
	@Resource(name="deptDao")
	DeptDao deptDao;

	@Override
	public int InsertDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.InsertDept(dept);
	}

	@Override
	public int deleteDept(Integer ID) {
		// TODO Auto-generated method stub
		return deptDao.deleteDept(ID);
	}

	@Override
	public List<Dept> selectDeptAccount(Map map) {
		// TODO Auto-generated method stub
		return deptDao.selectDeptAccount(map);
	}

	@Override
	public List<Dept> selectDeptWithParamPage(Map map) {
		// TODO Auto-generated method stub
		return deptDao.selectDeptWithParamPage(map);
	}

	@Override
	public int updateDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.updateDept(dept);
	}

	@Override
	public Dept selectDeptByName(String NAME) {
		// TODO Auto-generated method stub
		return deptDao.selectDeptByName(NAME);
	}

	@Override
	public Dept selectDeptById(Integer ID) {
		// TODO Auto-generated method stub
		return deptDao.selectDeptById(ID);
	}

	@Override
	public List<Dept> selectAllDept() {
		// TODO Auto-generated method stub
		return deptDao.selectAllDept();
	}
}

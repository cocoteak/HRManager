package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.Domian.Dept;
import com.Domian.User;

public interface DeptService {
    //��ҳ��ѯ
	List<Dept> selectDeptWithParamPage(Map map);
	
	//��ѯ��������
	List<Dept> selectDeptAccount(Map map);
	
	//ȫ����ѯ
    public List<Dept> selectAllDept();
	
	//ͨ����������ѯ
    public Dept selectDeptByName(String NAME);
    
  //ͨ��id��ѯ
    public Dept selectDeptById(Integer ID);
	
	//��̬���벿��
	int InsertDept(Dept dept);

	//���²�����Ϣ
	int updateDept(Dept dept);

	//ͨ��idɾ������
    public int deleteDept(@Param("ID") Integer ID);
}

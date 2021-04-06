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
	//��ҳ��ѯ
	@SelectProvider(type=DeptProvider.class,method="selectDeptWithPage")
	List<Dept> selectDeptWithParamPage(Map map);
	
	//��ѯ��������
	@SelectProvider(type=DeptProvider.class,method="selectDeptAcount")
	List<Dept> selectDeptAccount(Map map);
	
	//ȫ����ѯ
	@Select("SELECT * FROM dept_inf")
    public List<Dept> selectAllDept();
	
	//ͨ����������ѯ
	@Select("SELECT * FROM dept_inf WHERE NAME=#{NAME}")
    public Dept selectDeptByName(@Param("NAME") String NAME);
	
	//ͨ��id��ѯ
	@Select("SELECT * FROM dept_inf WHERE ID=#{ID}")
    public Dept selectDeptById(@Param("ID") Integer ID);
	
	//��̬���벿��
	@InsertProvider(type=DeptProvider.class,method="insertDept")
	@Options(useGeneratedKeys=true,keyProperty="ID")
	int InsertDept(Dept dept);

	//���²�����Ϣ
	@UpdateProvider(type=DeptProvider.class,method="updateDept")
	int updateDept(Dept dept);

	//ͨ��idɾ������
	@Delete("delete from dept_inf WHERE ID=#{ID}")
    public int deleteDept(@Param("ID") Integer ID);

}

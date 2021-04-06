package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.Domian.Job;

public interface JobService {
    //��ҳ��ѯ
	List<Job> selectJobWithParamPage(Map map);
	
	//��ѯ��������
	List<Job> selectJobAccount(Map map);
	
	//ȫ����ѯ
    public List<Job> selectAllJob();
	
	//ͨ����������ѯ
    public Job selectJobByName(String NAME);
    
  //ͨ��id��ѯ
    public Job selectJobById(Integer ID);
	
	//��̬���벿��
	int InsertJob(Job job);

	//���²�����Ϣ
	int updateJob(Job job);

	//ͨ��idɾ������
    public int deleteJob(@Param("ID") Integer ID);
}

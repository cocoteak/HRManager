package com.Implement;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.Dao.JobDao;
import com.Domian.Job;
import com.Service.JobService;


@Service("jobServiceImple")
public class JobServiceImple implements JobService {
	@Resource(name="jobDao")
	JobDao jobDao;

	@Override
	public int InsertJob(Job job) {
		// TODO Auto-generated method stub
		return jobDao.InsertJob(job);
	}

	@Override
	public int deleteJob(Integer ID) {
		// TODO Auto-generated method stub
		return jobDao.deleteJob(ID);
	}

	@Override
	public List<Job> selectJobAccount(Map map) {
		// TODO Auto-generated method stub
		return jobDao.selectJobAccount(map);
	}

	@Override
	public Job selectJobById(Integer ID) {
		// TODO Auto-generated method stub
		return jobDao.selectJobById(ID);
	}

	@Override
	public Job selectJobByName(String NAME) {
		// TODO Auto-generated method stub
		return jobDao.selectJobByName(NAME);
	}

	@Override
	public List<Job> selectJobWithParamPage(Map map) {
		// TODO Auto-generated method stub
		return jobDao.selectJobWithParamPage(map);
	}

	@Override
	public int updateJob(Job job) {
		// TODO Auto-generated method stub
		return jobDao.updateJob(job);
	}

	@Override
	public List<Job> selectAllJob() {
		// TODO Auto-generated method stub
		return jobDao.selectAllJob();
	}

	
}

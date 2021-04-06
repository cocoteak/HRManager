package com.Implement;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.Dao.EmployeeDao;
import com.Dao.NoticeDao;
import com.Domian.Employee;
import com.Domian.Notice;
import com.Service.EmployeeService;
import com.Service.NoticeService;

@Service("noticeServiceImple")
public class NoticeServiceImple implements NoticeService {
	@Resource(name="noticeDao")
	NoticeDao noticeDao;

	@Override
	public List<Notice> selectNoticeAccount(Map map) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeAccount(map);
	}

	@Override
	public List<Notice> selectNoticeWithParamPage(Map map) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeWithParamPage(map);
	}

	@Override
	public int insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		return  noticeDao.insertNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.updateNotice(notice);
	}

	@Override
	public Notice selectNoticeById(Integer ID) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeById(ID);
	}

	@Override
	public int deleteNotice(Integer ID) {
		// TODO Auto-generated method stub
		return noticeDao.deleteNotice(ID);
	}
}

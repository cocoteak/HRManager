package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.Domian.Notice;

public interface NoticeService {
    //分页查询
	List<Notice> selectNoticeWithParamPage(Map map);
	
	//查询数据总数
	List<Notice> selectNoticeAccount(Map map);
	   
  //通过id查询
    public Notice selectNoticeById(Integer ID);
	
	//动态插入部门
	int insertNotice(Notice notice);

	//更新部门信息
	int updateNotice(Notice notice);

	//通过id删除部门
	public int deleteNotice(Integer ID);
	
}

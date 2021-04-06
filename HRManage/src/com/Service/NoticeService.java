package com.Service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.Domian.Notice;

public interface NoticeService {
    //��ҳ��ѯ
	List<Notice> selectNoticeWithParamPage(Map map);
	
	//��ѯ��������
	List<Notice> selectNoticeAccount(Map map);
	   
  //ͨ��id��ѯ
    public Notice selectNoticeById(Integer ID);
	
	//��̬���벿��
	int insertNotice(Notice notice);

	//���²�����Ϣ
	int updateNotice(Notice notice);

	//ͨ��idɾ������
	public int deleteNotice(Integer ID);
	
}

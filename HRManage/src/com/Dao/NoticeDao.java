package com.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.Domian.Notice;
import com.Provider.NoticeProvider;

@Repository("noticeDao")
public interface NoticeDao {
	//��ҳ��ѯ
	@SelectProvider(type=NoticeProvider.class,method="selectNoticeWithPage")
	@Results({
		@Result(column="USER_ID",property="user",one=@One(select="com.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
		@Result(column="USER_ID",property="USER_ID")
	})
	List<Notice> selectNoticeWithParamPage(Map map);
	
	//��ѯ��������
	@SelectProvider(type=NoticeProvider.class,method="selectNoticeAcount")
	List<Notice> selectNoticeAccount(Map map);
	

	//ͨ��id��ѯ
	@Select("SELECT * FROM notice_inf WHERE ID=#{ID}")
    public Notice selectNoticeById(@Param("ID") Integer ID);
	
	
	//��̬���벿��
	@InsertProvider(type=NoticeProvider.class,method="insertNotice")
	@Options(useGeneratedKeys=true,keyProperty="ID")
	int insertNotice(Notice notice);

	//���²�����Ϣ
	@UpdateProvider(type=NoticeProvider.class,method="updateNotice")
	int updateNotice(Notice notice);
	

	//ͨ��idɾ������
	@Delete("delete from notice_inf WHERE ID=#{ID}")
    public int deleteNotice(@Param("ID") Integer ID);

}

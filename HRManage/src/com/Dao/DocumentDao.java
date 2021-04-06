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

import com.Domian.Document;
import com.Domian.Notice;
import com.Provider.DocumentProvider;
import com.Provider.NoticeProvider;

@Repository("documentDao")
public interface DocumentDao {
	//分页查询
	@SelectProvider(type=DocumentProvider.class,method="selectDocumentWithPage")
	@Results({
		@Result(column="USER_ID",property="user",one=@One(select="com.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
		@Result(column="USER_ID",property="USER_ID")
	})
	List<Document> selectDocumentWithParamPage(Map map);
	
	//查询数据总数
	@SelectProvider(type=DocumentProvider.class,method="selectDocumentAcount")
	List<Document> selectDocumentAccount(Map map);
	
	//通过id查询
	@Select("SELECT * FROM document_inf WHERE ID=#{ID}")
    public Document selectDocumentById(@Param("ID") Integer ID);
	
	
	//动态插入
	@InsertProvider(type=DocumentProvider.class,method="insertDocument")
	@Options(useGeneratedKeys=true,keyProperty="ID")
	int insertDocument(Document document);

	//更新信息
	@UpdateProvider(type=DocumentProvider.class,method="updateDocument")
	int updateDocument(Document document);

	//通过id删除
	@Delete("delete from document_inf WHERE ID=#{ID}")
    public int deleteDocument(@Param("ID") Integer ID);

}

package com.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.Domian.Document;

public interface DocumentService {
    //分页查询
	List<Document> selectDocumentWithParamPage(Map map);
	
	//查询数据总数
	List<Document> selectDocumentAccount(Map map);
	    
  //通过id查询
    public Document selectDocumentById(Integer ID);
	
	//动态插入部门
	int insertDocument(Document document);

	int updateDocument(Document document);

    public int deleteDocument(Integer ID);
}

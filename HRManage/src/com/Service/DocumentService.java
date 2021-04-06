package com.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.Domian.Document;

public interface DocumentService {
    //��ҳ��ѯ
	List<Document> selectDocumentWithParamPage(Map map);
	
	//��ѯ��������
	List<Document> selectDocumentAccount(Map map);
	    
  //ͨ��id��ѯ
    public Document selectDocumentById(Integer ID);
	
	//��̬���벿��
	int insertDocument(Document document);

	int updateDocument(Document document);

    public int deleteDocument(Integer ID);
}

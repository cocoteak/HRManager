package com.Implement;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.Dao.DocumentDao;
import com.Domian.Document;
import com.Service.DocumentService;


@Service("documentServiceImple")
public class DocumentServiceImple implements DocumentService {
	@Resource(name="documentDao")
	DocumentDao documentDao;

	@Override
	public List<Document> selectDocumentAccount(Map map) {
		// TODO Auto-generated method stub
		return documentDao.selectDocumentAccount(map);
	}

	@Override
	public List<Document> selectDocumentWithParamPage(Map map) {
		// TODO Auto-generated method stub
		return documentDao.selectDocumentWithParamPage(map);
	}

	@Override
	public int insertDocument(Document document) {
		// TODO Auto-generated method stub
		return documentDao.insertDocument(document);
	}

	@Override
	public int deleteDocument(Integer ID) {
		// TODO Auto-generated method stub
		return documentDao.deleteDocument(ID);
	}

	@Override
	public int updateDocument(Document document) {
		// TODO Auto-generated method stub
		return documentDao.updateDocument(document);
	}

	@Override
	public Document selectDocumentById(Integer ID) {
		// TODO Auto-generated method stub
		return documentDao.selectDocumentById(ID);
	}

}

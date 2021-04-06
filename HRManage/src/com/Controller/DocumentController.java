package com.Controller;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Domian.Document;
import com.Domian.User;
import com.Implement.DocumentServiceImple;
import com.Implement.UserServiceImple;
import com.Util.PageShow;

@Controller
public class DocumentController {
	@Resource(name="userServiceImple")
	UserServiceImple userServiceImple;
	
	@Resource(name="documentServiceImple")
	 DocumentServiceImple documentServiceImple;
	
	int pageSize=3;
	
	//��ѯ�û�
	@RequestMapping(value ="/selectDocument")
	public String selectWithDocument(@RequestParam(value="pageNow",defaultValue="1")int pageNow,Document paramDocument,Model model) {
		//��ҳ
		Map map=new HashMap();
		map.put("document",paramDocument);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		List<Document> listDocument= documentServiceImple.selectDocumentWithParamPage(map);
		List<User> userList= userServiceImple.selectAllUser();
		
		int totalSize=documentServiceImple.selectDocumentAccount(map).size();
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//��ֵ
		model.addAttribute("listDocument",listDocument);
		model.addAttribute("userList",userList);

		
		model.addAttribute("paramDocument",paramDocument);
		model.addAttribute("pageNow",pageNow);
		int totalPage=ps.getTotalPage();
		model.addAttribute("totalPage",totalPage);

		boolean isHasFirst=ps.isHasFirst();
		model.addAttribute("isHasFirst",isHasFirst);
		boolean isHasPre=ps.isHasPre();
		model.addAttribute("isHasPre",isHasPre);
		boolean isHasNext=ps.isHasNext();
		model.addAttribute("isHasNext",isHasNext);
		boolean isHasLast=ps.isHasLast();
		model.addAttribute("isHasLast",isHasLast);
		
		return "document/select";
	}
	
	@RequestMapping(value="/uploads")
	public String uploads(Model model){
		return "document/insert";
	}
	
	@RequestMapping(value="/upload")
	public  String show(@RequestParam("file1")MultipartFile files,Model model,Document document,HttpSession session){
		if(files!=null){
			//�õ�·��
			String path=session.getServletContext().getRealPath("file");
			//���ļ���
			User user=(User)session.getAttribute("user");
			Integer userId=user.getID();
			String filename=files.getOriginalFilename();
			document.setFilename(filename);
			document.setUSER_ID(userId);
			
			File newfile=new File(path+"\\"+userId+"\\"+filename);  
			
			//�ж�·���Ƿ����
			if(!newfile.getParentFile().exists()){
				newfile.getParentFile().mkdirs();
			}
			try {
				System.out.println(path);
				files.transferTo(newfile);
				documentServiceImple.insertDocument(document);
				System.out.println(document);
				return "redirect:selectDocument";
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//			String dmsg="��ѡ���ļ����ϴ���";
//			session.setAttribute("dmsg",dmsg);
			return "redirect:uploads";
	}


	@RequestMapping(value="/down")
    public  ResponseEntity<byte[]> downloda(HttpSession session,Integer uId,String filename){    	
    	String path=session.getServletContext().getRealPath("file");
    	String filename2 = null;
        try {
            //����ҵ��ļ�����:
            // URLEonder��������UTF-8����,Ȼ��,tomcat��iso-8859-1����
            //,������Ҫ��iso-8859-1����,��������utf-8�������ƥ�䵽Ӳ���ļ�������
            filename2 = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        File file = new File(path+"\\"+uId+"\\"+filename2);
        HttpHeaders headers = new HttpHeaders();
        String filename3 = null;
        try {
            //�����ʾ���ؿ����������:
            // �������������ʹ�ñ��ر��룬�����Ĳ���ϵͳʹ��GBK
            // ������յ�����ļ����󣬻�ʹ��iso-8859-1������
            //��������:��������GBK����Ϊ�ֽ�����,����ISO-8859-1����,���������ISO-8859-1����Ϊ�ֽ�����,����GBK����Ϊ����
            filename3 = new String(filename2.getBytes("GBK"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        headers.setContentDispositionFormData("attachment", filename3);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	@RequestMapping(value="/updateDocument")
	public String updateInfo(@ModelAttribute("ID")Integer ID, Model model,HttpSession session){
		Document document= documentServiceImple.selectDocumentById(ID);
		model.addAttribute("upDocument",document);
		session.setAttribute("documentID",ID);
		return "document/update";
	}
	
	@RequestMapping(value = "/updateHandleDocument")
	public String updateHandles(Model model,HttpSession session,Document upDocument) {
		Integer ID=(Integer) session.getAttribute("documentID");
		upDocument.setID(ID);
		Integer dId=documentServiceImple.selectDocumentById(ID).getUSER_ID();
		String filename=documentServiceImple.selectDocumentById(ID).getFilename();
		//�õ�·��
		String path=session.getServletContext().getRealPath("file");
    	File oldfile=new File(path+"\\"+dId+"\\"+filename);
		File newfile=new File(path+"\\"+dId+"\\"+upDocument.getFilename());
		System.out.println(dId);
		System.out.println(filename);
		System.out.println(oldfile);
		System.out.println(newfile);
		System.out.println(oldfile.renameTo(newfile));
    	documentServiceImple.updateDocument(upDocument);
		return "redirect:selectDocument";
	}
	
	
	@RequestMapping(value = "/deleteDocument")
	public String deleteMore(int[] ids, HttpSession session) {
			String path=session.getServletContext().getRealPath("file");
			for (int i = 0; i < ids.length; i++){
				Integer dId=documentServiceImple.selectDocumentById(ids[i]).getUSER_ID();
				String filename=documentServiceImple.selectDocumentById(ids[i]).getFilename();
				File file=new File(path+"\\"+dId+"\\"+filename);
				System.out.println(file.delete());
				documentServiceImple.deleteDocument(ids[i]);
		    }
			return "redirect:selectDocument";
		}
}

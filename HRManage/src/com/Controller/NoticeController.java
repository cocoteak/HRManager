package com.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.Domian.Notice;
import com.Domian.User;
import com.Implement.NoticeServiceImple;
import com.Implement.UserServiceImple;
import com.Util.PageShow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticeController {
	@Resource(name="userServiceImple")
	UserServiceImple userServiceImple;
	
	@Resource(name="noticeServiceImple")
	NoticeServiceImple noticeServiceImple;
	
	int pageSize=3;
	
	//查询用户
	@RequestMapping(value = "/selectNotice")
	public String selectWithEmployee(@RequestParam(value="pageNow",defaultValue="1")int pageNow,Notice paramNotice,Model model) {
		//分页
		Map map=new HashMap();
		map.put("notice",paramNotice);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		List<Notice> listNotice= noticeServiceImple.selectNoticeWithParamPage(map);
		List<User> userList= userServiceImple.selectAllUser();
		
		int totalSize= noticeServiceImple.selectNoticeAccount(map).size();
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//传值
		model.addAttribute("listNotice",listNotice);
		model.addAttribute("userList",userList);

		
		model.addAttribute("paramNotice",paramNotice);
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
		
		return "notice/select";
	}
	
	@RequestMapping(value = "/insertNotice")
	public String insert(Model model) {
		Notice inNotice = new Notice();
		model.addAttribute("inNotice", inNotice);
		return "notice/insert";
	}
	
	@RequestMapping(value="/insertNotice2")
	public String insertNotice(@Validated @ModelAttribute("inNotice")Notice inNotice, Errors error, Model model,HttpSession session) {
		if (error.hasErrors()) {
			return "notice/insert";
		} else {
			User user=(User)session.getAttribute("user");
			Integer userId=user.getID();
			System.out.println(userId);
			inNotice.setUSER_ID(userId);
			System.out.println(inNotice);
			noticeServiceImple.insertNotice(inNotice);
			return "redirect:selectNotice";
		}
	}
	
	@RequestMapping(value="/updateNotice")
	public String updateInfo(@ModelAttribute("ID")Integer ID, Model model,HttpSession session){
		Notice notice= noticeServiceImple.selectNoticeById(ID);
		model.addAttribute("upNotice",notice);
		session.setAttribute("noticeID",ID);
		return "notice/update";
	}
	
	@RequestMapping(value = "/updateHandleNotice")
	public String updateHandles(@Validated @ModelAttribute("upNotice")Notice upNotice, Errors error,
			Model model, HttpSession session) {
		if (error.hasErrors()) {
			return "notice/update";
		}
		Integer ID=(Integer) session.getAttribute("noticeID");
		upNotice.setID(ID);
		noticeServiceImple.updateNotice(upNotice);
		return "redirect:selectNotice";
	}
	
	@RequestMapping(value = "/deleteNotice")
	public String deleteMore(int[] ids, HttpSession session) {
			for (int i = 0; i < ids.length; i++){
				noticeServiceImple.deleteNotice(ids[i]);
		    }
			return "redirect:selectNotice";
		}
	
	@RequestMapping("/noticePreview")
	public String noticePreview(Notice notice,int id,Model model){
		Notice notices=noticeServiceImple.selectNoticeById(id);
		model.addAttribute("notice",notices);
		return "notice/preview";
	}
}

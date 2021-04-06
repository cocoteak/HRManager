package com.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import com.Domian.User;
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
public class UserController {
	@Resource(name="userServiceImple")
	UserServiceImple userServiceImple;
	
	int pageSize=3;
	
	//��ѯ�û�
	@RequestMapping(value = "/selectWithPage")
	public String selectWithPage(@RequestParam(value="pageNow",defaultValue="1")int pageNow,User paramUser,Model model) {
		//��ҳ
		Map map=new HashMap();
		map.put("user",paramUser);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		List<User> listUser= userServiceImple.selectUserWithParamPage(map);
		int totalSize=userServiceImple.selectUserAccount(map).size();
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//��ֵ
		model.addAttribute("listUser",listUser);
		model.addAttribute("paramUser",paramUser);
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
		
		return "user/select";
	}
	
	@RequestMapping(value = "/insertUser")
	public String insert(Model model) {
		User inUser = new User();
		model.addAttribute("inUser", inUser);
		return "user/insert";
	}
	
	@RequestMapping(value="/insertHandle")
	public String insertUser(@Validated @ModelAttribute("inUser")User inUser, Errors error, Model model) {
		if (error.hasErrors()) {
			System.out.println(error.getFieldErrors());
			return "user/insert";
		} else {
			User user = userServiceImple.selectUserByName(inUser.getLoginname());
			if (user != null) {
				String msg = "��¼���Ѵ���,���������룡";
				model.addAttribute("msg", msg);
				return "user/insert";
			}
			userServiceImple.InsertUser(inUser);
			return "redirect:selectWithPage";
		}
	}
	
	@RequestMapping(value="/updateUser")
	public String updateInfo(@ModelAttribute("ID")Integer ID,Model model,HttpSession session){
		User upUser= userServiceImple.selectUserById(ID);
		model.addAttribute("upUser", upUser);
		session.setAttribute("oldUser", upUser);
		session.setAttribute("ID",ID);
		return "user/update";
	}
	
	@RequestMapping(value = "/updateHandle")
	public String updateHandles(@Validated @ModelAttribute("upUser") User upUser, Errors error,
			Model model, HttpSession session) {
		if (error.hasErrors()) {
			return "user/update";
		}
		User user2 = userServiceImple.selectUserByName(upUser.getLoginname());

		// ���ݿ��е�ԭ����
		User oldUser = (User) session.getAttribute("oldUser");
		Integer ID= (Integer) session.getAttribute("ID");
		upUser.setID(ID);

		if (oldUser.toString().equals(upUser.toString())) {
			System.out.println("δ�޸���Ϣ");
		} else { // ��ǰ�û���Ϣ���޸�
			// �޸��û���
			if (!oldUser.getLoginname().equals(upUser.getLoginname())) {
				if (user2 != null) {
					String msg2 = "��¼���Ѵ���,���������룡";
					model.addAttribute("msg2", msg2);
					return "user/update";
				}
			}
				userServiceImple.updateUser(upUser);
			// ��ǰ�����ߵ�����
				User user = (User) session.getAttribute("user");
			// ��ǰ�������Ƿ��޸��Լ�����Ϣ
			if (oldUser.getID() == user.getID()) {
				session.setAttribute("user", upUser);
			}
		}
		return "redirect:selectWithPage";
	}
	
	@RequestMapping(value = "/deleteMore")
	public String deleteMore(int[] ids, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (!user.getUsername().equals("��������Ա")) {
			String msg3 = "�����ǹ���Ա���޷�ɾ���û���Ϣ��";
			session.setAttribute("msg3", msg3);
			return "redirect:selectWithPage";
		} else {
			for (int i = 0; i < ids.length; i++) {
				if (ids[i]==user.getID()) {
					String msg4 = "����ɾ���Լ�����Ϣ��";
					session.setAttribute("msg4", msg4);
					System.out.println(4);
					return "redirect:selectWithPage";
				} else {
					userServiceImple.deleteUser(ids[i]);
				}
			}
			return "redirect:selectWithPage";
		}
	}
	
	
}

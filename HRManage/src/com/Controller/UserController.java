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
	
	//查询用户
	@RequestMapping(value = "/selectWithPage")
	public String selectWithPage(@RequestParam(value="pageNow",defaultValue="1")int pageNow,User paramUser,Model model) {
		//分页
		Map map=new HashMap();
		map.put("user",paramUser);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		List<User> listUser= userServiceImple.selectUserWithParamPage(map);
		int totalSize=userServiceImple.selectUserAccount(map).size();
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//传值
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
				String msg = "登录名已存在,请重新输入！";
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

		// 数据库中的原数据
		User oldUser = (User) session.getAttribute("oldUser");
		Integer ID= (Integer) session.getAttribute("ID");
		upUser.setID(ID);

		if (oldUser.toString().equals(upUser.toString())) {
			System.out.println("未修改信息");
		} else { // 当前用户信息已修改
			// 修改用户名
			if (!oldUser.getLoginname().equals(upUser.getLoginname())) {
				if (user2 != null) {
					String msg2 = "登录名已存在,请重新输入！";
					model.addAttribute("msg2", msg2);
					return "user/update";
				}
			}
				userServiceImple.updateUser(upUser);
			// 当前操作者的数据
				User user = (User) session.getAttribute("user");
			// 当前操作者是否修改自己的信息
			if (oldUser.getID() == user.getID()) {
				session.setAttribute("user", upUser);
			}
		}
		return "redirect:selectWithPage";
	}
	
	@RequestMapping(value = "/deleteMore")
	public String deleteMore(int[] ids, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (!user.getUsername().equals("超级管理员")) {
			String msg3 = "您不是管理员，无法删除用户信息！";
			session.setAttribute("msg3", msg3);
			return "redirect:selectWithPage";
		} else {
			for (int i = 0; i < ids.length; i++) {
				if (ids[i]==user.getID()) {
					String msg4 = "不能删除自己的信息！";
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

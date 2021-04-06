package com.Controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import com.Domian.User;
import com.Implement.UserServiceImple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class commonController {
	@Resource(name="userServiceImple")
	UserServiceImple userServiceImple;
	
    //ͨ��Controller��תҳ��
	@RequestMapping(value = "/{aa}")
	public String commonTrans(@PathVariable String aa) {
		return aa;
	}
	 //ͨ��DAO����jsp��תҳ��
	@RequestMapping(value = "/{bb}/{cc}")
	public String commonTran(@PathVariable String bb,@PathVariable String cc) {
		return bb+"/"+cc;
	}
	//��¼ҳ��
	@RequestMapping(value = "/index")
	public String login(Model model) {
		return "Login";
	}

	@RequestMapping(value = "/show")
	public String select(User user, HttpSession session, Model model) {
		User user1 = (User) session.getAttribute("user");
		if (user1 != null) {
			return "Main";
		} else {
			User users = userServiceImple.selectUser(user.getLoginname(),user.getPASSWORD());
			if (users != null) {
				session.setAttribute("user", users);
				return "Main";
			} else {
				String msg = "��¼����������������������룡";
				model.addAttribute("msg", msg);
				return "index";
			}
		}
	}
	//��¼ҳ��
	@RequestMapping(value = "/sessionRemove")
	public String sesssion(HttpSession session) {
		session.removeAttribute("user");
		return "Login";
	}
	
}

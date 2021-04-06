package com.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.Domian.Dept;
import com.Domian.Employee;
import com.Implement.DeptServiceImple;
import com.Implement.EmployeeServiceImple;
import com.Util.PageShow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeptController {
	@Resource(name="deptServiceImple")
	DeptServiceImple deptServiceImple;
	
	@Resource(name="employeeServiceImple")
	EmployeeServiceImple employeeServiceImple;
	
	int pageSize=3;
	
	//��ѯ�û�
	@RequestMapping(value = "/selectDept")
	public String selectWithDept(@RequestParam(value="pageNow",defaultValue="1")int pageNow,Dept paramDept,Model model) {
		//��ҳ
		Map map=new HashMap();
		map.put("dept",paramDept);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		List<Dept> listDept= deptServiceImple.selectDeptWithParamPage(map);
		int totalSize=deptServiceImple.selectDeptAccount(map).size();
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//��ֵ
		model.addAttribute("listDept",listDept);
		model.addAttribute("paramDept",paramDept);
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
		
		return "dept/select";
	}
	
	@RequestMapping(value = "/insertDept")
	public String insert(Model model) {
		Dept inDept = new Dept();
		model.addAttribute("inDept", inDept);
		return "dept/insert";
	}
	
	@RequestMapping(value="/insertDept2")
	public String insertDept(@Validated @ModelAttribute("inDept")Dept inDept, Errors error, Model model,String ddmsg) {
		if (error.hasErrors()) {
			return "dept/insert";
		} else {
			Dept dept= deptServiceImple.selectDeptByName(inDept.getNAME());
			if (dept != null) {
				String msg = "�������Ѵ���,���������룡";
				model.addAttribute("msg", msg);
				return "dept/insert";
			}
			deptServiceImple.InsertDept(inDept);
			return "redirect:selectDept";
		}
	}
	
	@RequestMapping(value="/updateDept")
	public String updateInfo(@ModelAttribute("ID")Integer ID, Model model,HttpSession session){
		Dept dept= deptServiceImple.selectDeptById(ID);
		model.addAttribute("upDept",dept);
		session.setAttribute("oldDept",dept);
		session.setAttribute("deptID",ID);
		return "dept/update";
	}
	
	@RequestMapping(value = "/updateHandleDept")
	public String updateHandles(@Validated @ModelAttribute("upDept")Dept upDept, Errors error,
			Model model, HttpSession session) {
		if (error.hasErrors()) {
			return "dept/update";
		}
		Dept dept= deptServiceImple.selectDeptByName(upDept.getNAME());
		Integer ID=(Integer) session.getAttribute("deptID");
		upDept.setID(ID);
		
		// ���ݿ��е�ԭ����
		Dept oldDept = (Dept) session.getAttribute("oldDept");
		
			// �޸Ĳ�����
			if (!oldDept.getNAME().equals(upDept.getNAME())) {
				if (dept!= null) {
					String msg2 = "�������Ѵ���,���������룡";
					model.addAttribute("msg2", msg2);
					return "dept/update";
				}
			}
			deptServiceImple.updateDept(upDept);
			return "redirect:selectDept";
	}
	
	@RequestMapping(value = "/deleteDept")
	public String deleteMore(int[] ids,HttpSession session) {
			for (int i = 0; i < ids.length; i++){
			   List<Employee> e= employeeServiceImple.selectEmployeeByDeptId(ids[i]);
			   if(e.size()!=0){
				   String dept=deptServiceImple.selectDeptById(ids[i]).getNAME();
				   String ddmsg=dept+"��ְԱ����Ϊ0,�����޷�ɾ����";
				   session.setAttribute("ddmsg", ddmsg);
				   return "redirect:selectDept";
			   }else{
		           deptServiceImple.deleteDept(ids[i]);
		       }
		    }
			return "redirect:selectDept";
		}
}

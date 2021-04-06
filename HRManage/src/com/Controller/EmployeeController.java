package com.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.Domian.Dept;
import com.Domian.Employee;
import com.Domian.Job;
import com.Implement.DeptServiceImple;
import com.Implement.EmployeeServiceImple;
import com.Implement.JobServiceImple;
import com.Util.PageShow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Resource(name="employeeServiceImple")
	EmployeeServiceImple employeeServiceImple;
	
	@Resource(name="deptServiceImple")
	DeptServiceImple deptServiceImple;
	
	@Resource(name="jobServiceImple")
	JobServiceImple jobServiceImple;
	
	int pageSize=3;
	
	//查询用户
	@RequestMapping(value = "/selectEmployee")
	public String selectWithEmployee(@RequestParam(value="pageNow",defaultValue="1")int pageNow,Employee paramEmployee,Model model) {
		//分页
		Map map=new HashMap();
		map.put("employee",paramEmployee);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		List<Employee> listEmployee= employeeServiceImple.selectEmployeeWithParamPage(map);
		List<Dept> deptList= deptServiceImple.selectAllDept();
		List<Job> jobList= jobServiceImple.selectAllJob();
		
		int totalSize= employeeServiceImple.selectEmployeeAccount(map).size();
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//传值
		model.addAttribute("listEmployee",listEmployee);
		model.addAttribute("deptList",deptList);
		model.addAttribute("jobList",jobList);
		
		model.addAttribute("paramEmployee",paramEmployee);
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
		
		return "employee/select";
	}
	
	@RequestMapping(value = "/insertEmployee")
	public String insert(Model model) {
		Employee inEmployee = new Employee();
		model.addAttribute("inEmployee", inEmployee);
		List<Dept> deptList= deptServiceImple.selectAllDept();
		List<Job> jobList= jobServiceImple.selectAllJob();
		model.addAttribute("deptList",deptList);
		model.addAttribute("jobList",jobList);
		return "employee/insert";
	}
	
	@RequestMapping(value="/insertEmployee2")
	public String insertEmployee(@Validated @ModelAttribute("inEmployee")Employee inEmployee, Errors error, Model model) {
		if (error.hasErrors()) {
			model.addAttribute("inEmployee", inEmployee);
			List<Dept> deptList= deptServiceImple.selectAllDept();
			List<Job> jobList= jobServiceImple.selectAllJob();
			model.addAttribute("deptList",deptList);
			model.addAttribute("jobList",jobList);
			return "employee/insert";
		} 
		    employeeServiceImple.InsertEmployee(inEmployee);
			return "redirect:selectEmployee";
	}
	
	@RequestMapping(value="/updateEmployee")
	public String updateInfo(@ModelAttribute("ID")Integer ID, Model model,HttpSession session){
		Employee employee= employeeServiceImple.selectEmployeeById(ID);
		List<Dept> deptList= deptServiceImple.selectAllDept();
		List<Job> jobList= jobServiceImple.selectAllJob();
		model.addAttribute("deptList",deptList);
		model.addAttribute("jobList",jobList);
		model.addAttribute("upEmployee",employee);
		session.setAttribute("employeeID",ID);
		return "employee/update";
	}
	
	@RequestMapping(value = "/updateHandleEmployee")
	public String updateHandles(@Validated @ModelAttribute("upEmployee")Employee upEmployee, Errors error,
			Model model, HttpSession session) {
		if (error.hasErrors()) {
			model.addAttribute("upEmployee",upEmployee);
			List<Dept> deptList= deptServiceImple.selectAllDept();
			List<Job> jobList= jobServiceImple.selectAllJob();
			model.addAttribute("deptList",deptList);
			model.addAttribute("jobList",jobList);
			return "employee/update";
		}
		Integer ID=(Integer) session.getAttribute("employeeID");
		upEmployee.setID(ID);
		employeeServiceImple.updateEmployee(upEmployee);
		return "redirect:selectEmployee";
	}
	
	@RequestMapping(value = "/deleteEmployee")
	public String deleteMore(int[] ids, HttpSession session) {
			for (int i = 0; i < ids.length; i++){
				employeeServiceImple.deleteEmployee(ids[i]);
		    }
			return "redirect:selectEmployee";
		}

}

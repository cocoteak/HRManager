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
public class JobController {
	@Resource(name="jobServiceImple")
	JobServiceImple jobServiceImple;
	
	@Resource(name="employeeServiceImple")
	EmployeeServiceImple employeeServiceImple;
	
	int pageSize=3;
	
	//查询用户
	@RequestMapping(value = "/selectJob")
	public String selectWithJob(@RequestParam(value="pageNow",defaultValue="1")int pageNow,Job paramJob,Model model) {
		//分页
		Map map=new HashMap();
		map.put("job",paramJob);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		List<Job> listJob= jobServiceImple.selectJobWithParamPage(map);
		int totalSize=jobServiceImple.selectJobAccount(map).size();
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//传值
		model.addAttribute("listJob",listJob);
		model.addAttribute("paramJob",paramJob);
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
		
		return "job/select";
	}
	
	@RequestMapping(value = "/insertJob")
	public String insert(Model model) {
		Job inJob = new Job();
		model.addAttribute("inJob", inJob);
		return "job/insert";
	}
	
	@RequestMapping(value="/insertJob2")
	public String insertJob(@Validated @ModelAttribute("inJob")Job inJob, Errors error, Model model) {
		if (error.hasErrors()) {
			return "job/insert";
		} else {
			Job job= jobServiceImple.selectJobByName(inJob.getNAME());
			if (job != null) {
				String msg = "职位名称已存在,请重新输入！";
				model.addAttribute("msg", msg);
				return "job/insert";
			}
			jobServiceImple.InsertJob(inJob);
			return "redirect:selectJob";
		}
	}
	
	@RequestMapping(value="/updateJob")
	public String updateInfo(@ModelAttribute("ID")Integer ID, Model model,HttpSession session){
		Job job= jobServiceImple.selectJobById(ID);
		model.addAttribute("upJob",job);
		session.setAttribute("oldJob",job);
		session.setAttribute("jobID",ID);
		return "job/update";
	}
	
	@RequestMapping(value = "/updateHandleJob")
	public String updateHandles(@Validated @ModelAttribute("upJob")Job upJob, Errors error,
			Model model, HttpSession session) {
		if (error.hasErrors()) {
			return "job/update";
		}
		Job job= jobServiceImple.selectJobByName(upJob.getNAME());
		Integer ID=(Integer) session.getAttribute("jobID");
		upJob.setID(ID);

		
		// 数据库中的原数据
		Job  oldJob  = (Job) session.getAttribute("oldJob");
		
			// 修改部门名
			if (!oldJob.getNAME().equals(upJob.getNAME())) {
				if (job!= null) {
					String msg2 = "职位名称已存在,请重新输入！";
					model.addAttribute("msg2", msg2);
					return "job/update";
				}
			}
			jobServiceImple.updateJob(upJob);
			return "redirect:selectJob";
	}
	
	@RequestMapping(value = "/deleteJob")
	public String deleteMore(int[] ids, HttpSession session) {
			for (int i = 0; i < ids.length; i++){
				  List<Employee> e= employeeServiceImple.selectEmployeeByJobId(ids[i]);
				   if(e.size()!=0){
					   String job=jobServiceImple.selectJobById(ids[i]).getNAME();
					   String djmsg=job+"中职员数不为0,部门无法删除！";
					   session.setAttribute("djmsg", djmsg);
				   }else{
					   jobServiceImple.deleteJob(ids[i]);
		          }
		     }
			return "redirect:selectJob";
		}		
}

package com.tj.ch17_2.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.service.EmpService;
import com.tj.ch17_2.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	
	@RequestMapping(value = "list", method = {RequestMethod.POST,RequestMethod.GET})
	public String list(String pageNum, Model model, Emp emp) {
		Paging paging = new Paging(empService.total(),pageNum,10,10);
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		model.addAttribute("list", empService.empList(emp));
		model.addAttribute("paging",paging);
		return "list";
	}
	
	@RequestMapping(value = "joinlist", method = {RequestMethod.POST,RequestMethod.GET})
	public String joinList(String pageNum, Model model) {
		Paging paging = new Paging(empService.total(),pageNum,10,10);
		model.addAttribute("joinlist", empService.empDeptList(pageNum));
		model.addAttribute("paging",paging);
		return "joinlist";
	}
	
	@RequestMapping(value = "detail",method = {RequestMethod.GET,RequestMethod.POST})
	public String detail(int empno,Model model) {
		model.addAttribute("detail",empService.detail(empno));
		return "detail";
	}
	@RequestMapping(value = "dummyinsert",method = RequestMethod.GET)
	public String insert(Model model) {
		empService.insertN(60);
		return "forward:joinlist.do";
	}
	
	@RequestMapping(value = "writeForm",method = RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "writeForm";
	}
	
	@RequestMapping(value = "write",method = RequestMethod.POST)
	public String write(Model model,Emp emp,String temphiredate) {
		emp.setHiredate(Timestamp.valueOf(temphiredate+" 04:04:04"));
		empService.insert(emp);
		return "forward:detail.do?empno="+emp.getEmpno();
	}
	
	@RequestMapping(value = "confirmNo",method = RequestMethod.GET)
	public String confirmNo(Model model,int empno,int mgr) {
		if(empService.detail(empno)!=null && empService.detail(mgr)!=null) {
			model.addAttribute("msg","사번 중복");
		}else {
			model.addAttribute("msg","사번 쓸 수 있음");
		}
		return "forward:writeForm.do";
	}
	
	
	
	
	@RequestMapping(value = "updateForm",method = RequestMethod.GET)
	public String updateForm(Model model,int empno) {
		model.addAttribute("updateForm",empService.detail(empno));
		return "updateForm";
	}
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String update(Model model,Emp emp,String temphiredate) {
		emp.setHiredate(Timestamp.valueOf(temphiredate+" 04:04:04"));
		model.addAttribute("update",empService.update(emp));
		return "forward:joinlist.do";
	}
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String delete(Model model,int empno) {
		model.addAttribute("updateForm",empService.delete(empno));
		return "forward:joinlist.do";
	}
	
}

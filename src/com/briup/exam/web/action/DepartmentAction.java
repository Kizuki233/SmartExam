package com.briup.exam.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.Department;
import com.briup.exam.service.impl.DepartmentService;
import com.briup.exam.web.action.manager.BaseAction;

import net.sf.json.JSONArray;

@Controller
@Scope(value="prototype")
public class DepartmentAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DepartmentService departmentService;
	
	private Long[] departmentIds;
	
	public Long[] getDepartmentIds() {
		return departmentIds;
	}
	public void setDepartmentIds(Long[] departmentIds) {
		this.departmentIds = departmentIds;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private Department department ;
	

	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Action(value="/manager/saveDepartment")
	public String saveDepartment(){
        	departmentService.saveOrUpdate(department);
		  return NONE; 
	}
	
	@Action(value="/manager/deleteDepartment")
	public String deleteDepartment(){
			departmentService.batchDelete(departmentIds);;
		return NONE;
	}


	@Action(value="/manager/getAllDepartments")
	public String getAllDepartments(){
		
		List<Department> departments=departmentService.findAll(Order.asc("id"));
		responseJSON(JSONArray.fromObject(departments).toString());
		return NONE;
	}
	
	
}

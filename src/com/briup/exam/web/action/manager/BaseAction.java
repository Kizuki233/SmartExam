package com.briup.exam.web.action.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Order;

import com.briup.exam.bean.Department;
import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.bean.Topic;
import com.briup.exam.service.IDepartmentService;
import com.briup.exam.service.ISubjectLevelService;
import com.briup.exam.service.ISubjectTypeService;
import com.briup.exam.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础action
 * 
 * */

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
//	@Autowired
	private ISubjectLevelService subjectLevelService; 
//	@Autowired
	private ISubjectTypeService subjectTypeService; 
//	@Autowired
	private ITopicService topicService;
//	@Autowired
	private IDepartmentService departmentService;
	
	/**
	 * 回写JSON
	 * */
	public void responseJSON(String json){
		HttpServletResponse response = ServletActionContext.getResponse();
		//response.addHeader("Accept-Control-Allow-Origin", "http://172.18.8.1");
		//http://127.0.0.1
		//同源策略
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 修改 level department topic 后更新application中的数据
	 * */
	public void updateApplication(){
		ActionContext ac = ActionContext.getContext();
		
		Map<String, Object> app = ac.getApplication();
		List<SubjectLevel> level = subjectLevelService.findAll(Order.asc("id"));
    	List<Topic> topic = topicService.findAll(Order.asc("id"));
    	List<Department> department = departmentService.findAll(Order.asc("id"));
    	
    	app.put("level", level);
    	app.put("topic", topic);
    	app.put("department", department);
	}
	

	public ISubjectLevelService getService1() {
		return subjectLevelService;
	}
	public void setService1(ISubjectLevelService service1) {
		this.subjectLevelService = service1;
	}
	public ISubjectTypeService getService2() {
		return subjectTypeService;
	}
	public void setService2(ISubjectTypeService service2) {
		this.subjectTypeService = service2;
	}
	public ITopicService getService3() {
		return topicService;
	}
	public void setService3(ITopicService service3) {
		this.topicService = service3;
	}
	public IDepartmentService getService4() {
		return departmentService;
	}
	public void setService4(IDepartmentService service4) {
		this.departmentService = service4;
	}
}

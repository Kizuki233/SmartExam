package com.briup.exam.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.briup.exam.web.action.manager.BaseAction;


@Controller
@Scope(value="prototype")
public class PageAction extends BaseAction{

	
	@Action(value="indexPage",results={@Result(name="success",location="/WEB-INF/index.jsp")})
	public String  indexPage(){
		return SUCCESS;
	}
	
	@Action(value="/subject/subjectListPage",results={@Result(name="success",location="/WEB-INF/tpl/subject/subjectList.jsp")})
	public String  subjectListPage(){
		return SUCCESS;
	}
	
	@Action(value="/subject/subjectAddPage",results={@Result(name="success",location="/WEB-INF/tpl/subject/subjectAdd.jsp")})
	public String  subjectAddPage(){
		return SUCCESS;
	}
	
	@Action(value="/manager/departmentManagerPage",results={@Result(name="success",location="/WEB-INF/tpl/manager/departmentManager.jsp")})
	public String  departmentManagerPage(){
		return SUCCESS;
	}
	
	@Action(value="/manager/subjectLevelManagerPage",results={@Result(name="success",location="/WEB-INF/tpl/manager/subjectLevelManager.jsp")})
	public String  subjectLevelManagerPage(){
		return SUCCESS;
	}
	
	@Action(value="/manager/subjectTypeManagerPage",results={@Result(name="success",location="/WEB-INF/tpl/manager/subjectTypeManager.jsp")})
	public String  subjectTypeManagerPage(){
		return SUCCESS;
	}
	
	@Action(value="/manager/topicManagerPage",results={@Result(name="success",location="/WEB-INF/tpl/manager/topicManager.jsp")})
	public String  topicManagerPage(){
		return SUCCESS;
	}
	
	@Action(value="/paper/paperAddPage",results={@Result(name="success",location="/WEB-INF/tpl/paper/paperAdd.jsp")})
	public String  paperAddPage(){
		return SUCCESS;
	}
	
	@Action(value="/paper/paperManagerPage",results={@Result(name="success",location="/WEB-INF/tpl/paper/paperManager.jsp")})
	public String  paperManagerPage(){
		return SUCCESS;
	}
	@Action(value="/paper/subjectListPage",results={@Result(name="success",location="/WEB-INF/tpl/paper/subjectList.jsp")})
	public String  subjectListPageOfPaper(){
		return SUCCESS;
	}
}

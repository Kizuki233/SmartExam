package com.briup.exam.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.service.impl.SubjectLevelService;
import com.briup.exam.web.action.manager.BaseAction;

import net.sf.json.JSONArray;

@Controller("subjectLevelAction")
@Scope(value="prototype")
public class SubjectLevelAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	private SubjectLevelService subjectLevelService;
	
	private Long[] subjectLevelIds;
	
	public Long[] getSubjectLevelIds() {
		return subjectLevelIds;
	}
	public void setSubjectLevelIds(Long[] subjectLevelIds) {
		this.subjectLevelIds = subjectLevelIds;
	}
	public SubjectLevelService getSubjectLevelService() {
		return subjectLevelService;
	}
	@Autowired
	public void setSubjectLevelService(SubjectLevelService subjectLevelService) {
		this.subjectLevelService = subjectLevelService;
	}

	private SubjectLevel subjectlevel ;
	

	public SubjectLevel getSubjectLevel() {
		return subjectlevel;
	}
	
	public void setSubjectLevel(SubjectLevel subjectlevel) {
		this.subjectlevel = subjectlevel;
	}
	
	@Action(value="/manager/saveSubjectLevel")
	public String saveSubjectLevel(){
        	subjectLevelService.saveOrUpdate(subjectlevel);
		  return NONE; 
	}
	
	@Action(value="/manager/deleteSubjectLevel")
	public String deleteSubjectLevel(){
			subjectLevelService.batchDelete(subjectLevelIds);;
		return NONE;
	}
	
/*	@Action(value="/manager/updateSubjectLevel")
	public String updateSubjectLevel(){
		try{
			subjectLevelService.saveOrUpdate(subjectlevel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return NONE;
	}*/

	@Action(value="/manager/getAllSubjectLevels")
	public String getAllSubjectLevels(){
		
		List<SubjectLevel> subjectLevels=subjectLevelService.findAll(Order.asc("id"));
		System.out.println(JSONArray.fromObject(subjectLevels).toString());
		responseJSON(JSONArray.fromObject(subjectLevels).toString());
		
		return NONE;
	}
	
}

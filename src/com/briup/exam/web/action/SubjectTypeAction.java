package com.briup.exam.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.SubjectType;
import com.briup.exam.service.impl.SubjectTypeService;
import com.briup.exam.web.action.manager.BaseAction;

import net.sf.json.JSONArray;


@Controller
@Scope(value="prototype")
public class SubjectTypeAction extends BaseAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SubjectTypeService subjectTypeService;
	
	private Long[] subjectTypeIds;
	
	public Long[] getSubjectTypeIds() {
		return subjectTypeIds;
	}
	public void setSubjectTypeIds(Long[] subjectTypeIds) {
		this.subjectTypeIds = subjectTypeIds;
	}
	public SubjectTypeService getSubjectTypeService() {
		return subjectTypeService;
	}
	@Autowired
	public void setSubjectTypeService(SubjectTypeService subjectTypeService) {
		this.subjectTypeService = subjectTypeService;
	}

	private SubjectType subjecttype ;
	

	public SubjectType getSubjectType() {
		return subjecttype;
	}
	
	public void setSubjectType(SubjectType subjecttype) {
		this.subjecttype = subjecttype;
	}
	
	@Action(value="/manager/saveSubjectType")
	public String saveSubjectType(){
        	subjectTypeService.saveOrUpdate(subjecttype);
		  return NONE; 
	}
	
	@Action(value="/manager/deleteSubjectType")
	public String deleteSubjectType(){
			subjectTypeService.batchDelete(subjectTypeIds);;
		return NONE;
	}
	
/*	@Action(value="/manager/updateSubjectType")
	public String updateSubjectType(){
		try{
			subjectTypeService.saveOrUpdate(subjecttype);
		}catch(Exception e){
			e.printStackTrace();
		}
		return NONE;
	}*/

	@Action(value="/manager/getAllSubjectTypes")
	public String getAllSubjectTypes(){
		
		List<SubjectType> subjectTypes=subjectTypeService.findAll(Order.asc("id"));
		System.out.println(JSONArray.fromObject(subjectTypes).toString());
		responseJSON(JSONArray.fromObject(subjectTypes).toString());
		
		return NONE;
	}
	
}

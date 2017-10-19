package com.briup.exam.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.taglibs.standard.tei.ForEachTEI;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.Choice;
import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.WebUtil;
import com.briup.exam.common.util.page.SimplePageInfo;
import com.briup.exam.criteria.SubjectCriteria;
import com.briup.exam.service.impl.ChoiceService;
import com.briup.exam.service.impl.SubjectService;
import com.briup.exam.web.action.manager.BaseAction;

import net.sf.json.JSONArray;



@Controller("subjectAction")
@Scope(value="prototype")
public class SubjectAction  extends BaseAction{

	
	private SubjectService subjectService;
	
	private Subject subject ;
	private String[] singleContent;
	private Integer singleCorrect;
	private String[] multiContent;
	private Integer[] multiCorrect;
	
	private SimplePageInfo simplePageInfo;
	
	
	public Subject getSubject() {
		return subject;
	}
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	public void setSingleContent(String[] singleContent) {
		this.singleContent = singleContent;
	}
	
	public void setSingleCorrect(Integer singleCorrect) {
		this.singleCorrect = singleCorrect;
	}
	public void setMultiContent(String[] multiContent) {
		this.multiContent = multiContent;
	}
	
	public void setMultiCorrect(Integer[] multiCorrect) {
		this.multiCorrect = multiCorrect;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public SimplePageInfo getSimplePageInfo() {
		return simplePageInfo;
	}
	public void setSimplePageInfo(SimplePageInfo simplePageInfo) {
		this.simplePageInfo = simplePageInfo;
	}
	@Action(value="/manager/saveSubject")
	public String saveSubject(){
		
		//By WJT
		Set<Choice> choices=null;
		Long subjectType=subject.getSubjectType().getId();
		if(subjectType!=null){
		
			if(subjectType==1L){
				choices=new HashSet<>();
				for(int i=0;i<singleContent.length;i++){
					Choice choice=new Choice(singleContent[i], singleCorrect==i);
					choices.add(choice);
				}
			}else if(subjectType==2L){
				choices=new HashSet<>();
				boolean[] corrects=new boolean[multiContent.length];
				for(int i=0;i<multiCorrect.length;i++){
					corrects[multiCorrect[i]]=true;
				}
				for(int i=0;i<multiContent.length;i++){
					Choice choice=new Choice(multiContent[i], corrects[i]);
					choices.add(choice);
				}
			}
			subject.setChoices(choices);
			subject.setUploadTime(new Date());
			subject.setCheckState("未审核");
			subjectService.save(subject);
		}
		
		return NONE;
	}
	@Action(value="/manager/getAllSubjects")
	public String getAllSubjects(){
		List<Subject> subjects=new ArrayList<>();
		Subject subject=new Subject();
		subject.setUploadTime(new Date());
		subject.setId(1L);
		subjects.add(subject);
		responseJSON(JSONArray.fromObject(subjects).toString());
		return NONE;
	}
	
	/**
	 * 审核功能：该方法要求前端至少在传来的Subject对象中存入了id和要修改的CheckState状态
	 * @return
	 */
	@Action(value="/manager/checkSubject")
	public String checkSubjectState(){
		Long id=subject.getId();
		String checkeState=subject.getCheckState();
		subject=subjectService.findById(id);
		subject.setCheckState(checkeState);
		subjectService.saveOrUpdate(subject);
		return NONE;
	}
	/**
	 * 删除题目功能：要求前端传来的subject对象至少要设置了id。
	 * @return
	 */
	@Action(value="/manager/deleteSubject")
	public String delSubject(){
		subjectService.delete(subject.getId());
		return NONE;
	}
	
	/**
	 * 本方法需要前端在simplePageInfo里设置好currentPage.前端传过来的参数由一开始，后端的查询由0开始
	 * 还要前端传入一个Subject对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value="/manager/getSubjectsByCriteria")
	public String getSubjectsByCriteria(){
		SubjectCriteria sub=new SubjectCriteria();
		//先设置查询的最基本条件
		sub.setSubject(subject);
		
		List<Subject> subjects=subjectService.findByCriteria(sub, simplePageInfo,Order.asc("id"));
		for (Subject subject2 : subjects) {
			System.out.println(subject2);
		}
		//把页数修改回来
		int cur=simplePageInfo.getCurrentPage();
		simplePageInfo.setCurrentPage(cur+1);
		simplePageInfo.setModels(subjects);
		//把查出来的信息和页面信息一起传回前端
		WebUtil.sendJSONObjectResponse(simplePageInfo, null);
		return NONE;
	}
}

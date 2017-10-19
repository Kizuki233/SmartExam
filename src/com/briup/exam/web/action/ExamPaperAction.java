package com.briup.exam.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.ExamPaper;
import com.briup.exam.bean.PaperSubject;
import com.briup.exam.bean.Subject;
import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.common.util.WebUtil;
import com.briup.exam.service.impl.ExamPaperService;
import com.briup.exam.service.impl.PaperSubjectService;
import com.briup.exam.web.action.manager.BaseAction;

import net.sf.json.JSONArray;

@Controller("examPaperAction")
@Scope(value="prototype")
public class ExamPaperAction extends BaseAction{

	private ExamPaperService examPaperService;
	private PaperSubjectService paperSubjectService;
	private ExamPaper examPaper;
	
	
	private Long[] examPaperIds;
	
	private Long[] subjectIds;
	
	private Integer[] scores;
	
	public Long[] getSubjectIds() {
		return subjectIds;
	}

	public void setSubjectIds(Long[] subjectIds) {
		this.subjectIds = subjectIds;
	}

	public Integer[] getScores() {
		return scores;
	}

	public void setScores(Integer[] scores) {
		this.scores = scores;
	}

	public void setExamPaperIds(Long[] examPaperIds) {
		this.examPaperIds = examPaperIds;
	}

	public ExamPaper getExamPaper() {
		return examPaper;
	}



	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}



	@Autowired
	public void setExamPaperService(ExamPaperService examPaperService) {
		this.examPaperService = examPaperService;
	}
	
	
	@Autowired
	public void setPaperSubjectService(PaperSubjectService paperSubjectService) {
		this.paperSubjectService = paperSubjectService;
	}
	
	@Action(value="/paper/getAllPapers")
	public String getAllPapers(){
		
		List<ExamPaper> examPapers = examPaperService.findAll(Order.asc("id"));
		
		WebUtil.sendJSONArrayResponse(examPapers);
		return NONE;
	}
	
	@Action(value="/paper/deleteExamPapers")
	public String deleteExamPaper(){
		examPaperService.batchDelete(examPaperIds);
		return NONE;
	}

	@Action(value="/paper/saveExamPaper")
	public String saveExamPaper(){
		if(scores!=null&&subjectIds!=null&&scores.length==subjectIds.length){
			Set<PaperSubject> paperSubjects=new HashSet<>();
			for(int i=0;i<scores.length;i++){
				PaperSubject paperSubject=new PaperSubject();
				Subject subject=new Subject();
				subject.setId(subjectIds[i]);
				paperSubject.setScore(scores[i]);
				
				paperSubject.setSubject(subject);
				paperSubject.setExamPaper(examPaper);
				paperSubjects.add(paperSubject);
			}
			examPaper.setCreateTime(new Date());
			examPaper.setPaperSubjects(paperSubjects);
			examPaperService.save(examPaper);
			
		}
		return NONE;
	}

	
	
	
	
}

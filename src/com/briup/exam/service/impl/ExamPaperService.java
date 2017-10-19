package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.ExamPaper;
import com.briup.exam.bean.PaperSubject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.ExamPaperDao;
import com.briup.exam.dao.PaperSubjectDao;
import com.briup.exam.service.IExamPaperService;

@Service("examPaperService")
public class ExamPaperService implements IExamPaperService{
	
	private ExamPaperDao examPaperDao;

	private PaperSubjectDao paperSubjectDao;
	
	public ExamPaperDao getExamPaperDao() {
		return examPaperDao;
	}

	@Autowired
	public void setExamPaperDao(ExamPaperDao examPaperDao) {
		this.examPaperDao = examPaperDao;
	}

	@Autowired
	public void setPaperSubjectDao(PaperSubjectDao paperSubjectDao) {
		this.paperSubjectDao = paperSubjectDao;
	}
	
	
	@Override
	public ExamPaper findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPaper> findAll(Order... orders) {
		return examPaperDao.findAll(orders);
	}

	@Override
	public List<ExamPaper> findAll(IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPaper> findByExample(ExamPaper model, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPaper> findByExample(ExamPaper model, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPaper> findByCriteria(Criteriable criteriaObj, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPaper> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamPaper findUnique(ExamPaper model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ExamPaper model) {
		examPaperDao.save(model);
		for(PaperSubject paperSubject:model.getPaperSubjects()){
			paperSubjectDao.save(paperSubject);
		}
		
	}

	@Override
	public void batchSave(List<ExamPaper> models) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(ExamPaper model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ExamPaper model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(ExamPaper model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchDelete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchDelete(Long[] ids) {
		for (Long id : ids) {
			ExamPaper examPaper=examPaperDao.findById(id);
			examPaperDao.deleteObject(examPaper);
		}
		
	}

	@Override
	public void batchDeleteModel(List<ExamPaper> models) {
		// TODO Auto-generated method stub
		
	}



}

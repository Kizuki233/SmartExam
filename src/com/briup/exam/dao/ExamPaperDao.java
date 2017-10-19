package com.briup.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.ExamPaper;

@Repository
public class ExamPaperDao extends BaseDao<ExamPaper> {

	public ExamPaper findById(Long id){
		return (ExamPaper) getSession().get(ExamPaper.class, id);
	}

	/**
	 * 这只需要两个功能，查找所有以及按id删除
	 * @param orders
	 * @return
	 */
	public List<ExamPaper> findAll(Order... orders) {
		Criteria criteria = getSession().createCriteria(ExamPaper.class);
		for (Order o : orders) {
			criteria.addOrder(o);
		}
		return criteria.list();
			
		}
	
	public void delete(Long id) {
		ExamPaper examPaper = new ExamPaper();
		examPaper.setId(id);
		getSession().delete(examPaper);
	}
	
	public void deleteObject(ExamPaper model){
		getSession().delete(model);
	}
	
	public void save(ExamPaper model) {

		getSession().save(model);
	}
}

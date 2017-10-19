package com.briup.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;

@Repository
public class SubjectDao extends BaseDao<Subject> {
	
	public Subject findById(Long id) {
		return (Subject) getSession().get(Subject.class, id);
	}

	public void save(Subject model) {
		getSession().save(model);
		
	}

	public void saveOrUpdate(Subject model) {

		getSession().saveOrUpdate(model);
	}

	public void update(Subject model) {

		getSession().update(model);
	}

	public void deleteObject(Subject model) {

		getSession().delete(model);
	}

	public void delete(Long id) {
		Subject subject=new Subject();
		subject.setId(id);
		getSession().delete(subject);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Subject> findByCriteria(Criteriable criteriaObj, Order... orders) {
		Criteria criteria=criteriaObj.getExampleCriteria(getSession());
		for (Order order : orders) {
			criteria.addOrder(order);
		}
		return criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Subject> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		Criteria criteria=criteriaObj.getExampleCriteria(getSession());
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setMaxResults(pageInfo.getPageSize());
		criteria.setFirstResult(pageInfo.getOffset());
		for (Order order : orders) {
			criteria.addOrder(order);
		}
		return criteria.list();
	}
}

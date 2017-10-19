package com.briup.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.Department;
@Repository
public class DepartmentDao extends BaseDao<Department> {
	
	public Department findById(Long id) {
		return (Department) getSession().get(Department.class, id);
	}

	public void save(Department model) {
		getSession().save(model);
	}

	public void saveOrUpdate(Department model) {
		getSession().saveOrUpdate(model);
	}

	public void update(Department model) {
		getSession().update(model);
	}

	public void deleteObject(Department model) {
		getSession().delete(model);
	}

	public void delete(Long id) {
		Department subject=new Department();
		subject.setId(id);
		getSession().delete(subject);
	}
	
	@SuppressWarnings("unchecked")
	public List<Department> findAll(Order... orders) {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Department.class);
		for(Order o:orders){
			criteria.addOrder(o);
		}
		return criteria.list();
	}
}

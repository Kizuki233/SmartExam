package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.SubjectType;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectTypeDao;
import com.briup.exam.service.ISubjectTypeService;

@Service("subjectTypeService")
public class SubjectTypeService implements ISubjectTypeService{
	
	private SubjectTypeDao subjectTypeDao;

	public SubjectTypeDao getSubjectTypeDao() {
		return subjectTypeDao;
	}
	
	@Autowired
	public void setSubjectTypeDao(SubjectTypeDao subjectTypeDao) {
		this.subjectTypeDao = subjectTypeDao;
	}

	@Override
	public SubjectType findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectType> findAll(Order... orders) {
		// TODO Auto-generated method stub
		return subjectTypeDao.findObjectAll(orders);
	}

	@Override
	public List<SubjectType> findAll(IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectType> findByExample(SubjectType model, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectType> findByExample(SubjectType model, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectType> findByCriteria(Criteriable criteriaObj, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectType> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectType findUnique(SubjectType model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(SubjectType model) {
		// TODO Auto-generated method stub
			subjectTypeDao.save(model);
	}

	@Override
	public void batchSave(List<SubjectType> models) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(SubjectType model) {
		// TODO Auto-generated method stub
		subjectTypeDao.saveOrUpdate(model);
	}

	@Override
	public void update(SubjectType model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(SubjectType model) {
		// TODO Auto-generated method stub
		subjectTypeDao.deleteObject(model);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		subjectTypeDao.delete(id);
	}


	@Override
	public void batchDelete(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id:ids){	
			subjectTypeDao.delete(id);
		}
	}

	@Override
	public void batchDeleteModel(List<SubjectType> models) {
		// TODO Auto-generated method stub
		for(SubjectType model:models){
			subjectTypeDao.deleteObject(model);
		}
	}

	@Override
	public void batchDelete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}
	
	
}

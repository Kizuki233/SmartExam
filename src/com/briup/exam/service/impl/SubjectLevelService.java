package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectLevelDao;
import com.briup.exam.service.ISubjectLevelService;

@Service("subjectLevelService")
public class SubjectLevelService implements ISubjectLevelService{
	
	private SubjectLevelDao subjectLevelDao;
	
	public SubjectLevelDao getSubjectLevelDao() {
		return subjectLevelDao;
	}

	@Autowired
	public void setSubjectLevelDao(SubjectLevelDao subjectLevelDao) {
		this.subjectLevelDao = subjectLevelDao;
	}

	@Override
	public SubjectLevel findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectLevel> findAll(Order... orders) {
		// TODO Auto-generated method stub
		return subjectLevelDao.findObjectAll(orders);
	}

	@Override
	public List<SubjectLevel> findAll(IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectLevel> findByExample(SubjectLevel model, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectLevel> findByExample(SubjectLevel model, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectLevel> findByCriteria(Criteriable criteriaObj, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectLevel> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectLevel findUnique(SubjectLevel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(SubjectLevel model) {
		// TODO Auto-generated method stub
			subjectLevelDao.save(model);
	}

	@Override
	public void batchSave(List<SubjectLevel> models) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(SubjectLevel model) {
		// TODO Auto-generated method stub
		subjectLevelDao.saveOrUpdate(model);
	}

	@Override
	public void update(SubjectLevel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(SubjectLevel model) {
		// TODO Auto-generated method stub
		subjectLevelDao.deleteObject(model);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		subjectLevelDao.delete(id);
	}


	@Override
	public void batchDelete(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id:ids){	
			subjectLevelDao.delete(id);
		}
	}

	@Override
	public void batchDeleteModel(List<SubjectLevel> models) {
		// TODO Auto-generated method stub
		for(SubjectLevel model:models){
			subjectLevelDao.deleteObject(model);
		}
	}

	@Override
	public void batchDelete(List<Long> ids) {
		// TODO Auto-generated method stub
	}

}

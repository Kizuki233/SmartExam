package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.exception.ServiceException;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.common.util.page.SimplePageInfo;
import com.briup.exam.dao.SubjectDao;
import com.briup.exam.service.ISubjectService;

@Service("subjectService")
public class SubjectService implements ISubjectService{

	
	private SubjectDao subjectDao;
	
	
	public SubjectDao getSubjectDao() {
		return subjectDao;
	}
	@Autowired
	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	@Override
	public Subject findById(Long id) {
		return subjectDao.findById(id);
		
		
	}

	@Override
	public List<Subject> findAll(Order... orders) {
		return null;
	}

	@Override
	public List<Subject> findAll(IPageInfo pageInfo, Order... orders) {
		return null;
	}

	@Override
	public List<Subject> findByExample(Subject model, Order... orders) {
		return null;
	}

	@Override
	public List<Subject> findByExample(Subject model, IPageInfo pageInfo, Order... orders) {
		return null;
	}

	@Override
	public List<Subject> findByCriteria(Criteriable criteriaObj, Order... orders) {
		return subjectDao.findByCriteria(criteriaObj, orders);
	}
	
	public int findTotalCount(Criteriable criteriaObj, Order... orders) {
		List<Subject>rs= subjectDao.findByCriteria(criteriaObj, orders);
		return rs.size();
	}
	@Override
	public List<Subject> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		//进行类型强制转换
		SimplePageInfo<Subject> simplePageInfo=(SimplePageInfo<Subject>)pageInfo;
		//设置每页最大显示5条
		simplePageInfo.setPageSize(3);
		//设置总条数
		simplePageInfo.setTotalCount(findTotalCount(criteriaObj));
		//开始查询
		int max=simplePageInfo.getPageCount();//一共有几页
		int cur=simplePageInfo.getCurrentPage();//要查询的页码数
		
		if(cur>max) simplePageInfo.setCurrentPage(max-1);
		else if(cur<1) simplePageInfo.setCurrentPage(0);
		else {
			simplePageInfo.setCurrentPage(cur-1);
		}
		return subjectDao.findByCriteria(criteriaObj, pageInfo, orders);
	}

	@Override
	public Subject findUnique(Subject model) {
		if(model.getId()!=null){
			return subjectDao.findById(model.getId());
		}
		
		return null;
	}

	@Override
	public void save(Subject model) {
		subjectDao.save(model);
	}

	@Override
	public void batchSave(List<Subject> models) {
		for(Subject model:models){
			subjectDao.save(model);
		}
		
	}

	@Override
	public void saveOrUpdate(Subject model) {
		subjectDao.saveOrUpdate(model);
		
	}

	@Override
	public void update(Subject model) {
		subjectDao.update(model);
		
	}

	@Override
	public void deleteObject(Subject model) {
		subjectDao.deleteObject(model);
		
	}

	@Override
	public void delete(Long id) {
		subjectDao.delete(id);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		for(Long id:ids){
			subjectDao.delete(id);
		}
		
	}

	@Override
	public void batchDelete(Long[] ids) {
		for(Long id:ids){
			subjectDao.delete(id);
		}
	}

	@Override
	public void batchDeleteModel(List<Subject> models) {
		for(Subject model:models){
			subjectDao.save(model);
		}
		
	}
	@Override
	public void registerSubject(Subject subject) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}

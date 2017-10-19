package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Topic;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.TopicDao;
import com.briup.exam.service.ITopicService;

@Service("topicService")
public class TopicService implements ITopicService{
	
	private TopicDao topicDao;

	
	public TopicDao getTopicDao() {
		return topicDao;
	}

	@Autowired
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	@Override
	public Topic findById(Long id) {
		// TODO Auto-generated method stub
		return topicDao.findById(id);
	}

	@Override
	public List<Topic> findAll(Order... orders) {
		// TODO Auto-generated method stub
		return topicDao.findObjectAll(orders);
	}

	@Override
	public List<Topic> findAll(IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> findByExample(Topic model, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> findByExample(Topic model, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> findByCriteria(Criteriable criteriaObj, Order... orders) {
		Criteria criteria=criteriaObj.getExampleCriteria(topicDao.getSession());
		for(Order order:orders){
			criteria.addOrder(order);
		}
		return topicDao.findByCriteria(criteria);
		
	}

	@Override
	public List<Topic> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topic findUnique(Topic model) {
		// TODO Auto-generated method stub
		if(model.getId()!=null){
			return topicDao.findById(model.getId());
		}
		return null;
	}

	@Override
	public void save(Topic model) {
		// TODO Auto-generated method stub
		topicDao.save(model);
	}

	@Override
	public void batchSave(List<Topic> models) {
		// TODO Auto-generated method stub
		for(Topic model:models){
			topicDao.save(model);
		}
	}

	@Override
	public void saveOrUpdate(Topic model) {
		// TODO Auto-generated method stub
		topicDao.saveOrUpdate(model);
	}

	@Override
	public void update(Topic model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(Topic model) {
		// TODO Auto-generated method stub
		topicDao.deleteObject(model);;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		topicDao.delete(id);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		// TODO Auto-generated method stub
		for(Long id:ids){
			topicDao.delete(id);
		}
	}

	@Override
	public void batchDelete(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id:ids){
			topicDao.delete(id);
		}
	}

	@Override
	public void batchDeleteModel(List<Topic> models) {
		// TODO Auto-generated method stub
		for(Topic model:models){
			topicDao.save(model);
		}
	}
	
	

}

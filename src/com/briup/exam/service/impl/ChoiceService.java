package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Choice;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.ChoiceDao;
import com.briup.exam.service.IChoiceService;
@Service("choiceService")
public class ChoiceService implements IChoiceService{

	private ChoiceDao choicedao;
	
	public ChoiceDao getChoicedao() {
		return choicedao;
	}
	@Autowired
	public void setChoicedao(ChoiceDao choicedao) {
		this.choicedao = choicedao;
	}

	
	
	@Override
	public Choice findById(Long id) {
		return choicedao.findById(id);
	}

	@Override
	public List<Choice> findAll(Order... orders) {
		return choicedao.findAll();
	}

	@Override
	public List<Choice> findAll(IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choice> findByExample(Choice model, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choice> findByExample(Choice model, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choice> findByCriteria(Criteriable criteriaObj, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choice> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Choice findUnique(Choice model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Choice model) {
		choicedao.save(model);
	}

	@Override
	public void batchSave(List<Choice> models) {
		choicedao.batchSave(models);
	}

	@Override
	public void saveOrUpdate(Choice model) {
		choicedao.saveOrUpdate(model);
	}

	@Override
	public void update(Choice model) {
		choicedao.update(model);
	}

	@Override
	public void deleteObject(Choice model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		choicedao.deleteObject(id);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		choicedao.batchDelete(ids);
	}

	@Override
	public void batchDelete(Long[] ids) {
		choicedao.batchDelete(ids);
		
	}

	@Override
	public void batchDeleteModel(List<Choice> models) {
		// TODO Auto-generated method stub
		
	}

}

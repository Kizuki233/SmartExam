package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.User;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.UserDao;
import com.briup.exam.service.IUserService;
@Service("userService")
public class UserService implements IUserService{
	
	private UserDao userdao;
	
	
	public UserDao getUserdao() {
		return userdao;
	}
	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public User findById(Long id) {
		return userdao.findByID(id);
	}

	@Override
	public List<User> findAll(Order... orders) {
		return userdao.findAll();
	}

	@Override
	public List<User> findAll(IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByExample(User model, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByExample(User model, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByCriteria(Criteriable criteriaObj, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUnique(User model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User model) {
		userdao.save(model);
	}

	@Override
	public void batchSave(List<User> models) {
		//批量增加
		userdao.batchSave(models);
	}

	@Override
	public void saveOrUpdate(User model) {
		userdao.saveOrUpdate(model);	
	}

	@Override
	public void update(User model) {
		userdao.update(model);
	}

	@Override
	public void deleteObject(User model) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Long id) {
		userdao.delete(id);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		userdao.batchDelete(ids);	
	}

	@Override
	public void batchDelete(Long[] ids) {
		userdao.batchDelete(ids);
	}

	@Override
	public void batchDeleteModel(List<User> models) {
		// TODO Auto-generated method stub
		
	}

}

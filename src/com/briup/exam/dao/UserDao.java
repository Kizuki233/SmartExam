package com.briup.exam.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.User;
/**
 * User的增删改查
 * @author nima
 *
 */
@Repository
public class UserDao extends BaseDao<User> {
	
	
	/**
	 * 根据id查找用户
	 */
	public User findByID(Long id){
		return (User) getSession().get(User.class, id);
	}
	
	/**
	 * 找到所有用户
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll(Order... orders){
		
		Criteria criteria = getSession().createCriteria(User.class);
		
		for (Order o : orders) {
			criteria.addOrder(o);
		}
		return criteria.list();
	}
	
	
	/**
	 * 保存新用户
	 * @param user
	 */
	public void save(User user){
		getSession().save(user);
	}
	
	/**
	 * 批量添加用户
	 */
	public void batchSave(List<User> model){
		for (int i = 0; i < model.size(); i++) {
			getSession().save(model.get(i));
		}	
	}
	
	/**
	 *保存或更新
	 */
	public void saveOrUpdate(User model) {
		getSession().saveOrUpdate(model);
	}
	
	/**
	 * 更新
	 */
	public void update(User model) {
		getSession().update(model);
	}
	
	/**
	 * 删除用户
	 */
	public void delete(Long id){
		User user = new User();
		user.setId(id);
		getSession().delete(user);
	}
	
	/**
	 * 批量删除
	 */
	public void batchDelete(List<Long> ids){
		for(int i = 0; i < ids.size(); i++){
			User newUser = new User();
			newUser.setId(ids.get(i));
			getSession().delete(newUser);
		}
	}
	

	/**
	 * 批量删除
	 * @param ids
	 */
	public void batchDelete(Long[] ids) {
		for(int i=0;i<ids.length;i++)
		{
			User newUser = new User();
			newUser.setId(ids[i]);
			getSession().delete(newUser);
		}
		
	}

	
	
	
	
}

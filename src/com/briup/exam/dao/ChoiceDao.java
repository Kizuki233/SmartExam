package com.briup.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.Choice;

/**
 * Choice包（选项）的增删改查
 * @author nima
 *
 */
@Repository
public class ChoiceDao extends BaseDao<Choice> {

	
	/**
	 * 根据id查看
	 * @param id
	 * @return
	 */
	public Choice findById(Long id) {
		return (Choice) getSession().get(Choice.class, id);
	}
	
	
	/**
	 * 查询所有题目选项
	 * @param orders
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Choice> findAll(Order... orders) {
		Criteria criteria = getSession().createCriteria(Choice.class);
		for (Order o : orders) {
			criteria.addOrder(o);
		}
		return criteria.list();
	}
	
	/**
	 * 保存选项
	 * @param model
	 */
	public void save(Choice model) {
		getSession().save(model);
	}
	
	/**
	 * 群体保存
	 * @param models
	 */
	public void batchSave(List<Choice> models) {
		for (int i = 0; i < models.size(); i++) {
			getSession().save(models.get(i));
		}
	}
	
	/**
	 * 保存或更新
	 * @param model
	 */
	public void saveOrUpdate(Choice model) {
		getSession().saveOrUpdate(model);
	}
	
	/**
	 * 更新
	 * @param model
	 */
	public void update(Choice model) {
		getSession().update(model);
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteObject(Long id) {
		Choice choice = new Choice();
		choice.setId(id);
		getSession().delete(choice);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void batchDelete(List<Long> ids) {
		for(int i = 0; i < ids.size(); i++){
			Choice choice = new Choice();
			choice.setId(ids.get(i));
			getSession().delete(choice);
		}
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void batchDelete(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Choice choice = new Choice();
			choice.setId(ids[i]);
			getSession().delete(choice);
		}
	}
}

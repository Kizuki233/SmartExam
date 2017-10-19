package com.briup.exam.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.briup.exam.bean.Department;
import com.briup.exam.bean.Topic;
import com.briup.exam.common.util.Criteriable;

public class TopicCriteria implements Criteriable {
	
	private Long departmentId;
	
	

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	@Override
	public Criteria getExampleCriteria(Session session) {
		Criteria topicCriteria = session.createCriteria(Topic.class);
		topicCriteria.add(Restrictions.eq("department.id", departmentId));
		return topicCriteria;
	}
}

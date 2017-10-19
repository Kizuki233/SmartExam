package com.briup.exam.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;
/**
 *题干模板类9
 * */
public class SubjectCriteria implements Criteriable {
	private Subject subject;

	@Override
	public Criteria getExampleCriteria(Session session) {
		Criteria subjectCriteria = session.createCriteria(subject.getClass());
		
		if(subject.getStem()!=null&&!subject.getStem().trim().equals("")){
			subjectCriteria.add(Restrictions.like("stem", "%"+subject.getStem()+"%"));
		}
		if(subject.getCheckState()!=null){
			subjectCriteria.add(Restrictions.like("checkState", subject.getCheckState()));
		}
		if(subject.getSubjectLevel()!=null){
			Long id = subject.getSubjectLevel().getId();
			if(id!=null&&id!=0)
			subjectCriteria.createCriteria("subjectLevel").add(Restrictions.eq("id", id));
		}
		if(subject.getSubjectType()!=null){
			Long id = subject.getSubjectType().getId();
			if(id!=null&&id!=0)
			subjectCriteria.createCriteria("subjectType").add(Restrictions.eq("id", id));
		}
		if(subject.getDepartment()!=null){
			Long id = subject.getDepartment().getId();
			if(id!=null&&id!=0)
			subjectCriteria.createCriteria("department").add(Restrictions.eq("id", id));
		}
		if(subject.getTopic()!=null){
			Long id = subject.getTopic().getId();
			if(id!=null&&id!=0)
			subjectCriteria.createCriteria("topic").add(Restrictions.eq("id", id));
		}
		return subjectCriteria;
	}

	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}

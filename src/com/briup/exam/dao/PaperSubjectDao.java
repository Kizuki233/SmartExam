package com.briup.exam.dao;

import org.springframework.stereotype.Repository;

import com.briup.exam.bean.PaperSubject;

@Repository
public class PaperSubjectDao extends BaseDao<PaperSubject> {

	public void save(PaperSubject paperSubject) {
		getSession().save(paperSubject);
	}

}

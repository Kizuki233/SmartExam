package com.briup.exam.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.Department;
import com.briup.exam.bean.Topic;
import com.briup.exam.criteria.TopicCriteria;
import com.briup.exam.service.impl.TopicService;
import com.briup.exam.web.action.manager.BaseAction;

import net.sf.json.JSONArray;


@Controller
@Scope(value="prototype")
public class TopicAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private TopicService topicService;
	
	private Long[] topicIds;
	
	public Long[] getTopicIds() {
		return topicIds;
	}
	public void setTopicIds(Long[] topicIds) {
		this.topicIds = topicIds;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	@Autowired
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	private Topic topic ;
	private Long departmentId;
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	@Action(value="/manager/saveTopic")
	public String saveTopic(){
        	/*topicService.saveOrUpdate(new Topic("we",new Department("中")));*/
		  System.out.println(topic);
          topicService.saveOrUpdate(topic);
		  return NONE; 
	}
	
	@Action(value="/manager/deleteTopic")
	public String deleteTopic(){
			topicService.batchDelete(topicIds);;
		return NONE;
	}

	@Action("/manager/getAllTopics")
	public String getAllTopics(){
		List<Topic> topics=topicService.findAll(Order.asc("id"));
		responseJSON(JSONArray.fromObject(topics).toString());
		return NONE;
	}
	
	@Action(value="/manager/getTopicsbyDepartmentId")
	public String getTopicsByDid(){
		
		TopicCriteria topicCriterial=new TopicCriteria();
		topicCriterial.setDepartmentId(departmentId);
		List<Topic> topics =topicService.findByCriteria(topicCriterial, Order.asc("id"));
		responseJSON(JSONArray.fromObject(topics).toString());
		return NONE;
	}
}

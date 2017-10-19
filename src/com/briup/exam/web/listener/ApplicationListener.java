package com.briup.exam.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 当应用启动时，加载所有的subjectLevel subjectType department topic 到application中
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ApplicationListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		
	/*	System.out.println("context init");
		ServletContext ap = arg0.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(ap);
		
		SubjectTypeService service1 = (SubjectTypeService) ac.getBean("SubjectTypeService");
		SubjectLevelService service2 = (SubjectLevelService) ac.getBean("SubjectLevelService");
		DepartmentService service3 = (DepartmentService) ac.getBean("DepartmentService");
		TopicService service4 = (TopicService) ac.getBean("TopicService");
		
		List<SubjectType> subjecttype = service1.findAll(Order.desc("id"));
		List<SubjectLevel> subjectlevel = service2.findAll(Order.desc("id"));
		List<Department> department = service3.findAll(Order.desc("id"));
		List<Topic> topic = service4.findAll(Order.desc("id"));

		ap.setAttribute("ubjectLevel", subjectlevel);
		ap.setAttribute("subjectType", subjecttype);
		ap.setAttribute("department", department);
		ap.setAttribute("topic", topic);
		
		for (SubjectLevel a : subjectlevel) {
			System.out.println(a);
		}*/
	}
}

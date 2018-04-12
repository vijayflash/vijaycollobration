package com.niit.backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.AppliedJobsDAO;
import com.niit.model.AppliedJobs;



public class AppliedJobstest {
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static AppliedJobsDAO appliedJobsDAO;

	@Autowired
	static AppliedJobs appliedJobs;
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		appliedJobsDAO = (AppliedJobsDAO) context.getBean("AppliedJobsDAO");

		appliedJobs = (AppliedJobs) context.getBean("appliedJobs");
	}
	@Test
	public void createAppliedJobsTestCase(){
		
		appliedJobs.setCompanyname("companyname");
		appliedJobs.setQualification("qualification");
		appliedJobs.setEmail("mani@hotmail.in");
		appliedJobs.setStatus("active");
		appliedJobs.setUsername("mani");
		appliedJobsDAO.saveOrUpdate(appliedJobs);
	}
}

package com.learn.java.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learn.java.bo.TestTransactionProgagationCourseBo;
import com.zlx.user.dal.dao.CourseDO;
import com.zlx.user.dal.sqlmap.CourseDOMapper;
@Configuration
public class TestTransactionProgagationCourseImpl implements TestTransactionProgagationCourseBo{

	@Autowired
	private CourseDOMapper  courseDOMapper;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	//@Transactional(propagation=Propagation.REQUIRED)

	@Override
	public boolean insertCourse(CourseDO course) {
		
		if(true)
			throw new RuntimeException();
		return courseDOMapper.insert(course)==1?true:false;
		
	}
}

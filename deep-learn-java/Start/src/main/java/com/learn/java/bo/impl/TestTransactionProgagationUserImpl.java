package com.learn.java.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.learn.java.bo.TestTransactionProgagationCourseBo;
import com.learn.java.bo.TestTransactionProgagationUserBo;
import com.zlx.user.dal.dao.CourseDO;
import com.zlx.user.dal.dao.UserDO;
import com.zlx.user.dal.sqlmap.UserDOMapper;

@Configuration
public class TestTransactionProgagationUserImpl implements TestTransactionProgagationUserBo {

	@Autowired
	private UserDOMapper userDOMapper;
	@Autowired
	private TestTransactionProgagationCourseBo testTransactionProgagationCourseBo;

	@Transactional
	@Override
	public boolean insertUser(UserDO user) {
		boolean result = userDOMapper.insert(user) == 1 ? true : false;
		if (result) {
			CourseDO course = new CourseDO();
			course.setUserId(user.getId());
			course.setCourseName("计算机科学");
			 result = false;
			 //catch掉异常
			 try {
				 result = testTransactionProgagationCourseBo.insertCourse(course);

			 }catch(Exception e) {
				 
			 }
			 
			 return result;
		}

		return false;
	}

}

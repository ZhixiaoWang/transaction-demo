package com.learn.java.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.learn.java.bo.TestTransactionProgagationUserBo;
import com.learn.java.bo.UserManagerBo;
import com.zlx.user.dal.dao.UserDO;

@Configuration
public class UserManagerBoImpl implements UserManagerBo{

	@Autowired
	TestTransactionProgagationUserBo  testTransactionProgagationUserBo;
	
	@Override
	public boolean addNewUser(UserDO userDO) {
		
		return testTransactionProgagationUserBo.insertUser(userDO);
	}

}

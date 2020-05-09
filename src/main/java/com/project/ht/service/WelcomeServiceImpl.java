package com.project.ht.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.project.ht.dao.UserDao;
import com.project.ht.model.Welcome;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	
	@Autowired
	UserDao userDao;

	public List<Welcome> findAllUserList() {
		return userDao.findAllUser();
	}

	public Welcome add(Welcome user) throws Exception {
		return userDao.add(user);
	}
/*
	public void update(String id) {
		userDao.update(id);
	}
*/
	public Welcome update(Welcome user) {
		return userDao.update(user);
	};

	public void delete(String id) {
	userDao.delete(id);	
	}

	public Welcome findUserById(String id) {
		return userDao.findUserById(id);
	}

	@Override
	public Welcome findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserById(email);
	}

}

package com.project.ht.service;

import java.util.List;


import com.project.ht.model.Welcome;


public interface WelcomeService {
	
public List<Welcome> findAllUserList();
	
	public Welcome add(Welcome user) throws Exception;
	
	//public void update(String id);
	
	public Welcome update(Welcome user);
	
	public void delete(String id);
	
	public Welcome findUserById(String id);

	public Welcome findByEmail(String email);

	

	

	
}

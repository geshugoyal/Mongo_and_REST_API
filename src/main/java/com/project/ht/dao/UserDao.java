package com.project.ht.dao;
import java.util.List;

import com.project.ht.model.Welcome;


public interface UserDao {

	public List<Welcome> findAllUser();
	
	public Welcome add(Welcome user) throws Exception;
	
	//public void update(String id);
	public Welcome update(Welcome user);
	
	public Welcome findByEmail(String email);
	
	public Welcome findUserById(String id);

	public void delete(String id);
	
	
	

}

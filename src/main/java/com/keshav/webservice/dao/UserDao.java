package com.keshav.webservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.keshav.webservice.model.User;

@Repository
public class UserDao {
	
	private static List<User> userList = new ArrayList<>();
	private static int userCount = 1; 
	
	static{
		userList.add(new User(1, "keshav", new Date()));
	}

	public List<User> getAllUsers(){
		return userList;
	}
	
	public User findById(int id){
		User user = null;
		for(User u: userList){
			if(u.getUserId() == id){
				user = u;
				break;
			}
		}
		return user;
	}
	
	public User save(User user){
		if(user.getUserId()==0){
			user.setUserId(++userCount);
		}
		userList.add(user);
		return user;
	}
	
	public User deleteUser(int id){
		User user = null;
		Iterator<User> it = userList.iterator();
		while(it.hasNext()){
			User u = it.next();
			if(u.getUserId() == id){
				user = u;
				it.remove();
				break;
			}
		}
		return user;
	}
}

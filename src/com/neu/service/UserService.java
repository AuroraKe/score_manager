package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.bean.User;
import com.neu.dao.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public List<User> login(String username, String password, int roleId){
		List<User> users = userMapper.login(username, password, roleId);
		return users;
	}
}

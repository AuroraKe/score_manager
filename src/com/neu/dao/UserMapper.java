package com.neu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.bean.User;

public interface UserMapper {
	public List<User> login(@Param("username")String username, @Param("password")String password, @Param("role_id")int roleId);
	
}

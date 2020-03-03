package main.java.com.po.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.po.dao.UserMapper;
import main.java.com.po.entity.UserEntity;
import main.java.com.po.service.UserService;

public class UserImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserEntity> getUser() {
		return userMapper.getUserObject();
	}

}

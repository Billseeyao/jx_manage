package main.java.com.po.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.po.dao.UserMapper;
import main.java.com.po.entity.UserEntity;
import main.java.com.po.service.UserService;

public class UserImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserEntity> getUser() {
//		Map<String,Object> map = new HashMap<String, Object>();
//		return userMapper.getUserObject(map);
		return null;
	}

}

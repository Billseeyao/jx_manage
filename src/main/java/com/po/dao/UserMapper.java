package main.java.com.po.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import main.java.com.po.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	List<UserEntity> getUserObject();
//	UserEntity getUserObject();

	String isExistUser(UserEntity user);
	
	void insert(UserEntity user);
}

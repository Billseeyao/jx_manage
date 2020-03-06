package main.java.com.po.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import main.java.com.po.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	List<UserEntity> getUserObject(Map<String,Object> map);

	int queryTotal();
	
	String isExistUser(UserEntity user);
	
	void insert(UserEntity user);
	
	void update(UserEntity entity);
	
	void delete(Long id);
	
	int isExist(String name);
	
	UserEntity getUser(Long id);

}

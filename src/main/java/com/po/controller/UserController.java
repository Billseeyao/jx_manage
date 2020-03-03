package main.java.com.po.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import main.java.com.po.dao.UserMapper;
import main.java.com.po.entity.UserEntity;
import main.java.com.utils.MD5Util;
import main.java.com.utils.ReMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

//	@Autowired 
//	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/login")
	public void queryUser(){
//		List<UserEntity> userDatas = userService.getUser();
		List<UserEntity> userDatas = userMapper.getUserObject();
		for(UserEntity entity : userDatas){
			String username = entity.getName();
			
			logger.info("["+username+"]");
		}
		
	}
	
	
	/**
	 * 新增用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public ReMessage userAdd(HttpServletRequest request){
		UserEntity user = new UserEntity();
		try {
			user.setName(request.getParameter("userName"));
			String pwd = request.getParameter("passWord");
			user.setPassWord(MD5Util.string2MD5(pwd)); //md5加密
			user.setState(request.getParameter("state"));
			user.setType(Long.parseLong(request.getParameter("type")));
			user.setEmail(request.getParameter("email"));
			userMapper.insert(user);
			
			return ReMessage.ok();
		} catch (Exception e){
			logger.error("新增用户异常：" + e.getMessage());
			return ReMessage.error(500, "新增用户异常：" + e.getMessage());
		}
	}
}

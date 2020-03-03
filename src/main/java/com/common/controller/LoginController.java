package main.java.com.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.UserMapper;
import main.java.com.po.entity.UserEntity;
import main.java.com.utils.ReMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户登录controller
 * @author ylyao
 *
 */
@RestController
@RequestMapping(value="/user")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserMapper userMapper;
	
	private String loginUser = "";
	private String pwd = "";
	

	/**
	 * 用户登陆
	 * @param request
	 * @param httpSession
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ReMessage loginIn(HttpServletRequest request){
		
		Map<String,Object> map = new HashMap<String ,Object>();
		try {
			loginUser = request.getParameter("userName");
			pwd = request.getParameter("passWord");
			
			UserEntity entity = new UserEntity();
			entity.setName(loginUser);
			entity.setPassWord(pwd);
			String flag = userMapper.isExistUser(entity);
			
			if("1".equals(flag)){
				request.getSession().setAttribute("currentUser", loginUser); //其他要用到的地方使用 注入HttpSession session即可			
				map.put("user", loginUser);
				return ReMessage.ok(map);
			} else {
				//提示登陆失败
				return ReMessage.error(500, "用户名或密码错误，请重试...");
			}
		} catch (Exception e){
			logger.error("登录异常["+ e.getMessage() +"]，请重试...");
			return ReMessage.error(500, "登录异常，请重试...");
		}
		
	}
	
	/**
	 * 退出登陆
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public ReMessage logout(HttpServletRequest request){
		session.removeAttribute(request.getParameter("userName"));//使Session变成无效，及用户退出
		return ReMessage.ok();
	}

	/**
	 * 登录后获取用户名
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getUser",method = RequestMethod.POST)
	public ReMessage getUser(){
		String user = session.getAttribute("currentUser").toString();
		return ReMessage.ok(user);
	}
	 
}

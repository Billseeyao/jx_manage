package main.java.com.common.controller;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.UserMapper;
import main.java.com.po.entity.User;
import main.java.com.po.entity.UserEntity;
import main.java.com.utils.ReMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private UserEntity user = new UserEntity();
	
	private String loginUser = "";
	private String pwd = "";
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登陆
	 * @param request
	 * @param httpSession
	 */
//	@RequestMapping(value="/login",method = RequestMethod.POST)
//	public ReMessage loginIn(HttpServletRequest request){
	@PostMapping(value="/login")
	public ReMessage loginIn(User user,HttpServletRequest request){
		loginUser = request.getParameter("userName");
		pwd = request.getParameter("passWord");
		
		UserEntity entity = new UserEntity();
		entity.setName(loginUser);
		entity.setPassWord(pwd);
		String flag = userMapper.isExistUser(entity);
		
		//判断是否登陆成功
		if("1".equals(flag)){
			request.getSession().setAttribute("currentUser", loginUser); //其他要用到的地方使用 注入HttpSession session即可			
			//
			return ReMessage.ok();
		} else {
			//提示登陆失败
			return ReMessage.error(500, "用户名或密码错误，请重试...");
		}
	}
	
	/**
	 * 退出登陆
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public ReMessage logout(HttpSession session){
		testSession();
		
		session.invalidate();//使Session变成无效，及用户退出
		return ReMessage.ok();
	}

	@Autowired
	private HttpSession session;
	
	public void testSession(){
		System.out.println(">>>>>>" + session.getAttribute("currentUser").toString());
	}
	
	  @RequestMapping(value = "/test",method = RequestMethod.GET)
	  public String login(HttpServletRequest request){
		  String account = request.getParameter("account");
	        String password = request.getParameter("password");
	        if ("123".equals(account) && "123456".equals(password)){
	            /*如果已经存在Session的话，直接返回它；没有就创建一个，再返回
	             * 当然Session是自动放在responss中的Header中的，这里不用做其他处理*/
	        	request.getSession();
	        	request.getSession().setAttribute("user", account);
	            
	        }else {
	            return "failed";
	        }
	        return "success";
	  }
	  
	
	 
}

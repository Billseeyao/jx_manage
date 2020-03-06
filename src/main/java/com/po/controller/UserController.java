package main.java.com.po.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import main.java.com.po.dao.UserMapper;
import main.java.com.po.entity.UserEntity;
import main.java.com.utils.MD5Util;
import main.java.com.utils.PageUtils;
import main.java.com.utils.ReMessage;
import main.java.com.utils.StringFunctionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserMapper userMapper;
	
	@Value("${jx.passWord}")
	private String passWord;
	
	
	/**
	 * 查询用户信息列表
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/queryList", method = RequestMethod.POST)

	public ReMessage queryList(Integer page, Integer limit){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if(page != null && limit != null){
				map.put("offset", (page - 1) * limit);
				map.put("limit", limit);
			}
			
			List<UserEntity> userDatas = userMapper.getUserObject(map);
			int total = userMapper.queryTotal();
			if(page != null && limit != null){
				PageUtils pageUtil = new PageUtils(userDatas, total, limit, page);
				return ReMessage.ok().put("page", pageUtil);
			} else {
				return ReMessage.ok().put("data", userDatas);
			}
			
		} catch (Exception e) {
			logger.error("查询用户列表异常：" + e.getMessage());
			return ReMessage.error(500, "查询用户列表异常：" + e.getMessage());
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
			String name = request.getParameter("userName");
			user.setName(name);
//			String pwd = request.getParameter("passWord");
			user.setPassWord(MD5Util.string2MD5(passWord)); //md5加密
			
			user.setState("1");
			user.setType(Long.parseLong("2"));
			user.setEmail(request.getParameter("email"));
			user.setRemark(request.getParameter("remark"));
			user.setTelNo(request.getParameter("telNo"));
			user.setPhoneNo(request.getParameter("phoneNo"));
			user.setCreateTime(StringFunctionUtil.getNowTime());
			
			if(userMapper.isExist(name) != 1){
				userMapper.insert(user);
				return ReMessage.ok();
			}else {
				return ReMessage.error(500,"该用户【"+name+"】已经存在！");
			}
			
		} catch (Exception e){
			logger.error("新增用户异常：" + e.getMessage());
			return ReMessage.error(500, "新增用户异常：" + e.getMessage());
		}
	}
	
	/**
	 * 修改用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST)
	public ReMessage modify(HttpServletRequest request){
		UserEntity user = new UserEntity();
		try {
			user.setId(Long.parseLong(request.getParameter("id"))); //前端传过来的
			user.setName(request.getParameter("userName"));

			String pwd = request.getParameter("passWord");
			if(pwd != null){
				user.setPassWord(MD5Util.string2MD5(pwd)); //md5加密
			}
			
//			user.setState(request.getParameter("state"));
//			user.setType(Long.parseLong(request.getParameter("type")));
			user.setEmail(request.getParameter("email"));
			user.setRemark(request.getParameter("remark"));
			user.setTelNo(request.getParameter("telNo"));
			user.setPhoneNo(request.getParameter("phoneNo"));
			user.setUpdateTime(StringFunctionUtil.getNowTime());
			
			userMapper.update(user);
			
			return ReMessage.ok();
		} catch (Exception e){
			logger.error("修改用户信息异常：" + e.getMessage());
			return ReMessage.error(500, "修改用户信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 删除用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public ReMessage delete(HttpServletRequest request){
		try {
			userMapper.delete(Long.parseLong(request.getParameter("id")));//前端传过来的
			return ReMessage.ok();
		} catch (Exception e){
			logger.error("删除用户信息异常：" + e.getMessage());
			return ReMessage.error(500, "删除用户信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 根据id查询用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUser",method = RequestMethod.POST)
	public ReMessage getUser(HttpServletRequest request){
		try {
			UserEntity entity = userMapper.getUser(Long.parseLong(request.getParameter("id")));
			return ReMessage.ok().put("data", entity);//前端传过来的
		} catch (Exception e){
			logger.error("查询用户信息异常：" + e.getMessage());
			return ReMessage.error(500, "查询用户信息异常：" + e.getMessage());
		}
	}
	
}

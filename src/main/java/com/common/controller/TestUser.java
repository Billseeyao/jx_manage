package main.java.com.common.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.com.po.entity.User;
import main.java.com.po.entity.UserEntity;
import main.java.com.po.service.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.xmlrpc.base.Array;

@RestController
@RequestMapping(value="/test")
public class TestUser {
	private Logger logger = LoggerFactory.getLogger(TestUser.class);
	
	   @Autowired
	    private MailService mailService;

	@RequestMapping(value="/test")
	public void tets(){
//		UserEntity user = new UserEntity();
//		logger.info(">>>"+user.getName()+">>>" + user.getPassWord());
		User user = new User();
		logger.info(">>>"+user.getUserName()+">>>" + user.getPwd());
	}
	
	@RequestMapping(value="/email",method = RequestMethod.GET)
	public void testEmain(){
//		mailService.sendSimpleMail("yiluyao_bill@126.com,yiluyao_bill@163.com", "tet", "test");
		
		List<String> ccList = new ArrayList<String>();
		ccList.add("jinfangyao@shjiaxin.com");
		ccList.add("yiluyao_bill@163.com");
		
		mailService.sendAttachmentMail("带附件邮件测试duoren", "测试", "C:/Users/ylyao/Desktop/tm_gl_bal_KSC_20191107.tar.gz.check", 
				"11.check", ccList,"yiluyao_bill@126.com");
		
//		List<String> ccList = new ArrayList<String>();
//		ccList.add("yiluyao_bill@126.com");
//		ccList.add("yiluyao_bill@163.com");
//		mailService.sendTextMail("发送邮件多人", "测试", ccList, "yiluyao_bill@126.com");
	}
}

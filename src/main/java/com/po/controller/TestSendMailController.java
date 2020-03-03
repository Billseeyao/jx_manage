package main.java.com.po.controller;


import main.java.com.po.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSendMailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/send")
    public void show() {
       mailService.sendSimpleMail("yiluyao_bill@163.com", "test mail", "hello ylyao");
    }
}

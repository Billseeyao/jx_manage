package main.java.com.po.dao;


import org.apache.ibatis.annotations.Mapper;
import main.java.com.po.entity.EmailSendInfoEntity;

/**
 * 邮件发送记录
 * @author ylyao
 * @version 1.0
 */
@Mapper
public interface EmailSendInfoMapper {
	
	void save(EmailSendInfoEntity entity);
}

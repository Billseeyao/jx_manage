package main.java.com.po.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

	
	/**
	 * 指定单个人发送邮件
	 * @param to
	 * @param subject
	 * @param content
	 */
	void sendSimpleMail(String to, String subject, String content);
	
	/**
	 * 发送邮件（带附件）
	 * @param subject 邮件主题
	 * @param content 邮件正文
	 * @param filePath 文件的绝对路径
	 * @param fileName 邮件附件的文件名
	 * @param copyTo 抄送人（可多人）
	 * @param to 发送人（可多人）
	 */
	void sendAttachmentMail(String subject, String content, String filePath, String fileName,List<String> copyTo, String... to);
	
	
	/**发送邮件并抄送 （不带附件）
	 * @param subject 主题
	 * @param content 正文
	 * @param ccList 抄送人(可以有多个)
	 * @param to 收件人(可以有多个)
	 */
	void sendTextMail(String subject, String content, List<String> ccList, String... to);
	
}

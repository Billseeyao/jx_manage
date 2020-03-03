package main.java.com.po.service.impl;

import java.io.File;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import main.java.com.po.service.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;


@Component
public class MailServiceImpl implements MailService{
	
	private Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.fromMail.addr}")
	private String from;
	

	@Override
	public void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		
		try {
			mailSender.send(message);
			logger.info("send email is suc...");
		} catch(Exception e){
			logger.error("send email error："+ e.getMessage());
		}
	}

	/**
	 * 发送邮件（带附件）
	 * @param subject 邮件主题
	 * @param content 邮件正文
	 * @param filePath 文件的绝对路径
	 * @param fileName 邮件附件的文件名
	 * @param to 发送人
	 */
	@Override
	public void sendAttachmentMail(String subject, String content,
			String filePath, String fileName,List<String> copyTo, String... to) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setCc(addressesCc(copyTo)); //抄送人地址（可多人）
            helper.setTo(addressesTo(to)); //收件人地址（可多人）
            helper.setSubject(subject);
            helper.setText(content);
            
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(fileName, file);
			mailSender.send(mimeMessage);
			
		}catch(Exception e){
			logger.error("发送邮件异常：" + e.getMessage());
		}
	}


	@Override
	public void sendTextMail(String subject, String content,
			List<String> ccList, String... to) {
		
		//收件人地址
		InternetAddress[] addressesTo = new InternetAddress[to.length];
		if(to != null && to.length>0){
			for(int i=0;i<to.length;i++){
				InternetAddress addressTo = null;
				try {
                    addressTo = new InternetAddress(to[i]);
                    addressesTo[i] = addressTo;
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
		}
		
		//抄送人地址
		InternetAddress[] addressesCc = new InternetAddress[ccList.size()];
		if(ccList != null && ccList.size() > 0){
			for(int i=0;i<ccList.size();i++){
				String ccAdd = ccList.get(i);
				InternetAddress address = null;
				try {
                    address = new InternetAddress(ccAdd);
                    addressesCc[i] = address;
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
		}

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
	        public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom(from);
	            mimeMessage.setSubject(subject);
	            mimeMessage.setText(content);
	            mimeMessage.setRecipients(Message.RecipientType.TO, addressesTo);
	            mimeMessage.setRecipients(Message.RecipientType.CC, addressesCc);
	        }
		};
		mailSender.send(preparator);
	}
	
	
	
	/** 抄送人地址（多人）
	 * @param ccList
	 * @return
	 */
	public InternetAddress[] addressesCc(List<String> ccList){
		InternetAddress[] addressesCc = new InternetAddress[ccList.size()];
		if(ccList != null && ccList.size() > 0){
			for(int i=0;i<ccList.size();i++){
				String ccAdd = ccList.get(i);
				InternetAddress address = null;
				try {
					address = new InternetAddress(ccAdd);
		            addressesCc[i] = address;
		        } catch (Exception e) {
		        	e.printStackTrace();
		        }
			}
		}
		return addressesCc;
	}
	
	/**
	 * 收件人地址（多人）
	 * @param to
	 * @return
	 */
	public InternetAddress[] addressesTo(String... to){
		InternetAddress[] addressesTo = new InternetAddress[to.length];
		if(to != null && to.length>0){
			for(int i=0;i<to.length;i++){
				InternetAddress addressTo = null;
				try {
                    addressTo = new InternetAddress(to[i]);
                    addressesTo[i] = addressTo;
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
		}
		return addressesTo;
	}
}

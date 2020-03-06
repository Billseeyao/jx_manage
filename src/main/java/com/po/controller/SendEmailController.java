package main.java.com.po.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.dao.SupplierManageMapper;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.SupplierManageEntity;
import main.java.com.po.service.MailService;
import main.java.com.po.service.PdfService;
import main.java.com.utils.ReMessage;
import main.java.com.utils.StringFunctionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class SendEmailController {
	
	private Logger logger = LoggerFactory.getLogger(SendEmailController.class);
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private SupplierManageMapper supplierManageMapper;
	
	@Autowired
	private PdfService pdfService;
	
//	@Value("$path")
//	private String path;
	
	
	/**
	 * 创建订单后发送邮件
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sendEmail")
	public ReMessage sendEmail(HttpServletRequest request){
		
		String supplierName = "",supplierNo = "";
		
		try {
			String orderNo = request.getParameter("orderNo"); //订单号
			
			OrderManageEntity entity = orderManageMapper.queryDataByNo(orderNo);
			if(entity != null){
				supplierNo = entity.getSupplierNo();
				SupplierManageEntity companyEntity = supplierManageMapper.querySupplierInfo(supplierNo);
				if(companyEntity != null){
					supplierName = companyEntity.getManageName(); //供应商名称
				}
			}
			
			String subject = "加鑫最新订购单"+orderNo; //邮件主题
			String content = "尊敬的供应商" + supplierName + ":"
					+ ""
					+ "附件为加鑫最新订购单 " + orderNo +"；"
					+ "收到订单后请在24小时内以电子邮件的方式进行确认。"
					+ "请核对内容、确认无误后邮件回复：将盖章确认后的订单作为邮件附件，邮件内容统一为”订单收到，将按订单要求送货“；"
					+ "若不能按订单要求送货，请回复具体原因以及确认到货日期。"
					+ "如被接受，我公司将会更新到货日期；如不可接受，会与贵司销售人员联系，达成一致到货日期后再更新。"
					+ ""
					+ "上海加鑫净化设备有限公司"
					+ ""
					+ StringFunctionUtil.getNowTime();// 邮件内容
			
			String path = "D:/pdfTest/testTableDemo" + StringFunctionUtil.getApplyNo() + ".pdf";;
			String filePath = pdfService.createPDF(path) ; //附件pdf所在服务器路径
			
			String fileName = subject+".pdf";//邮件附件文件名
			
			List<String> ccList = new ArrayList<String>();
//			ccList.add("jinfangyao@shjiaxin.com");
			ccList.add("yiluyao_bill@163.com");
			String to = "yiluyao_bill@126.com";

			mailService.sendAttachmentMail(subject, content, filePath, fileName, ccList, to);
			return ReMessage.ok("保存成功");
		} catch(Exception e){
			logger.error("保存发票信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存异常：" + e.getMessage());
		}
	}
}

package main.java.com.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.po.dao.EmailSendInfoMapper;
import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.dao.ProductManageMapper;
import main.java.com.po.entity.EmailAppendixExcelEntity;
import main.java.com.po.entity.EmailSendInfoEntity;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.ProductManageEntity;
import main.java.com.po.service.MailService;
import main.java.com.utils.DateUtil;
import main.java.com.utils.ExcelUtil;
import main.java.com.utils.StringFunctionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 每天10:30邮件提示任务 规则及思路： 1、查询订单表中status = '2' or status =
 * '3'的订单（以供应商编号、供应商联系人分组查询），得到所有需要邮件提醒的 供应商编号、供应商联系人 2、根据上面的 供应商编号、供应商联系人
 * 查询出对应的订单号 （条件 status='2' or '3'） 3、根据2中的订单号，查询出 供应商编号、供应商联系人 对应的所有
 * '2'或者'3'的excel列表数据，后在服务器中生成excel 4、发送邮件（附件、供应商联系人email、抄送人、主题、内容） 5、发送成功后插记录
 * 
 * @author ylyao
 * @version 1.0
 */
@Component
public class EmailSchedulerTask {
	private Logger logger = LoggerFactory.getLogger(EmailSchedulerTask.class);

	private final String OVERSTATUS = "逾期订单";
	private final String SHORTNUMBERSTATUS = "未到货、未逾期";

	@Autowired
	private OrderManageMapper orderManageMapper;

	@Autowired
	private ProductManageMapper productManageMapper;

	@Autowired
	private EmailSendInfoMapper emailSendInfoMapper;

	@Scheduled(cron = "0 30 10 ? * MON-FRI")
	private void process() {

		List<EmailAppendixExcelEntity> excelData3 = new ArrayList<EmailAppendixExcelEntity>();
		Set<String> set = new HashSet<String>();

		try {
			//获取订单异常的收件人邮箱
			List<OrderManageEntity> orderDatas = orderManageMapper.queryAbnomal(null);
			for (OrderManageEntity entity : orderDatas) {
				set.add(entity.getEmail());
			}

			String prodectNo = "", productName = "", orderNo = "", productDesc = "", number = "", holdNumber = "", arrivalDate = "", remark = "", status = "";
			OrderManageEntity entity = new OrderManageEntity();
			for (String email : set) {
				//获取对应收件人邮箱所对应的附件订单数据
				entity.setEmail(email);
				List<OrderManageEntity> orderByEmailDatas = orderManageMapper.queryAbnomal(entity);
				for (OrderManageEntity emailDataEntity : orderByEmailDatas) {
					orderNo = emailDataEntity.getOrederNo();
					productName = emailDataEntity.getProductName();
					prodectNo = emailDataEntity.getProductNo();
					number = emailDataEntity.getNumber();
					holdNumber = emailDataEntity.getHoldNumber();
					arrivalDate = emailDataEntity.getArrivalDate();
					remark = emailDataEntity.getOrderRemarks();
					status = emailDataEntity.getStatus();
					ProductManageEntity productEntity = productManageMapper
							.queryProductInfo(prodectNo);
					if (!StringFunctionUtil.isEmpty(productEntity)) {
						productDesc = productEntity.getProductDecribe();
					}

					EmailAppendixExcelEntity appendixEntity = new EmailAppendixExcelEntity(
							orderNo, productName, productDesc, number,
							holdNumber, arrivalDate, status, remark);
					excelData3.add(appendixEntity);
				}

				// 生成excel
				String filePath = "D:/" + productName + ".xls";
				String path = ExcelUtil.createExcel(
						EmailAppendixExcelEntity.class, excelData3, null, "订单",
						filePath);
				// 获取抄送人
				List<String> co = new ArrayList<String>();
				co.add("yiluyao_bill@163.com");
				// 主题
				String subject = "加鑫订购单提醒";
				// 内容
				String content = "附件清单仅供核对，订单状态与到货情况如与实际情况相符，该邮件无需回复。有任何问题，请及时跟采购人员沟通。上海加鑫净化设备有限公司";
				// 发送邮件
				mailService.sendAttachmentMail(subject, content, path,
						productName + ".xls", co, email);
				
				emailSendInfoMapper.save(new EmailSendInfoEntity(filePath,
						subject, "", getCoCopy(co), email, StringFunctionUtil.getNowTime()));
			}

		} catch (Exception e) {
			logger.error("邮件提醒发送异常：" + e.getMessage());
		}

	}

	@Autowired
	private MailService mailService;

	/**
	 * 获得订单中每个产品的订单状态
	 * 
	 * @param surplusNum
	 *            未到货数量
	 * @param arrivalDate
	 *            到货日期
	 * @return
	 */
	public String getProductOrderStatus(int surplusNum, String arrivalDate) {
		String orderStatus = "";
		if (surplusNum > 0) { // 订单不足量
			if (DateUtil.isOverDay(arrivalDate)) {
				orderStatus = SHORTNUMBERSTATUS;
			} else {
				orderStatus = OVERSTATUS;
			}
		}
		return orderStatus;
	}

	/**
	 * 获取抄送人拼接字符串
	 * @param list
	 * @return 
	 */
	public String getCoCopy(List<String> list){
		StringBuffer sb = new StringBuffer();
		if(!StringFunctionUtil.isEmpty(list)){
			for(int i =0,length = list.size();i < length ; i++){
				sb.append(list.get(i)).append(",");
			}
			return sb.toString().substring(0,sb.toString().length() - 1);
		} else {
			return "";
		}
		
	}

}

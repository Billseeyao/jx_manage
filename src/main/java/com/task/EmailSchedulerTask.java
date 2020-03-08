package main.java.com.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.dao.ProductManageMapper;
import main.java.com.po.entity.EmailAppendixExcelEntity;
import main.java.com.po.entity.ExcelData;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.ProductManageEntity;
import main.java.com.po.service.MailService;
import main.java.com.utils.DateUtil;
import main.java.com.utils.ExcelUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 每天10:30邮件提示任务
 * 规则及思路：
 * 		1、查询订单表中status = '2' or status = '3'的订单（以供应商编号、供应商联系人分组查询），得到所有需要邮件提醒的 供应商编号、供应商联系人
 * 		2、根据上面的 供应商编号、供应商联系人 查询出对应的订单号 （条件 status='2' or '3'）
 * 		3、根据2中的订单号，查询出  供应商编号、供应商联系人 对应的所有 '2'或者'3'的excel列表数据，后在服务器中生成excel
 * 		4、发送邮件（附件、供应商联系人email、抄送人、主题、内容）
 * 		5、发送成功后插记录
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

	@Scheduled(cron="* * 5 * * ?")
	private void process(){
		
		List<EmailAppendixExcelEntity> excelData3 = new ArrayList<EmailAppendixExcelEntity>();
		
		orderManageMapper.queryAbnomal(entity)
		
		
		//生成excel
		String filePath = "D:/"+email+".xls";
		String path = ExcelUtil.createExcel(EmailAppendixExcelEntity.class, excelData3, null, "订单", filePath);
		
		//发送邮件
		List<String> co = new ArrayList<String>();
		co.add(email);
		mailService.sendAttachmentMail("加鑫订购单提醒", "附件清单仅供核对，订单状态与到货情况如与实际情况相符，该邮件无需回复。有任何问题，请及时跟采购人员沟通。上海加鑫净化设备有限公司", 
				path, email+".xls", co, email);
	}
	
	@Autowired
	private MailService mailService;
	
	/**
	 * 获得订单中每个产品的订单状态
	 * @param surplusNum 未到货数量
	 * @param arrivalDate 到货日期
	 * @return
	 */
	public String getProductOrderStatus(int surplusNum, String arrivalDate){
		String orderStatus = "";
		if(surplusNum > 0){ //订单不足量
			if(DateUtil.isOverDay(arrivalDate)){
				orderStatus = SHORTNUMBERSTATUS;
			} else {
				orderStatus = OVERSTATUS;
			}
		}
		return orderStatus;
	}
	
	
	
	
	
	
	
	
	
//	public void aa(){
//
//		
//		List<ExcelData> excelDatas = new ArrayList<ExcelData>();
////		List<String> excelLine = null;
//		List<OrderManageEntity> abnomalDatas = orderManageMapper.queryAbnomal(null); //查询异常订单
//		for(OrderManageEntity dataEntity : abnomalDatas){
//			String orderNo = dataEntity.getOrederNo();
//			String productNo = dataEntity.getProductNo();
//			String email = dataEntity.getEmail();
//			
//			String[] num = productNo.split(",");
//			for(int i = 0 ,len = num.length; i < len; i++){
////				excelLine = new ArrayList<String>();
//				
//				ProductManageEntity productEntity = productManageMapper.queryProductInfo(num[i]);
////				excelLine.add(orderNo); //订单号
////				excelLine.add();//产品名称
////				excelLine.add(); //产品描述
//				
////				int number = Integer.parseInt(productEntity.getNumber()); //订单数量
////				int holdNumber = Integer.parseInt(productEntity.getHoldNumber()); //已到数量
//				int surplusNum = number - holdNumber;	
//				String arrivalDate = productEntity.getArrivalDate(); //到货日期
//				
////				excelLine.add(String.valueOf(number));
////				excelLine.add(String.valueOf(surplusNum)); //未到货数量
////				excelLine.add(arrivalDate); 
////				excelLine.add(getProductOrderStatus(surplusNum, arrivalDate));//订单状态
////				excelLine.add(productEntity.getRemarks());//产品备注
//				
//				ExcelData excelData = new ExcelData(orderNo, productEntity.getProductName(),
//						productEntity.getProductDecribe(), String.valueOf(number),String.valueOf(surplusNum), arrivalDate, 
//						getProductOrderStatus(surplusNum, arrivalDate), productEntity.getRemarks(),email);
//				
//				//获得excel数据
//				excelDatas.add(excelData);
//			}
//		}
//		
//		Set<String> set = new HashSet<String>(); 
//		for(int i =0 ,len = excelDatas.size(); i < len; i++){
////			logger.info(">>>>>>"+ excelDatas.get(i).getOrderNo() +"||"+excelDatas.get(i).getProductName()+"||" + "<<<<<<<<" + excelDatas.get(i).getEmail());
//			set.add(excelDatas.get(i).getEmail());
//		}
//		logger.info(">>>>>>>>>>" + set);
//		
//		//获取异常订单中供应商联系人邮箱
//		OrderManageEntity entity = new OrderManageEntity();
//		for(String email : set){
//			List<ExcelData> excelData2 = new ArrayList<ExcelData>();
//			List<EmailAppendixExcelEntity> excelData3 = new ArrayList<EmailAppendixExcelEntity>();
//			entity.setEmail(email);
//			List<OrderManageEntity> excelOrders = orderManageMapper.queryAbnomal(entity);
//			
//			for(OrderManageEntity orderEntity : excelOrders){
//				String excelOrderNo = orderEntity.getOrederNo();
//				String productNo = orderEntity.getProductNo();
//				
//				String[] num = productNo.split(",");
//				for(int i = 0 ,len = num.length; i < len; i++){
////					excelLine = new ArrayList<String>();
//					
//					ProductManageEntity productEntity = productManageMapper.queryProductInfo(num[i]);
//					
//					int number = Integer.parseInt(productEntity.getNumber()); //订单数量
//					int holdNumber = Integer.parseInt(productEntity.getHoldNumber()); //已到数量
//					int surplusNum = number - holdNumber;	
//					String arrivalDate = productEntity.getArrivalDate(); //到货日期
//					
//					ExcelData excelData = new ExcelData(excelOrderNo, productEntity.getProductName(),
//							productEntity.getProductDecribe(), String.valueOf(number),String.valueOf(surplusNum), arrivalDate, 
//							getProductOrderStatus(surplusNum, arrivalDate), productEntity.getRemarks(),email);
//					
//					//获得excel数据
//					excelData2.add(excelData);
//					
//					EmailAppendixExcelEntity excelEntity = new EmailAppendixExcelEntity(excelOrderNo,productEntity.getProductName(),
//							productEntity.getProductDecribe(), String.valueOf(number),String.valueOf(surplusNum), arrivalDate, 
//							getProductOrderStatus(surplusNum, arrivalDate), productEntity.getRemarks());
//					excelData3.add(excelEntity);
//				}
//			}
//			
//			for(int i =0 ,len = excelData2.size(); i < len; i++){
//				logger.info(">>>>>>"+ excelData2.get(i).getOrderNo() +"||"+excelData2.get(i).getProductName()+"||" + "<<<<<<<<" + excelData2.get(i).getEmail());
//			}
//			
//			//生成excel
//			String filePath = "D:/"+email+".xls";
//			String path = ExcelUtil.createExcel(EmailAppendixExcelEntity.class, excelData3, null, "订单", filePath);
//			
//			//发送邮件
//			List<String> co = new ArrayList<String>();
//			co.add(email);
//			mailService.sendAttachmentMail("加鑫订购单提醒", "附件清单仅供核对，订单状态与到货情况如与实际情况相符，该邮件无需回复。有任何问题，请及时跟采购人员沟通。上海加鑫净化设备有限公司", 
//					path, email+".xls", co, email);
//			
//		
//		}		
//				
//		
//    
//	}
	
	
	
	
	
	
	
	
	
}

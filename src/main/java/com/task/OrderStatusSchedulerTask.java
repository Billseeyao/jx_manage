package main.java.com.task;

import java.util.List;

import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.dao.ProductManageMapper;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.ProductManageEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 每天凌晨1:00订单状态更新任务
 * 规则及思路：
 * 		1、查询订单表 status!= 0的订单，得出所有的产品号
 * 		2、根据产品号查询产品表，获得产品的起订量(number)、已收到数量(hold_number)、到货日期(arrival_date) 
 * 		3、起订量(number) - 已收到数量(hold_number) > 0 && 到货日期(arrival_date) < 当天   则 status 更新成 '3'
 * 		      起订量(number) - 已收到数量(hold_number) > 0 && 到货日期(arrival_date) >= 当天   则 status 更新成 '2'
 * 		4、status 0关闭订单; 1正常订单(创建订单默认为1、正常订单也为1); 2未到期未逾期; 3逾期订单
 * @author ylyao
 * @version 1.0
 * 		5、修正第4点， status 0关闭订单; 1正常订单; 2异常订单[订单含有多个产品时只要订单异常，可根据订单号查询到产品是否逾期，发送excel时再细分是"未到货未逾期"、"逾期订单"、"正常订单"] 2020-02-28
 */
@Component
public class OrderStatusSchedulerTask {
	private Logger logger = LoggerFactory.getLogger(OrderStatusSchedulerTask.class);
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private ProductManageMapper productManageMapper;
	
	private int number = 0;
	private int holdNumber = 0;
	private String arrivalDate = "";
	

	@Scheduled(cron="0 0 1 * * ?")
	private void process(){
		
		logger.info("每天凌晨订单状态更新任务 start...");
		
		List<OrderManageEntity> orderDatas = orderManageMapper.queryNomal();
		for(OrderManageEntity entity : orderDatas){
			String orderNo = entity.getOrederNo(); //订单号
			String productNo = entity.getProductNo(); //产品号
			
			String[] num = productNo.split(",");
			OrderManageEntity orderManageEntity = new OrderManageEntity();
			orderManageEntity.setStatus(getOrderStatus(num));
			orderManageEntity.setOrederNo(orderNo);
			orderManageMapper.update(orderManageEntity);
		}
		
		logger.info("每天凌晨订单状态更新任务 end ...");
	}
	
	
	public String getOrderStatus(String[] productNos){
		String flag = "1";
		for(int i = 0,len = productNos.length;i < len; i++){
			ProductManageEntity productData = productManageMapper.queryProductInfo(productNos[i]);
			number = Integer.parseInt(productData.getNumber());// 起订量(number)
			holdNumber = Integer.parseInt(productData.getHoldNumber());//已收到数量(hold_number)
			arrivalDate = productData.getArrivalDate();//到货日期(arrival_date)
			if(isAbnormal(number, holdNumber, arrivalDate)){
				flag = "2";
				break;
			}
		}
		 
		return flag;
	}
	
	/**
	 * 判断订单是否异常
	 * @param number 起订量
	 * @param holdNumber 已收到数量
	 * @param arrivalDate 到货日期
	 * @return true是异常、false不是异常
	 */
	public boolean isAbnormal(int number,int holdNumber, String arrivalDate){
		boolean flag = false;
		if(number - holdNumber > 0){
			flag = true;
		}
		return flag;
	}
	
}

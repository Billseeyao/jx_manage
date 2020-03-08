package main.java.com.task;

import java.util.List;

import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.utils.DateUtil;
import main.java.com.utils.StringFunctionUtil;

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
 * 		3、起订量(number) - 已收到数量(hold_number) > 0 && 到货日期(arrival_date) < 当天   则 status 更新成 '3';
 * 		      起订量(number) - 已收到数量(hold_number) > 0 && 到货日期(arrival_date) >= 当天   则 status 更新成 '2';
 * 		      起订量(number) - 已收到数量(hold_number) = 0 则status 更新成 '1'.
 * 		4、status 0关闭订单; 1正常订单(创建订单默认为1、正常订单也为1); 2未到期未逾期; 3逾期订单
 * @author ylyao
 * @version 1.0
 */
@Component
public class OrderStatusSchedulerTask {
	private Logger logger = LoggerFactory.getLogger(OrderStatusSchedulerTask.class);
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Scheduled(cron="0 0 1 * * ?")
	private void process(){
		
		logger.info("每天凌晨订单状态更新任务 start...");
		
		List<OrderManageEntity> orderDatas = orderManageMapper.queryNomal();
		
		for(OrderManageEntity entity : orderDatas){
			String orderNo = entity.getOrederNo(); //订单号
			String productNo = entity.getProductNo(); //产品号
			String supplierNo = entity.getSupplierNo();//供应商编号
			String number = entity.getNumber();
			String holdNumber = entity.getHoldNumber();
			String arrivalDate = entity.getArrivalDate();
			
			OrderManageEntity orderManageEntity = new OrderManageEntity();
			orderManageEntity.setStatus(getOrderStatus(number,holdNumber,arrivalDate));
			orderManageEntity.setOrederNo(orderNo);
			orderManageEntity.setProductNo(productNo);
			orderManageEntity.setSupplierNo(supplierNo);
			orderManageEntity.setUpdateTime(StringFunctionUtil.getNowTime());
			orderManageMapper.updateStatus(orderManageEntity);
		}
		
		logger.info("每天凌晨订单状态更新任务 end ...");
	}
	
	/**
	 * 比较获得订单状态
	 * 规则:
	 *  	起订量(number) - 已收到数量(hold_number) > 0 && 到货日期(arrival_date) < 当天   则 status 更新成 '3';
	 * 		起订量(number) - 已收到数量(hold_number) > 0 && 到货日期(arrival_date) >= 当天   则 status 更新成 '2';
	 * 		 起订量(number) - 已收到数量(hold_number) = 0 则status 更新成 '1'.
	 * @param number
	 * @param holdNumber
	 * @param arrivalDate
	 * @return
	 */
	public String getOrderStatus(String number, String holdNumber, String arrivalDate){
		String flag = "1";
		if(number != null && holdNumber != null){
			int pulsNum = Integer.parseInt(number) - Integer.parseInt(holdNumber);
			if(pulsNum > 0){
				if(DateUtil.isOverDay(arrivalDate)){
					flag = "2";
				}else{
					flag = "3";
				}
			}else if(pulsNum == 0){
				flag = "1";
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

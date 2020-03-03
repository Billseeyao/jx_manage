package main.java.com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtil {
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	
	
	/**
	 * 判断是否超过当天
	 * @param arrivalDate
	 * @return true超过,false没超过
	 */
	public static boolean isOverDay(String arrivalDate){
		if(StringFunctionUtil.isEmpty(arrivalDate)) return false;
		
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = sdf.parse(arrivalDate);
			logger.info("date:" + date.getTime() +"<> date2:" + date2.getTime());
			if(date.getTime() < date2.getTime()){
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			logger.error("判断日期是否超过当天异常："+e.getMessage());
			return false;
		}
	}
	
	public static void main(String[] args) {
		logger.info(">>"+isOverDay("2019-01-01"));
		logger.info(">>"+isOverDay("2020-02-28"));
		logger.info(">>"+isOverDay("2020-02-29"));

	}

}

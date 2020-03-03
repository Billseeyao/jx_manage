package main.java.com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringFunctionUtil {
	
	private static Logger logger = LoggerFactory.getLogger(StringFunctionUtil.class);
	
	
	
	//生成申请编号
	public static String getApplyNo(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
		return df.format(new Date());
	}
	
	public static boolean isEmpty(List list){
		if(list.isEmpty()){
			return true;
		}else {
			return false;
		}
	}
	
	
	public static boolean isEmpty(Object obj){
		if(obj == null){
			return true;
		}else {
			return false;
		}
	}
	
	public static String getNowTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}

	public static void main(String[] args) {
		logger.info(getApplyNo());
	}

}

package main.java.com.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import main.java.com.po.entity.EmailAppendixExcelEntity;
import main.java.com.utils.ExcelUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	private Logger logger = LoggerFactory.getLogger(Test.class);
	
	  @RequestMapping("export")
	    public void export(HttpServletResponse response){

	        //模拟从数据库获取需要导出的数据
	        List<EmailAppendixExcelEntity> line = new ArrayList<EmailAppendixExcelEntity>();
	        EmailAppendixExcelEntity entity = new EmailAppendixExcelEntity("JX001","1111","1111","222","JX001","1111","1111","222");
	        EmailAppendixExcelEntity entity2 = new EmailAppendixExcelEntity("JX001","1111","1111","222","JX001","1111","1111","222");
	        line.add(entity);
	        line.add(entity2);

	        //导出操作
	        try {
				ExcelUtil.exportExcel(line,"花名册","草帽一伙",EmailAppendixExcelEntity.class,"海贼王.xls",response);
			} catch (Exception e) {
				logger.error(">>>" + e.getMessage());
				e.printStackTrace();
			}
	    }
	  
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		
		List<Object> list = new ArrayList<Object>();
		Map<String,String> map = new HashMap<String, String>();
		list.add(map.put("HNKNF001", "何老板"));
//		list.add(map.put("HNKNF001", "李晓明"));
//		list.add(map.put("HNKNF001", "何老板"));
		
		System.out.println(list);
		set.add(list);
		System.out.println(set);
		
		String email = "yiluyao_bill@163.com";
		String filePath = "D:/"+email.substring(0, email.length() - 8) +".xls";
		System.out.println(filePath);

	}

}

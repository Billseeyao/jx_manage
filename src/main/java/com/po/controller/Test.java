package main.java.com.po.controller;

import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;







//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args) {
	
		
//		String aa = " {\"show\":true,\"orderDialogTitle\":\"创建订单\"} ";
//		JSONObject jsonObject =JSONObject.parseObject(aa);
//		System.out.println(jsonObject);
//		
//		Iterator iter = jsonObject.entrySet().iterator();
//		while (iter.hasNext()) {
//			Map.Entry entry = (Map.Entry) iter.next();
//			
//            System.out.println(entry.getKey().toString());
//            System.out.println(entry.getValue().toString());
//		}
		
		String bb = "[{\"id\":\"4\",\"modelNo\":\"DB001\"},{\"id\":\"4\",\"modelNo\":\"DB001\"},{\"id\":\"4\",\"modelNo\":\"DB001\"}] ";
//		System.out.println(bb.substring(1, bb.length()-2));
//		JSONObject jsonObject =JSONObject.parseObject(bb);
//		JSONObject  json  =  JSONArray.parseObject(bb.substring(0, bb.length()-1)); 
		JSONArray array = JSONArray.parseArray(bb);
		System.out.println(array);
		JSONObject oject = (JSONObject) array.get(0);
		System.out.println();
		
		Iterator iter = oject.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			
            System.out.println(entry.getKey().toString());
            System.out.println(entry.getValue().toString());
		}
//		
//		Map<String, Object> data =new HashMap<String, Object>();
//		//循环转换
//		 Iterator it =obj.entrySet().iterator();
//		 while (it.hasNext()) {
//		       Map.Entry<String, Object> entry = (Entry<String, Object>) it.next();
//		       data.put(entry.getKey(), entry.getValue());
//		 }
//		System.out.println("map对象:"+data.toString());
		
	
	
	}

}

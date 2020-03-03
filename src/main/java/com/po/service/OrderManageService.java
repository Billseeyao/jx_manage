package main.java.com.po.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface OrderManageService {
	
	//预览
	Map<String,Object> previewData(String orderNo);
}

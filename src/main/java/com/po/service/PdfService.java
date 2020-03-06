package main.java.com.po.service;


import org.springframework.stereotype.Service;

@Service
public interface PdfService {
	
	/**
	 * 创建pdf
	 * @return
	 */
	String createPDF(String path);

}


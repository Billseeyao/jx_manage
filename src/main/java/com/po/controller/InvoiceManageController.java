package main.java.com.po.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.InvoiceManageMapper;
import main.java.com.po.entity.InvoiceManageEntity;
import main.java.com.utils.ReMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/invoice")
public class InvoiceManageController {
	
	private Logger logger = LoggerFactory.getLogger(InvoiceManageController.class);

	@Autowired
	private HttpSession session;
	
	@Autowired
	private InvoiceManageMapper invoiceManageMapper;
	
	
	/**
	 * 保存发票信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveData", method = RequestMethod.POST)
	public ReMessage saveInfo(HttpServletRequest request){
		
		String invoicId = request.getParameter("invoice_id");
		String invoiceName = request.getParameter("invoice_name");
		String invoiceNo = request.getParameter("invoice_no");
		String ivoiceAddress = request.getParameter("ivoice_address");
		String invoicePhoneNo = request.getParameter("invoice_phoneno");
		String invoiceBank = request.getParameter("invoice_bank");
		String invoiceAccountNo = request.getParameter("invoice_accountno");
		String invoiceDescribe = request.getParameter("invoice_describe");
		String createUser = request.getParameter(session.getAttribute("currentUser").toString());
		try {
			InvoiceManageEntity entity = new InvoiceManageEntity(invoicId, invoiceName, invoiceNo, ivoiceAddress, invoicePhoneNo, 
					invoiceBank, invoiceAccountNo, invoiceDescribe, createUser);
			invoiceManageMapper.insert(entity);
			
			return ReMessage.ok("保存成功");
		} catch(Exception e){
			logger.error("保存发票信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存异常：" + e.getMessage());
		}
	}
	
	/**
	 * 根据开票编号(公司编号)查询开票信息
	 * @param request 获取invoice_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public ReMessage query(HttpServletRequest request){
		String invoiceId = request.getParameter("invoice_id"); //开票编号(和公司编号关联)

		Map<String,Object> map = new HashMap<String,Object>();
		try {
			InvoiceManageEntity invoiceEntity = invoiceManageMapper.queryInvoiceInfo(invoiceId);
			map.put("data", invoiceEntity);
			return ReMessage.ok(map);
		} catch(Exception e){
			logger.error("查询发票信息异常：" + e.getMessage());
			return ReMessage.error(500, "查询发票信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 修改开票信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ReMessage modify(HttpServletRequest request){
		String invoicId = request.getParameter("invoice_id");//开票编号(和公司编号关联)
		String invoiceName = request.getParameter("invoice_name");
		String invoiceNo = request.getParameter("invoice_no");
		String ivoiceAddress = request.getParameter("ivoice_address");
		String invoicePhoneNo = request.getParameter("invoice_phoneno");
		String invoiceBank = request.getParameter("invoice_bank");
		String invoiceAccountNo = request.getParameter("invoice_accountno");
		String invoiceDescribe = request.getParameter("invoice_describe");
		String createUser = request.getParameter("create_user");
		try {
			InvoiceManageEntity entity = new InvoiceManageEntity(invoicId, invoiceName, invoiceNo, ivoiceAddress, invoicePhoneNo, 
					invoiceBank, invoiceAccountNo, invoiceDescribe, createUser);
			invoiceManageMapper.update(entity);
			
			return ReMessage.ok("保存成功");
		} catch(Exception e){
			logger.error("修改发票信息异常：" + e.getMessage());
			return ReMessage.error(500, "修改发票信息异常：" + e.getMessage());
		}
	
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ReMessage delete(HttpServletRequest request){
		String invoicId = request.getParameter("invoice_id");//开票编号(和公司编号关联)
		try {
			
			invoiceManageMapper.delete(invoicId);
			
			return ReMessage.ok("删除成功");
		} catch(Exception e){
			logger.error("删除发票信息异常：" + e.getMessage());
			return ReMessage.error(500, "删除发票异常：" + e.getMessage());
		}
	}
}

package main.java.com.po.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import main.java.com.po.dao.InvoiceManageMapper;
import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.dao.ProductManageMapper;
import main.java.com.po.dao.SupplierManageMapper;
import main.java.com.po.dao.SupplierUserManageMapper;
import main.java.com.po.entity.InvoiceManageEntity;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.ProductManageEntity;
import main.java.com.po.entity.SupplierManageEntity;
import main.java.com.po.entity.SupplierUserManageEntity;
import main.java.com.po.service.OrderManageService;
import main.java.com.utils.StringFunctionUtil;

/**
 * 订单管理
 * @author ylyao
 * @version 1.0
 */
@Component
public class OrderManageServiceImpl implements OrderManageService{
	
	private Logger logger = LoggerFactory.getLogger(OrderManageServiceImpl.class);
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private InvoiceManageMapper invoiceManageMapper;
	
	@Autowired
	private ProductManageMapper productMapper;
	
	@Autowired
	private SupplierManageMapper supplierManageMapper;
	
	@Autowired
	private SupplierUserManageMapper supplierUserManageMapper;
	
	@Value("${jx.invoiceId}")
	private String invoiceId;
	
	
	private String arrivalDate = "";

	//订单预览
	@Override
	public Map<String, Object> previewData(String orderNo) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Map<String, String>> productDatas = new ArrayList<Map<String,String>>();
		
//		try {
			OrderManageEntity entity = orderManageMapper.queryDataByNo(orderNo);
			String productNo = entity.getProductNo();//获取产品编号
			String supplierNo = entity.getSupplierNo();// 获取供应商编号
//			String invoiceId = entity.getInvoiceId();// 开票编号
			
			//查询订单相关信息
			dataMap.put("orderInfoData",orderData(orderNo));
			//查询关联的产品信息
			String[] num = productNo.split(",");
			for(int i = 0,length = num.length; i < length; i++){
				productDatas.add(productInfo(num[i]));
			}
			dataMap.put("productDatas", productDatas);
			
			//查询对应开票信息
			dataMap.put("invoiceData", invoiceInfo(invoiceId));
			//查询供应商付款信息
			dataMap.put("supplierData", supplierInfo(supplierNo));
			//查询所在供应商联系人
			dataMap.put("supplierUserData", supplierUserInfo(supplierNo));
			
//		} catch (Exception e){
//			logger.error("" + e.getMessage());
//		}
		
		return dataMap;
	}
	
	
	
	
	/**
	 * 根据产品编号查询关联的产品信息
	 * 注意：订单的到货日期放在产品表里（订单表中存在一个订单多个产品的关系，订单中的每个产品到货日期可能不同，所以暂时到货日期放在产品表里。）
	 * @param orderNo
	 * @return
	 */
	public Map<String,String> productInfo(String productNo){
		
		Map<String,String> map = new HashMap<String, String>();
		try {
			ProductManageEntity entity = productMapper.queryProductInfo(productNo);
			if(!StringFunctionUtil.isEmpty(entity)){
//				map.put("modelNo", entity.getModelNo());
				map.put("productName", entity.getProductName()); //产品名称
				map.put("productDecribe", entity.getProductDecribe());//产品描述
//				map.put("qualityStandard", entity.getQualityStandard());//
				map.put("number", entity.getNumber()); //数量
//				map.put("holdNumber", entity.getHoldNumber());
				map.put("unitPrice", entity.getUnitPrice());//单价不含税
				map.put("taxRate", entity.getTaxRate());//税率
				map.put("taxAmount",entity.getTaxAmount());//税额
				map.put("arrivalDate",entity.getArrivalDate());//到货日期
				
				map.put("remarks", entity.getRemarks());//备注
			}
			
		}catch(Exception e){
			logger.error("通过供应商编号查询对应开票信息异常：" + e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 通过供应商编号查询对应开票信息
	 * @param invoiceId
	 * @return
	 */
	public Map<String,String> invoiceInfo(String invoiceId){
		Map<String,String> map = new HashMap<String, String>();
		try {
			InvoiceManageEntity invoiceEntity = invoiceManageMapper.queryInvoiceInfo(invoiceId);
			if(!StringFunctionUtil.isEmpty(invoiceEntity)){
				map.put("invoiceName", invoiceEntity.getInvoiceName());
				map.put("invoiceNo", invoiceEntity.getInvoiceNo());
				map.put("ivoiceAddress", invoiceEntity.getIvoiceAddress());
				map.put("invoicePhoneno", invoiceEntity.getInvoicePhoneno());
				map.put("invoiceBank", invoiceEntity.getInvoiceBank());
				map.put("invoiceAccountNo", invoiceEntity.getInvoiceAccountNo());
				map.put("invoiceDescribe", invoiceEntity.getInvoiceDescribe());
			}
		}catch(Exception e){
			logger.error("通过供应商编号查询对应开票信息异常：" + e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据供应商编号查询所在供应商的联系人
	 * @param supplierNo
	 * @return
	 */
	public Map<String,String> supplierUserInfo(String supplierNo){
		
		Map<String,String> map = new HashMap<String, String>();
		try {
			SupplierUserManageEntity entity = supplierUserManageMapper.querySupplierUserInfo(supplierNo);
			if(!StringFunctionUtil.isEmpty(entity)){
				map.put("name", entity.getUserName());// 联系人姓名
				map.put("telNo",entity.getTelNo());//联系人电话
				map.put("fax",entity.getFax()); //联系人传真
				map.put("phoneNo",entity.getPhoneNo()); //联系人手机
				map.put("email",entity.getEmail());//联系人邮箱
			}

		}catch(Exception e){
			logger.error("通过供应商编号查询对应开票信息异常：" + e.getMessage());
		}
		return map;
	}
	
	/**
	 * 查询供应商付款信息
	 * @param supplierNo
	 * @return
	 */
	public Map<String,String> supplierInfo(String supplierNo){
		
		Map<String,String> map = new HashMap<String, String>();
		try {
			SupplierManageEntity entity = supplierManageMapper.querySupplierInfo(supplierNo);
			if(!StringFunctionUtil.isEmpty(entity)){
				map.put("manageNo", supplierNo); //供应商编号
				map.put("address", entity.getAddress()); //供应商注册地址
				map.put("manageName", entity.getManageName()); //供应商名称
				map.put("accountNo", entity.getAccountNo());// 账号
				map.put("openingBank",entity.getOpeningBank());//开户行
				map.put("payTerm",entity.getPayTerm());//付款期限
				map.put("currenCy",entity.getCurrenCy());//付款币种
				
			}
		}catch(Exception e){
			logger.error("通过供应商编号查询对应开票信息异常：" + e.getMessage());
		}
		return map;
	}
	
	/**
	 * 查询订单相关信息
	 * @param orderNo
	 * @return
	 */
	public Map<String,String> orderData(String orderNo){
		
		Map<String,String> map = new HashMap<String, String>();
		try {
			OrderManageEntity entity = orderManageMapper.queryDataByNo(orderNo);
			if(!StringFunctionUtil.isEmpty(entity)){
				map.put("shippingInfo", entity.getShippingInfo()); //订单送货须知
				map.put("orderDay", entity.getOrderDay()); //订单日期
				map.put("address",entity.getAddress());//收货地址
				map.put("name",entity.getName());//收货人姓名
				map.put("phoneNo",entity.getPhoneNo());//收货人手机
				map.put("telNo",entity.getTelNo());//收货人座机
				map.put("email",entity.getEmail());//收货人邮箱
				map.put("approver",entity.getApprover());//授权人
				
//				arrivalDate = entity.getArrivalDate();
			}
		}catch(Exception e){
			logger.error("通过供应商编号查询对应开票信息异常：" + e.getMessage());
		}
		return map;
	}
}

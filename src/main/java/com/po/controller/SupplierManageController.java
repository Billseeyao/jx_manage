package main.java.com.po.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.SupplierManageMapper;
import main.java.com.po.entity.SupplierManageEntity;
import main.java.com.utils.PageUtils;
import main.java.com.utils.ReMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 客户与供应商管理
 * @author ylyao
 * @version 1.0
 */
@RestController
@RequestMapping(value="/supplier")
public class SupplierManageController {
	private Logger logger = LoggerFactory.getLogger(SupplierManageController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private SupplierManageMapper supplierManageMapper;
	
	/**
	 * 新建供应商
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ReMessage save(HttpServletRequest request){
		
		try {
			String manageNo = request.getParameter("manageNo"); //供应商编号
			String manageName = request.getParameter("manageName"); //供应商名称
			String address = request.getParameter("address"); //公司地址
			String companyTel = request.getParameter("companyTel"); //公司电话
			String openingBank = request.getParameter("openingBank"); //开户行
			String accountNo = request.getParameter("accountNo"); //付款账号
			String payTerm = request.getParameter("payTerm"); //付款期限
			String currenCy = request.getParameter("currenCy"); //付款货币
//			String createUser = session.getAttribute("currentUser").toString(); //创建人
			String createUser = null;
			
			SupplierManageEntity entity = new SupplierManageEntity(manageNo,manageName,address,companyTel,openingBank,accountNo,payTerm,currenCy,createUser);
			supplierManageMapper.insert(entity);
			
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("保存供应商异常：" + e.getMessage());
			return ReMessage.error(500, "保存供应商异常：" + e.getMessage());
		}
	}
	
	/**
	 * 查询供应商信息列表
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/queryList", method = RequestMethod.POST)
	public ReMessage queryList(Integer page, Integer limit){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if(page != null && limit != null){
				map.put("offset", (page - 1) * limit);
				map.put("limit", limit);
			}
			
			List<SupplierManageEntity> orderDatas = supplierManageMapper.queryObject(map);
			int total = supplierManageMapper.queryTotal();
			if(page != null && limit != null){
				PageUtils pageUtil = new PageUtils(orderDatas, total, limit, page);
				return ReMessage.ok().put("page", pageUtil);
			} else {
				return ReMessage.ok().put("data", orderDatas);
			}
			
		} catch (Exception e) {
			logger.error("查询供应商列表异常：" + e.getMessage());
			return ReMessage.error(500, "查询供应商列表异常：" + e.getMessage());
		}
	}
	
	/**
	 * 修改供应商
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ReMessage modify(HttpServletRequest request){
		
		try {
			String manageNo = request.getParameter("manageNo"); //供应商编号
			String manageName = request.getParameter("manageName"); //供应商名称
			String address = request.getParameter("address"); //公司地址
			String companyTel = request.getParameter("companyTel"); //公司电话
			String openingBank = request.getParameter("openingBank"); //开户行
			String accountNo = request.getParameter("accountNo"); //付款账号
			String payTerm = request.getParameter("payTerm"); //付款期限
			String currenCy = request.getParameter("currenCy"); //付款货币
//			String createUser = session.getAttribute("currentUser").toString(); //创建人
			
			SupplierManageEntity entity = new SupplierManageEntity();
			entity.setManageNo(manageNo);
			entity.setManageName(manageName);
			entity.setAddress(address);
			entity.setCompanyTel(companyTel);
			entity.setOpeningBank(openingBank);
			entity.setAccountNo(accountNo);
			entity.setPayTerm(payTerm);
			entity.setCurrenCy(currenCy);
			supplierManageMapper.update(entity);
			
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("保存供应商异常：" + e.getMessage());
			return ReMessage.error(500, "保存供应商异常：" + e.getMessage());
		}
	}
	
	/**
	 * 增加供应商开票资质
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addInvoice", method = RequestMethod.POST)
	public ReMessage addInvoice(HttpServletRequest request){
		
		try {
			String manageNo = request.getParameter("manageNo"); //供应商编号
			String invoiceNo = request.getParameter("invoiceNo"); //税号
			String invoiceName = request.getParameter("invoiceName"); //开票名称
			String ivoiceAddress = request.getParameter("ivoiceAddress"); //注册地址
			String invoicePhoneNo = request.getParameter("invoicePhoneNo"); //电话
			String invoiceBank = request.getParameter("invoiceBank"); //开户行
			String invoiceAccountNo = request.getParameter("invoiceAccountNo"); //开户行账号
			
			SupplierManageEntity entity = new SupplierManageEntity(manageNo,invoiceName,invoiceNo,ivoiceAddress,invoicePhoneNo,invoiceBank,invoiceAccountNo);
			supplierManageMapper.update(entity);
			
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("保存供应商开票信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存供应商开票信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 查看供应商开票资质
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryInvoice", method = RequestMethod.POST)
	public ReMessage queryInvoice(HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			String manageNo = request.getParameter("manageNo"); //供应商编号
			map.put("data", supplierManageMapper.querySupplierInfo(manageNo));
			
			return ReMessage.ok(map);
		} catch(Exception e){
			logger.error("查看供应商开票资质异常：" + e.getMessage());
			return ReMessage.error(500, "查看供应商开票资质异常：" + e.getMessage());
		}
	}
	
	/**
	 * 删除供应商信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ReMessage delete(HttpServletRequest request){
		
		try {
			String manageNo = request.getParameter("manageNo"); //供应商编号
			supplierManageMapper.delete(manageNo);
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("删除供应商信息异常：" + e.getMessage());
			return ReMessage.error(500, "删除供应商信息异常：" + e.getMessage());
		}
	}
}

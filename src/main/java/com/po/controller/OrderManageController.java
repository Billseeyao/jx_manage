package main.java.com.po.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.SearchEntity;
import main.java.com.po.service.OrderManageService;
import main.java.com.utils.PageUtils;
import main.java.com.utils.ReMessage;
import main.java.com.utils.StringFunctionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 订单管理
 * @author ylyao
 * @version 1.0
 */
@RestController
@RequestMapping(value="/orderManage")
public class OrderManageController {
	
	private Logger logger = LoggerFactory.getLogger(OrderManageController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private OrderManageService orderManageService;
	
	
	/**
	 * 新建订单（注意：一个订单可能有多个产品）
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ReMessage save(HttpServletRequest request){
		
		try {
			String orderNo = request.getParameter("orderNo"); //订单号
			String productNo = request.getParameter("productNo"); //产品编号
			String approver = request.getParameter("approver"); //批准人
			String orderDay = request.getParameter("orderDay"); //订单日期
			String supplierNo = request.getParameter("supplierNo"); //供应商编号
			String unitPrice = request.getParameter("unitPrice"); //单价(不含税)
			BigDecimal amount = new BigDecimal(request.getParameter("amount") == null ? null : request.getParameter("amount")); //金额
			BigDecimal taxRate = new BigDecimal(request.getParameter("taxRate") == null ? null :request.getParameter("taxRate")); //税率
			BigDecimal taxAmount = new BigDecimal(request.getParameter("taxAmount") == null ? null : request.getParameter("taxAmount")); //税额
			BigDecimal totalSum = new BigDecimal(request.getParameter("totalSum") == null ? null:request.getParameter("totalSum")); //价税总额
			String status = "1";
			String orderRemarks = request.getParameter("orderRemarks"); //订单备注
			String shippingInfo = request.getParameter("shippingInfo"); //送货须知
//			String createUser = session.getAttribute("currentUser").toString(); //创建人
			String createUser = null;
			
			OrderManageEntity entity = new OrderManageEntity(orderNo,productNo,approver,orderDay,supplierNo,
					unitPrice,amount,taxRate,taxAmount,totalSum,status,orderRemarks,shippingInfo,createUser);

			orderManageMapper.insert(entity);
			
			return ReMessage.ok("创建成功");
		} catch(Exception e){
			logger.error("新建订单信息异常：" + e.getMessage());
			return ReMessage.error(500, "新建订单信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 修改订单、关闭订单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ReMessage modify(HttpServletRequest request){
		try {
			String orderNo = request.getParameter("orderNo"); //订单号
			String productNo = request.getParameter("productNo"); //产品编号
			String approver = request.getParameter("approver"); //批准人
			String orderDay = request.getParameter("orderDay"); //订单日期
			String supplierNo = request.getParameter("supplierNo"); //供应商编号
			BigDecimal amount = new BigDecimal(request.getParameter("amount")); //金额
			BigDecimal taxRate = new BigDecimal(request.getParameter("taxRate")); //税率
			BigDecimal taxAmount = new BigDecimal(request.getParameter("taxAmount")); //税额
			BigDecimal totalSum = new BigDecimal(request.getParameter("totalSum")); //价税总额
			String unitPrice = request.getParameter("unitPrice"); //单价(不含税)
			String status = null; //订单状态1正常0未到货未逾期2数量不足未逾期3逾期订单
			String orderRemarks = request.getParameter("orderRemarks"); //订单备注
			String shippingInfo = request.getParameter("shippingInfo"); //送货须知
//			String createUser = session.getAttribute("currentUser").toString(); //创建人
			
			OrderManageEntity entity = new OrderManageEntity(orderNo,productNo,approver,orderDay,supplierNo,
					unitPrice,amount,taxRate,taxAmount,totalSum,status,orderRemarks,shippingInfo,null);

			orderManageMapper.update(entity);
			return ReMessage.ok("保存成功");
			
		} catch(Exception e){
			logger.error("保存订单信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存订单信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 关闭订单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/close", method = RequestMethod.POST)
	public ReMessage close(HttpServletRequest request){
		try {
			String orderNo = request.getParameter("orederNo"); //订单号
			String cancelReason = request.getParameter("reason"); //取消原因
			if(StringFunctionUtil.isEmpty(cancelReason)) return ReMessage.error(500, "关闭原因不能为空！");
			
			OrderManageEntity entity = new OrderManageEntity();
			entity.setOrederNo(orderNo);
			entity.setCancelReason(cancelReason); 
			entity.setStatus("0");
			entity.setUpdateTime(StringFunctionUtil.getNowTime());

			orderManageMapper.update(entity);
			return ReMessage.ok("关闭成功");
			
		} catch(Exception e){
			logger.error("关闭订单异常：" + e.getMessage());
			return ReMessage.error(500, "关闭订单异常：" + e.getMessage());
		}
	}
	
	/**
	 * 查询订单列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public ReMessage queryDatas(Integer page, Integer limit){

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
			
			List<OrderManageEntity> orderDatas = orderManageMapper.queryObject(map);
			int total = orderManageMapper.queryTotal();
			PageUtils pageUtil = new PageUtils(orderDatas, total, limit, page);
			
			return ReMessage.ok().put("page", pageUtil);
		} catch (Exception e) {
			logger.error("查询订单列表异常：" + e.getMessage());
			return ReMessage.error(500, "查询订单列表异常：" + e.getMessage());
		}
	}
	
	/**
	 * 查询订单列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchOrders", method = RequestMethod.POST)
	public ReMessage searchOrders(HttpServletRequest request){

		try {
			int page = Integer.parseInt(request.getParameter("page"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			String orderNo = request.getParameter("orderNo");
			int offset = (page - 1) * limit;
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
			
			SearchEntity entity = new SearchEntity(offset,limit,orderNo);
			List<OrderManageEntity> orderDatas = orderManageMapper.searchOrders(entity);
			int total = orderManageMapper.queryTotal();
			PageUtils pageUtil = new PageUtils(orderDatas, total, limit, page);
			
			return ReMessage.ok().put("page", pageUtil);
		} catch (Exception e) {
			logger.error("查询订单列表异常：" + e.getMessage());
			return ReMessage.error(500, "查询订单列表异常：" + e.getMessage());
		}
	}
	
	
	/**
	 * 预览生成的订单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/preview", method = RequestMethod.POST)
	public ReMessage preview(HttpServletRequest request){
		
		try {
			String orderNo = request.getParameter("orderNo");//订单号
			return ReMessage.ok().put("data", orderManageService.previewData(orderNo));
			
		} catch (Exception e) {
			logger.error("预览订单异常：" + e.getMessage());
			return ReMessage.error(500, "预览订单异常：" + e.getMessage());
		}
	}
}

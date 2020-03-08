package main.java.com.po.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.OrderManageMapper;
import main.java.com.po.dao.ProductManageMapper;
import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.SearchEntity;
import main.java.com.po.service.OrderManageService;
import main.java.com.utils.PageUtils;
import main.java.com.utils.ReMessage;
import main.java.com.utils.StringFunctionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


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
	
	@Autowired
	private ProductManageMapper productManageMapper;
	
	@Value("${jx.invoiceId}")
	private String invoiceId;
	
	
	/**
	 * 新建订单（注意：一个订单可能有多个产品）
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ReMessage save(HttpServletRequest request){
		
		Map<String, String> orderMap = new HashMap<String, String>();
		try {
			
			//获取订单信息
			String obj = request.getParameter("obj"); //供应商编号
			//获取订单中产品信息
			String productList = request.getParameter("list");
			
			//解析参数
			JSONObject jsonObject =JSONObject.parseObject(obj);
			Iterator iter = jsonObject.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				orderMap.put(entry.getKey().toString(), entry.getValue().toString());
			}
			
			String orderNo = orderMap.get("orederNo");//订单号
			String approver = orderMap.get("approver"); //审批人
			String orderDay = orderMap.get("orederDay");//订单日期
			String supplierNo = orderMap.get("supplierNo"); //供应编号
			String supplierName = orderMap.get("supplierName"); //供应商名称
			String supplierUser = orderMap.get("supplierUser"); //供应商联系人
			String orderRemarks = orderMap.get("orederRemarks"); //订单备注
			String status = "1";
			String createUser = null;
			String createTime = StringFunctionUtil.getNowTime();
			String name =  orderMap.get("name"); //收货人姓名
			String address =  orderMap.get("address"); //收货人地址
			String phoneNo =  orderMap.get("phoneNo"); //收获人手机
			String telNo =  orderMap.get("telNo"); //收货人座机
			String email =  orderMap.get("email"); //收货人邮箱
			
			String productNo = "",productName = "",unitPrice = "",number = "",holdNumber = "",arrivalDate="";
			BigDecimal taxRate = new BigDecimal("0.00");
			BigDecimal amount = new BigDecimal("0.00");
			BigDecimal taxAmount = new BigDecimal("0.00");
			BigDecimal totalSum = new BigDecimal("0.00");
			
			Map<String,String> productMap = new HashMap<String, String>();

			JSONArray array = JSONArray.parseArray(productList);
			for(int i = 0,length = array.size(); i <length; i++){
				JSONObject oject = (JSONObject) array.get(i);
				Iterator productIter = oject.entrySet().iterator();
				while (productIter.hasNext()) {
					Map.Entry entry = (Map.Entry) productIter.next();
					
					productMap.put(entry.getKey().toString(), entry.getValue().toString());

					productNo = productMap.get("productNo"); //产品编号
					productName = productMap.get("productName"); //产品名称
					unitPrice = productMap.get("unitPrice");//单价
					number = productMap.get("number"); //起订数量数量
//					taxRate = new BigDecimal(productMap.get("taxRate")); //税率
//					amount = new BigDecimal(productMap.get("amount")); //金额 = 单价 * 起订数量
//					taxAmount =new BigDecimal( productMap.get("taxAmount")); //税额 = 金额*税率
//					totalSum = new BigDecimal(productMap.get("totalSum")); //价税总额 = 金额+税额
					holdNumber = productMap.get("holdNumber");//到货数量
					arrivalDate = productMap.get("arrivalDate"); //到货日期
				}	

				OrderManageEntity entity = new OrderManageEntity(orderNo,productNo,productName,approver,orderDay,supplierNo,supplierName,supplierUser,
						unitPrice,taxRate,amount,number,holdNumber,taxAmount,totalSum,status,orderRemarks,null,address,name,phoneNo,telNo,email,
						createUser,createTime,invoiceId,arrivalDate);

				orderManageMapper.insert(entity);
				
			}
			
			return ReMessage.ok("创建成功");
		} catch(Exception e){
			logger.error("新建订单信息异常：" + e.getMessage());
			return ReMessage.error(500, "新建订单信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 修改订单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ReMessage modify(HttpServletRequest request){
		
		Map<String, String> orderMap = new HashMap<String, String>();
		try {

			//获取订单信息
			String obj = request.getParameter("obj"); //供应商编号
			//获取订单中产品信息
			String productList = request.getParameter("list");
			
			//解析参数
			JSONObject jsonObject =JSONObject.parseObject(obj);
			Iterator iter = jsonObject.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				orderMap.put(entry.getKey().toString(), entry.getValue().toString());
			}
			
			String orderNo = orderMap.get("orederNo");//订单号
			String approver = orderMap.get("approver"); //审批人
			String orderDay = orderMap.get("orederDay");//订单日期
			String supplierNo = orderMap.get("supplierNo"); //供应编号
			String supplierName = orderMap.get("supplierName"); //供应商名称
			String supplierUser = orderMap.get("supplierUser"); //供应商联系人
			String orderRemarks = orderMap.get("orederRemarks"); //订单备注
			String createUser = null;
			String createTime = StringFunctionUtil.getNowTime();
			String name =  orderMap.get("name"); //收货人姓名
			String address =  orderMap.get("address"); //收货人地址
			String phoneNo =  orderMap.get("phoneNo"); //收获人手机
			String telNo =  orderMap.get("telNo"); //收货人座机
			String email =  orderMap.get("email"); //收货人邮箱
			
			String productNo = "",productName = "",unitPrice = "",number = "",holdNumber = "",arrivalDate="";
			BigDecimal taxRate = new BigDecimal("0.00");
			BigDecimal amount = new BigDecimal("0.00");
			BigDecimal taxAmount = new BigDecimal("0.00");
			BigDecimal totalSum = new BigDecimal("0.00");
			
			Map<String,String> productMap = new HashMap<String, String>();

			JSONArray array = JSONArray.parseArray(productList);
			for(int i = 0,length = array.size(); i <length; i++){
				JSONObject oject = (JSONObject) array.get(i);
				Iterator productIter = oject.entrySet().iterator();
				while (productIter.hasNext()) {
					Map.Entry entry = (Map.Entry) productIter.next();
					
					productMap.put(entry.getKey().toString(), entry.getValue().toString());

					productNo = productMap.get("productNo"); //产品编号
					productName = productMap.get("productName"); //产品名称
					unitPrice = productMap.get("unitPrice");//单价
					number = productMap.get("number"); //起订数量数量
//					taxRate = new BigDecimal(productMap.get("taxRate")); //税率
//					amount = new BigDecimal(productMap.get("amount")); //金额 = 单价 * 起订数量
//					taxAmount =new BigDecimal( productMap.get("taxAmount")); //税额 = 金额*税率
//					totalSum = new BigDecimal(productMap.get("totalSum")); //价税总额 = 金额+税额
					holdNumber = productMap.get("holdNumber");//到货数量
					arrivalDate = productMap.get("arrivalDate"); //到货日期
				}
				//获取
				String status = getOrderStatus(productNo,orderNo,supplierNo,Integer.parseInt(holdNumber));
				
				OrderManageEntity entity = new OrderManageEntity(orderNo,productNo,productName,approver,orderDay,supplierNo,supplierName,supplierUser,
						unitPrice,taxRate,amount,number,holdNumber,taxAmount,totalSum,status,orderRemarks,null,address,name,phoneNo,telNo,email,
						createUser,createTime,invoiceId,arrivalDate);

				orderManageMapper.update(entity);
			}
			
			return ReMessage.ok("创建成功");
		
		} catch(Exception e){
			logger.error("保存订单信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存订单信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * @param productNo 产品编号
	 * @param orderNo 订单号
	 * @param supplierNo 供应商编号
	 * @return status订单状态
	 */
	public String getOrderStatus(String productNo, String orderNo,String supplierNo, int holdNumber) {
		String status = "";

		List<OrderManageEntity> orderDatas = orderManageMapper.proviewDataByNo(new OrderManageEntity(orderNo, productNo,supplierNo));
		for (OrderManageEntity entity : orderDatas) {
			int number = Integer.parseInt(entity.getNumber());
			int surplusNum = number - holdNumber;
			if (surplusNum == 0) {
				status = "1";
			} else {
				status = entity.getStatus();
			}
		}
		return status;
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
			
			List<OrderManageEntity> orderDatas = orderManageMapper.queryObjectNew(map);
			int total = orderManageMapper.queryTotalNew();
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

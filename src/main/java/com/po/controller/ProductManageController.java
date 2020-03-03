package main.java.com.po.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.ProductManageMapper;
import main.java.com.po.entity.ProductManageEntity;
import main.java.com.utils.PageUtils;
import main.java.com.utils.ReMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 产品管理
 * @author ylyao
 *
 */
@RestController
@RequestMapping(value="/product")
public class ProductManageController {

	private Logger logger = LoggerFactory.getLogger(ProductManageController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductManageMapper productManageMapper;
	
	@ResponseBody
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ReMessage saveData(HttpServletRequest request){

		try {
			String modelNo = request.getParameter("modelNo");  //产品型号
			String productNo = request.getParameter("productNo"); //产品编号
			String productName = request.getParameter("productName"); //产品名称
			String productDecribe = request.getParameter("productDecribe"); //产品描述
			String qualityStandard = request.getParameter("qualityStandard"); //产品标准
			String unitPrice = request.getParameter("unitPrice"); //单价
			String taxRate = request.getParameter("taxRate"); //税率
			String remarks = request.getParameter("remarks"); //产品备注
			String arrivalDate = request.getParameter("arrivalDate"); //到货日期
//			String createUser = request.getParameter(session.getAttribute("currentUser").toString());
			
			ProductManageEntity entity = new ProductManageEntity(modelNo,
					productNo, productName, productDecribe, qualityStandard,
					unitPrice, taxRate, remarks, null,arrivalDate);
			
			productManageMapper.insert(entity);
			
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("保存产品信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存异常：" + e.getMessage());
		}
	}
	
	
	/**
	 * 修改产品信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ReMessage modify(HttpServletRequest request){
		try {
			String modelNo = request.getParameter("modelNo");  //产品型号
			String productNo = request.getParameter("productNo"); //产品编号
			String productName = request.getParameter("productName"); //产品名称
			String productDecribe = request.getParameter("productDecribe"); //产品描述
			String qualityStandard = request.getParameter("qualityStandard"); //产品标准
			String unitPrice = request.getParameter("unitPrice"); //单价
			String taxRate = request.getParameter("taxRate"); //税率
			String remarks = request.getParameter("remarks"); //产品备注
			String arrivalDate = request.getParameter("arrivalDate"); //到货日期
			
			ProductManageEntity entity = new ProductManageEntity(modelNo,
					productNo, productName, productDecribe, qualityStandard,
					unitPrice, taxRate, remarks ,arrivalDate);
			
			productManageMapper.update(entity);
			
			return ReMessage.ok("保存成功");
		} catch(Exception e){
			logger.error("保存产品信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存异常：" + e.getMessage());
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public ReMessage query(HttpServletRequest request){
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("data", productManageMapper.queryProductDatas(null));
			return ReMessage.ok(map);
		} catch(Exception e){
			logger.error("查询产品信息异常：" + e.getMessage());
			return ReMessage.error(500, "查询产品信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 根据产品编号删除产品
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ReMessage delete(HttpServletRequest request){
		try {
			String productNo = request.getParameter("productNo");  //产品编号
			productManageMapper.delete(productNo);
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("删除产品信息异常：" + e.getMessage());
			return ReMessage.error(500, "删除产品信息异常：" + e.getMessage());
		}
	}
	
	/**
	 * 查询产品列表 
	 * @param page 当前页数
	 * @param limit 一页展示数目
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryList", method = RequestMethod.POST)
	public ReMessage queryList(Integer page, Integer limit){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
			
			List<ProductManageEntity> orderDatas = productManageMapper.queryProductDatas(map);
			int total = productManageMapper.queryTotal();
			PageUtils pageUtil = new PageUtils(orderDatas, total, limit, page);
			
			return ReMessage.ok().put("page", pageUtil);
		} catch (Exception e) {
			logger.error("查询产品列表异常：" + e.getMessage());
			return ReMessage.error(500, "查询产品列表异常：" + e.getMessage());
		}
	}
	
	
}

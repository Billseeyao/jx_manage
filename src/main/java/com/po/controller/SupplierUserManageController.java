package main.java.com.po.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.SupplierUserManageMapper;
import main.java.com.po.entity.SupplierUserManageEntity;
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
 * 供应商联系人管理
 * @author ylyao
 *
 */
@RestController
@RequestMapping(value="/supplierUser")
public class SupplierUserManageController {

	private Logger logger = LoggerFactory.getLogger(SupplierUserManageController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private SupplierUserManageMapper supplierUserManageMapper;
	
	
	/**
	 * 添加联系人
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ReMessage saveData(HttpServletRequest request){
		try {
			String manageNo = request.getParameter("manageNo"); // 供应商编号
			String userName = request.getParameter("userName"); // 姓名
			String telNo = request.getParameter("telNo"); // 号码
			String phoneNo = request.getParameter("phoneNo"); // 手机号码
			String email = request.getParameter("email"); // 邮箱
			String fax = request.getParameter("fax"); // 传真
			String address = request.getParameter("address"); // 地址
			String postCode = request.getParameter("postCode"); // 邮编
			
			SupplierUserManageEntity entity = new SupplierUserManageEntity(manageNo,userName,telNo,phoneNo,email,fax,address,postCode);
			supplierUserManageMapper.insert(entity);
			
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("添加联系人信息异常：" + e.getMessage());
			return ReMessage.error(500, "添加联系人信息异常：" + e.getMessage());
		}
	}
	
	
	/**
	 * 查询联系人列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public ReMessage query(int page, int limit){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
			
			List<SupplierUserManageEntity> orderDatas = supplierUserManageMapper.queryObject(map);
			int total = supplierUserManageMapper.queryTotal();
			PageUtils pageUtil = new PageUtils(orderDatas, total, limit, page);
			
			return ReMessage.ok().put("page", pageUtil);
		} catch (Exception e) {
			logger.error("查询联系人列表异常：" + e.getMessage());
			return ReMessage.error(500, "查询联系人列表异常：" + e.getMessage());
		}
	}
	
	/**
	 * 查询供应商联系人信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryUser", method = RequestMethod.POST)
	public ReMessage queryUser(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			String id = request.getParameter("id"); // 编号
			map.put("data", supplierUserManageMapper.querySupplierUserInfo(id));
			return ReMessage.ok(map);
		} catch(Exception e){
			logger.error("保存产品信息异常：" + e.getMessage());
			return ReMessage.error(500, "保存异常：" + e.getMessage());
		}
	}
	
	/**
	 * 修改供应商联系人信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/modifyUser", method = RequestMethod.POST)
	public ReMessage modifyUser(HttpServletRequest request){
		try {
			String id = request.getParameter("id"); // 编号
			String manageNo = request.getParameter("manageNo"); // 供应商编号
			String userName = request.getParameter("userName"); // 姓名
			String telNo = request.getParameter("telNo"); // 号码
			String phoneNo = request.getParameter("phoneNo"); // 手机号码
			String email = request.getParameter("email"); // 邮箱
			String fax = request.getParameter("fax"); // 传真
			String address = request.getParameter("address"); // 地址
			String postCode = request.getParameter("postCode"); // 邮编
			
			SupplierUserManageEntity entity = new SupplierUserManageEntity(id,manageNo,userName,telNo,phoneNo,email,fax,address,postCode);
			supplierUserManageMapper.update(entity);
			
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("保存联系人异常：" + e.getMessage());
			return ReMessage.error(500, "保存联系人异常：" + e.getMessage());
		}
	}
	
	
	
	/**
	 * 删除供应商联系人信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ReMessage delete(HttpServletRequest request){
		try {
			String id = request.getParameter("id"); // 编号
			supplierUserManageMapper.delete(id);
			
			return ReMessage.ok();
		} catch(Exception e){
			logger.error("删除联系人异常：" + e.getMessage());
			return ReMessage.error(500, "删除联系人异常：" + e.getMessage());
		}
	}
	
}

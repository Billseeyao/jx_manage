package main.java.com.po.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.com.po.dao.OrderApplyMapper;
import main.java.com.po.entity.OrderApplyEntity;
import main.java.com.utils.ReMessage;
import main.java.com.utils.StringFunctionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/orderApply")
public class OrderApplyController {
	private static Logger logger = LoggerFactory.getLogger(OrderApplyController.class);

	@Autowired
	private OrderApplyMapper orderApplyMapper;
	
	@Autowired
	private HttpSession session;
	/**
	 * 创建申请
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveData", method = RequestMethod.POST)
	public ReMessage saveOrderApply(HttpServletRequest request){
		
		String orderNo = request.getParameter("orderNo"); //订单号
		
		try {
			OrderApplyEntity entity = new OrderApplyEntity();
			entity.setApplyNo(StringFunctionUtil.getApplyNo());
			entity.setOrederNo(orderNo);
			entity.setApplyUser(session.getAttribute("currentUser").toString());
			entity.setApplyRemarks(request.getParameter("applyRemarks"));
			orderApplyMapper.insert(entity);
			
			return ReMessage.ok("创建成功");
		} catch(Exception e){
			logger.error("创建申请信息异常：" + e.getMessage());
			return ReMessage.error(500, "创建申请异常：" + e.getMessage());
		}
	}
	
	/**
	 * 提交审核信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveApprove", method = RequestMethod.POST)
	public ReMessage saveApprove(HttpServletRequest request){
		String applyNo = request.getParameter("applyNo"); //申请号（需要审核申请的申请号）
		
		try {
			OrderApplyEntity entity = new OrderApplyEntity();
			entity.setApproveUser(session.getAttribute("currentUser").toString());//复核人
			entity.setApproveRemarks(request.getParameter("approveRemarks"));
			entity.setApplyNo(applyNo);
			orderApplyMapper.update(entity);
			
			return ReMessage.ok("创建成功");
		} catch(Exception e){
			logger.error("创建申请信息异常：" + e.getMessage());
			return ReMessage.error(500, "创建申请异常：" + e.getMessage());
		}
	}
}

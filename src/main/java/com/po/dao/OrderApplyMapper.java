package main.java.com.po.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import main.java.com.po.entity.OrderApplyEntity;

/**
 * 发票管理
 * @author ylyao
 * @version 1.0
 */
@Mapper
public interface OrderApplyMapper {
	
	List<OrderApplyEntity> queryObject();
	
	/**
	 * 通过订单号查询申请详情
	 * @param orederNo
	 * @return
	 */
	OrderApplyEntity queryOrderApplyInfo(String orederNo);
	
	/**
	 * 新建申请信息
	 * @param entity
	 */
	void insert(OrderApplyEntity entity);
	
	/**
	 * 修改保存审批信息
	 * @param entity
	 */
	void update(OrderApplyEntity entity);
	
	/**
	 * 删除
	 * @param invoiceId
	 */
	void delete(String id);	
}

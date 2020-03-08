package main.java.com.po.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import main.java.com.po.entity.OrderManageEntity;
import main.java.com.po.entity.SearchEntity;

/**
 * 发票管理
 * @author ylyao
 * @version 1.0
 */
@Mapper
public interface OrderManageMapper {
	
	List<OrderManageEntity> queryObject(Map<String, Object> map);
	
	List<OrderManageEntity> queryObjectNew(Map<String, Object> map);
	
	/**
	 * 通过订单号查询订单详情
	 * @param orederNo
	 * @return
	 */
	OrderManageEntity queryDataByNo(String orederNo);
	
	/**
	 * 保存订单
	 * @param entity
	 */
	void insert(OrderManageEntity entity);
	
	/**
	 * 修改订单信息
	 * @param entity
	 */
	void update(OrderManageEntity entity);
	
	void updateStatus(OrderManageEntity entity);
	
	/**
	 * 删除订单
	 * @param invoiceId
	 */
	void delete(String id);	
	
	int queryTotal();
	
	int queryTotalNew();
	
	/**
	 * 查询状态正常的产品号、订单号 
	 * @return
	 */
	List<OrderManageEntity> queryNomal();
	
	/**
	 * 查询异常订单 
	 * @return
	 */
	List<OrderManageEntity> queryAbnomal(OrderManageEntity entity);
	
	/**
	 * 根据条件查询订单
	 * @param entity
	 * @return
	 */
	List<OrderManageEntity> searchOrders(SearchEntity entity);
	
	/**
	 * 预览查询订单信息
	 * @param entity
	 * @return
	 */
	OrderManageEntity proviewDataByNo(OrderManageEntity entity);
}

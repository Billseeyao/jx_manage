package main.java.com.po.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import main.java.com.po.entity.InvoiceManageEntity;

/**
 * 发票管理
 * @author ylyao
 * @version 1.0
 */
@Mapper
public interface InvoiceManageMapper {
	
	List<InvoiceManageEntity> queryObject();
	
	/**
	 * 通过开票编号（公司编号）查询开票信息
	 * @param invoiceId
	 * @return
	 */
	InvoiceManageEntity queryInvoiceInfo(String invoiceId);
	
	/**
	 * 保存发票信息
	 * @param entity
	 */
	void insert(InvoiceManageEntity entity);
	
	/**
	 * 修改保存开票信息
	 * @param entity
	 */
	void update(InvoiceManageEntity entity);
	
	/**
	 * 删除
	 * @param invoiceId
	 */
	void delete(String invoiceId);	
}

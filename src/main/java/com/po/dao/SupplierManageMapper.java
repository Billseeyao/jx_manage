package main.java.com.po.dao;

import java.util.List;
import java.util.Map;

import main.java.com.po.entity.SupplierManageEntity;

import org.apache.ibatis.annotations.Mapper;


/**
 * 供应商信息管理Mapper
 * @author ylyao
 * @version 1.0
 */
@Mapper
public interface SupplierManageMapper {
	
	/**
	 * 查询供应商信息列表
	 * @param map
	 * @return
	 */
	List<SupplierManageEntity> queryObject(Map<String, Object> map);
	
	
	int queryTotal();

	/**
	 * 通过供应商编号查询供应商信息 
	 * @param manageNo
	 * @return
	 */
	SupplierManageEntity querySupplierInfo(String manageNo);
	
	/**
	 * 保存供应商信息
	 * @param entity
	 */
	void insert(SupplierManageEntity entity);
	
	/**
	 * 更新供应商信息
	 * @param entity
	 */
	void update(SupplierManageEntity entity);
	
	/**
	 * 删除供应商信息
	 * @param manageNo
	 */
	void delete(String manageNo);
	
}

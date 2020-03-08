package main.java.com.po.dao;

import java.util.List;
import java.util.Map;

import main.java.com.po.entity.SupplierUserManageEntity;

import org.apache.ibatis.annotations.Mapper;


/**
 * 供应商信息管理Mapper
 * @author ylyao
 * @version 1.0
 */
@Mapper
public interface SupplierUserManageMapper {
	
	
	List<SupplierUserManageEntity> queryObject(Map<String, Object> map);
	
	
	int queryTotal();

	/**
	 * 通过供应商编号查询供应商信息 
	 * @param manageNo
	 * @return
	 */
	SupplierUserManageEntity querySupplierUserInfo(String id);
	
	List<SupplierUserManageEntity> querySupplierUserInfoByNo(String manageNo);
	
	/**
	 * 保存供应商信息
	 * @param entity
	 */
	void insert(SupplierUserManageEntity entity);
	
	/**
	 * 更新供应商信息
	 * @param entity
	 */
	void update(SupplierUserManageEntity entity);
	
	
	void delete(String id);
	
	/**
	 * 预览查看供应商联系人信息
	 * @param entity
	 * @return
	 */
	SupplierUserManageEntity previewSupplierUserInfo(SupplierUserManageEntity entity);
	
}

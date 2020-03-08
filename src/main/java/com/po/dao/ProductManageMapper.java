package main.java.com.po.dao;

import java.util.List;
import java.util.Map;

import main.java.com.po.entity.ProductManageEntity;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductManageMapper {
	
	List<ProductManageEntity> queryProductDatas(Map<String, Object> map);
	
	/**
	 * 根据产品型号获取产品信息
	 * @param no
	 * @return
	 */
	ProductManageEntity queryProductInfo(String no);
	
	int queryTotal();
	
	/**
	 * 保存产品信息
	 * @param entity
	 */
	void insert(ProductManageEntity entity);

	/**
	 * 修改产品信息
	 * @param entity
	 */
	void update(ProductManageEntity entity);
	
	
	void delete(String id);
	
}

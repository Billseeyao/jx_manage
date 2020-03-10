package main.java.com.po.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class EmailAppendixExcelEntity {
	
	@Excel(name = "订单号", orderNum = "0")
	private String orderNo;
	
	@Excel(name = "产品名称", orderNum = "1")
	private String productName;
	
	@Excel(name = "描述", orderNum = "2")
	private String productDecribe;

	@Excel(name = "订单数量", orderNum = "3")
	private String number;
	
	@Excel(name = "未到货数量", orderNum = "4")
	private String surplusNum;
	
	@Excel(name = "到货日期", orderNum = "5")
	private String arrivalDate;
	
	@Excel(name = "订单状态", orderNum = "6")
	private String orderStatus;
	
	@Excel(name = "备注", orderNum = "7")
	private String remark;

	
	public EmailAppendixExcelEntity(String orderNo, String productName,
			String productDecribe, String number, String surplusNum,
			String arrivalDate, String orderStatus, String remark) {
		super();
		this.orderNo = orderNo;
		this.productName = productName;
		this.productDecribe = productDecribe;
		this.number = number;
		this.surplusNum = surplusNum;
		this.arrivalDate = arrivalDate;
		this.orderStatus = orderStatus;
		this.remark = remark;
	}


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDecribe() {
		return productDecribe;
	}

	public void setProductDecribe(String productDecribe) {
		this.productDecribe = productDecribe;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSurplusNum() {
		return surplusNum;
	}

	public void setSurplusNum(String surplusNum) {
		this.surplusNum = surplusNum;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

package main.java.com.po.entity;

import java.io.Serializable;

public class ExcelData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String orderNo = "";
	private String productName = "";
	private String productDescribe = "";
	private String number = "";
	private String surplusNum = "";
	private String arrivalDate = "";
	private String orderStatus = "";
	private String email = "";
	private String remark = "";
	
	
	public ExcelData(String orderNo, String productName,
			String productDescribe, String number, String surplusNum,
			String arrivalDate, String orderStatus, String remark, String email) {
		super();
		this.orderNo = orderNo;
		this.productName = productName;
		this.productDescribe = productDescribe;
		this.number = number;
		this.surplusNum = surplusNum;
		this.arrivalDate = arrivalDate;
		this.orderStatus = orderStatus;
		this.remark = remark;
		this.email = email;
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
	public String getProductDescribe() {
		return productDescribe;
	}
	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

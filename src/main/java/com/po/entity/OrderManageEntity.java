package main.java.com.po.entity;

import java.math.BigDecimal;

public class OrderManageEntity {
	
	private String id;
	private String orederNo;
	private String productNo;
	private String approver;
	private String orderDay;
	private String supplierNo;
	private String invoiceId;
	private String unitPrice;
	private BigDecimal amount;
	private BigDecimal taxRate;
	private BigDecimal taxAmount;
	private BigDecimal totalSum;
	private String status;
	private String orderRemarks;
	private String shippingInfo;
	private String createUser;
	private String createTime;
	private String updateTime;
	private String cancelReason;
	private String address;
	private String name;
	private String phoneNo;
	private String telNo;
	private String email;
	private String arrivalDate;
	
	public OrderManageEntity(){
		super();
	}
	
	public OrderManageEntity(String orederNo, String productNo,
			String approver, String orderDay, String supplierNo,
			String unitPrice, BigDecimal amount, BigDecimal taxRate, BigDecimal taxAmount,
			BigDecimal totalSum, String status, String orderRemarks,
			String shippingInfo, String createUser) {
		super();
		this.orederNo = orederNo;
		this.productNo = productNo;
		this.approver = approver;
		this.orderDay = orderDay;
		this.supplierNo = supplierNo;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
		this.totalSum = totalSum;
		this.status = status;
		this.orderRemarks = orderRemarks;
		this.shippingInfo = shippingInfo;
		this.createUser = createUser;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrederNo() {
		return orederNo;
	}
	public void setOrederNo(String orederNo) {
		this.orederNo = orederNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}
	public String getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderRemarks() {
		return orderRemarks;
	}
	public void setOrderRemarks(String orderRemarks) {
		this.orderRemarks = orderRemarks;
	}
	public String getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(String shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "OrderManageEntity [id=" + id + ", orederNo=" + orederNo
				+ ", productNo=" + productNo + ", approver=" + approver
				+ ", orderDay=" + orderDay + ", supplierNo=" + supplierNo
				+ ", unitPrice=" + unitPrice + ", amount=" + amount
				+ ", taxRate=" + taxRate + ", taxAmount=" + taxAmount
				+ ", totalSum=" + totalSum + ", status=" + status
				+ ", orderRemarks=" + orderRemarks + ", shippingInfo="
				+ shippingInfo + ", createUser=" + createUser + ", createTime="
				+ createTime + "]";
	}

}

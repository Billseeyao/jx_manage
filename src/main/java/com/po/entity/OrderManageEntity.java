package main.java.com.po.entity;

import java.math.BigDecimal;

public class OrderManageEntity {
	
	private String id;
	private String orederNo;
	private String productNo;
	private String productName;
	private String approver;
	private String orderDay;
	private String supplierNo;
	private String supplierName;
	private String supplierUser;
	private String unitPrice;
	private BigDecimal taxRate;
	private BigDecimal amount;
	private String number;
	private String holdNumber;
	private BigDecimal taxAmount;
	private BigDecimal totalSum;
	private String status;
	private String orderRemarks;
	private String shippingInfo;
	private String address;
	private String name;
	private String phoneNo;
	private String telNo;
	private String email;
	private String createUser;
	private String createTime;
	private String cancelReason;
	private String invoiceId;
	private String updateTime;
	private String arrivalDate;
	
	public OrderManageEntity(String orederNo, String productNo,String supplierNo){
		super();
		this.orederNo = orederNo;
		this.productNo = productNo;
		this.supplierNo = supplierNo;
	}
	
	public OrderManageEntity(String orederNo){
		super();
		this.orederNo = orederNo;
	}
	
	public OrderManageEntity(){
		super();
	}
	
	public OrderManageEntity(String orederNo, String productNo,
			String productName, String approver, String orderDay,
			String supplierNo, String supplierName, String supplierUser,
			String unitPrice, BigDecimal taxRate, BigDecimal amount,
			String number, String holdNumber, BigDecimal taxAmount,
			BigDecimal totalSum, String status, String orderRemarks,
			String shippingInfo, String address, String name, String phoneNo,
			String telNo, String email, String createUser, String createTime,
			String invoiceId, String arrivalDate) {
		super();
		this.orederNo = orederNo;
		this.productNo = productNo;
		this.productName = productName;
		this.approver = approver;
		this.orderDay = orderDay;
		this.supplierNo = supplierNo;
		this.supplierName = supplierName;
		this.supplierUser = supplierUser;
		this.unitPrice = unitPrice;
		this.taxRate = taxRate;
		this.amount = amount;
		this.number = number;
		this.holdNumber = holdNumber;
		this.taxAmount = taxAmount;
		this.totalSum = totalSum;
		this.status = status;
		this.orderRemarks = orderRemarks;
		this.shippingInfo = shippingInfo;
		this.address = address;
		this.name = name;
		this.phoneNo = phoneNo;
		this.telNo = telNo;
		this.email = email;
		this.createUser = createUser;
		this.createTime = createTime;
		this.invoiceId = invoiceId;
		this.arrivalDate = arrivalDate;
	}



	public OrderManageEntity(String orederNo, String productNo,
			String approver, String orderDay, String supplierNo,String supplierName, String status,
			String orderRemarks, String shippingInfo, String createUser) {
		super();
		this.orederNo = orederNo;
		this.productNo = productNo;
		this.approver = approver;
		this.orderDay = orderDay;
		this.supplierNo = supplierNo;
		this.supplierName = supplierName;
		this.status = status;
		this.orderRemarks = orderRemarks;
		this.shippingInfo = shippingInfo;
		this.createUser = createUser;
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
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSupplierUser() {
		return supplierUser;
	}

	public void setSupplierUser(String supplierUser) {
		this.supplierUser = supplierUser;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getHoldNumber() {
		return holdNumber;
	}

	public void setHoldNumber(String holdNumber) {
		this.holdNumber = holdNumber;
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

	public String getSupplierName() {
		return supplierName;
	}



	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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

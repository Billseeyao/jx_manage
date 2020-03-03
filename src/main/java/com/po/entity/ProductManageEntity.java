package main.java.com.po.entity;

public class ProductManageEntity {
	
	private String id;
	private String modelNo;
	private String productNo; //多个产品好存一个字段，中间用英文逗号隔开
	private String productName;
	private String productDecribe;
	private String qualityStandard;
	private String number;
	private String holdNumber;
	private String unitPrice;
	private String taxRate;
	private String taxAmount;//税额
	private String remarks;
	private String createUser;
	private String createTime;
	private String arrivalDate;
	private String updateTime;
	
	public ProductManageEntity(){
		super();
	}
	
	public ProductManageEntity(String modelNo, String productNo,
			String productName, String productDecribe, String qualityStandard,
			String unitPrice, String taxRate, String remarks,String arrivalDate) {
		super();
		this.modelNo = modelNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productDecribe = productDecribe;
		this.qualityStandard = qualityStandard;
		this.unitPrice = unitPrice;
		this.taxRate = taxRate;
		this.remarks = remarks;
		this.arrivalDate = arrivalDate;
	}
	
	public ProductManageEntity(String modelNo, String productNo,
			String productName, String productDecribe, String qualityStandard,
			String unitPrice, String taxRate, String remarks,
			String createUser,String arrivalDate) {
		super();
		this.modelNo = modelNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productDecribe = productDecribe;
		this.qualityStandard = qualityStandard;
		this.unitPrice = unitPrice;
		this.taxRate = taxRate;
		this.remarks = remarks;
		this.createUser = createUser;
		this.arrivalDate = arrivalDate;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
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
	public String getProductDecribe() {
		return productDecribe;
	}
	public void setProductDecribe(String productDecribe) {
		this.productDecribe = productDecribe;
	}
	public String getQualityStandard() {
		return qualityStandard;
	}
	public void setQualityStandard(String qualityStandard) {
		this.qualityStandard = qualityStandard;
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
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	
	public String getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "ProductManageEntity [id=" + id + ", modelNo=" + modelNo
				+ ", productName=" + productName + ", productDecribe="
				+ productDecribe + ", qualityStandard=" + qualityStandard
				+ ", number=" + number + ", holdNumber=" + holdNumber
				+ ", unitPrice=" + unitPrice + ", taxRate=" + taxRate
				+ ", remarks=" + remarks + ", createUser=" + createUser
				+ ", createTime=" + createTime + "]";
	}
	
	
	
	
}

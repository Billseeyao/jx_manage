package main.java.com.po.entity;

public class SupplierManageEntity {

	private String id;
	private String manageNo;
	private String manageName;
	private String address;
	private String companyTel;
	private String openingBank;
	private String accountNo;
	private String payTerm;
	private String currenCy;
	private String invoiceName;
	private String invoiceNo;
	private String ivoiceAddress;
	private String invoicePhoneNo;
	private String invoiceBank;
	private String invoiceAccountNo;
	private String createUser;
	private String createTime;
	
	public SupplierManageEntity() {
		super();
	}
	
	public SupplierManageEntity(String manageNo, String invoiceName,
			String invoiceNo, String ivoiceAddress, String invoicePhoneNo,
			String invoiceBank, String invoiceAccountNo) {
		super();
		this.manageNo = manageNo;
		this.invoiceName = invoiceName;
		this.invoiceNo = invoiceNo;
		this.ivoiceAddress = ivoiceAddress;
		this.invoicePhoneNo = invoicePhoneNo;
		this.invoiceBank = invoiceBank;
		this.invoiceAccountNo = invoiceAccountNo;
	}

	public SupplierManageEntity(String manageNo, String manageName,
			String address, String companyTel, String openingBank,
			String accountNo, String payTerm, String currenCy, String createUser) {
		super();
		this.manageNo = manageNo;
		this.manageName = manageName;
		this.address = address;
		this.companyTel = companyTel;
		this.openingBank = openingBank;
		this.accountNo = accountNo;
		this.payTerm = payTerm;
		this.currenCy = currenCy;
		this.createUser = createUser;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManageNo() {
		return manageNo;
	}
	public void setManageNo(String manageNo) {
		this.manageNo = manageNo;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getOpeningBank() {
		return openingBank;
	}
	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPayTerm() {
		return payTerm;
	}
	public void setPayTerm(String payTerm) {
		this.payTerm = payTerm;
	}
	public String getCurrenCy() {
		return currenCy;
	}
	public void setCurrenCy(String currenCy) {
		this.currenCy = currenCy;
	}
	public String getInvoiceName() {
		return invoiceName;
	}
	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getIvoiceAddress() {
		return ivoiceAddress;
	}
	public void setIvoiceAddress(String ivoiceAddress) {
		this.ivoiceAddress = ivoiceAddress;
	}
	public String getInvoicePhoneNo() {
		return invoicePhoneNo;
	}
	public void setInvoicePhoneNo(String invoicePhoneNo) {
		this.invoicePhoneNo = invoicePhoneNo;
	}
	public String getInvoiceBank() {
		return invoiceBank;
	}
	public void setInvoiceBank(String invoiceBank) {
		this.invoiceBank = invoiceBank;
	}
	public String getInvoiceAccountNo() {
		return invoiceAccountNo;
	}
	public void setInvoiceAccountNo(String invoiceAccountNo) {
		this.invoiceAccountNo = invoiceAccountNo;
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
	
	@Override
	public String toString() {
		return "SupplierManageEntity [id=" + id + ", manageNo=" + manageNo
				+ ", address=" + address + ", companyTel=" + companyTel
				+ ", openingBank=" + openingBank + ", accountNo=" + accountNo
				+ ", payTerm=" + payTerm + ", currenCy=" + currenCy
				+ ", invoiceName=" + invoiceName + ", invoiceNo=" + invoiceNo
				+ ", ivoiceAddress=" + ivoiceAddress + ", invoicePhoneNo="
				+ invoicePhoneNo + ", invoiceBank=" + invoiceBank
				+ ", invoiceAccountNo=" + invoiceAccountNo + ", createUser="
				+ createUser + ", createTime=" + createTime + "]";
	}
	
	
}

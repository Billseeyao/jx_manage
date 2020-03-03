package main.java.com.po.entity;

/**
 * 发票管理
 * @author ylyao
 * @version 1.0 
 */
public class InvoiceManageEntity {
	private String invoiceId;
	private String invoiceName;
	private String invoiceNo;
	private String ivoiceAddress;
	private String invoicePhoneno;
	private String invoiceBank;
	private String invoiceAccountNo;
	private String invoiceDescribe;
	private String createUser;
	private String createTime;
	
	
	@Override
	public String toString() {
		return "InvoiceManageEntity [invoiceId=" + invoiceId + ", invoiceName="
				+ invoiceName + ", invoiceNo=" + invoiceNo + ", ivoiceAddress="
				+ ivoiceAddress + ", invoicePhoneno=" + invoicePhoneno
				+ ", invoiceBank=" + invoiceBank + ", invoiceAccountNo="
				+ invoiceAccountNo + ", invoiceDescribe=" + invoiceDescribe
				+ ", createUser=" + createUser + ", createTime=" + createTime
				+ "]";
	}
	
	public InvoiceManageEntity(){
		super();
	}
	
	public InvoiceManageEntity(String invoiceId, String invoiceName,
			String invoiceNo, String ivoiceAddress, String invoicePhoneno,
			String invoiceBank, String invoiceAccountNo,
			String invoiceDescribe, String createUser) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceName = invoiceName;
		this.invoiceNo = invoiceNo;
		this.ivoiceAddress = ivoiceAddress;
		this.invoicePhoneno = invoicePhoneno;
		this.invoiceBank = invoiceBank;
		this.invoiceAccountNo = invoiceAccountNo;
		this.invoiceDescribe = invoiceDescribe;
		this.createUser = createUser;
	}


	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
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
	public String getInvoicePhoneno() {
		return invoicePhoneno;
	}
	public void setInvoicePhoneno(String invoicePhoneno) {
		this.invoicePhoneno = invoicePhoneno;
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
	public String getInvoiceDescribe() {
		return invoiceDescribe;
	}
	public void setInvoiceDescribe(String invoiceDescribe) {
		this.invoiceDescribe = invoiceDescribe;
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
}

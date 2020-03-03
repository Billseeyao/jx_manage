package main.java.com.po.entity;


public class SupplierUserManageEntity {

	private String id;
	private String manageNo;
	private String userName;
	private String telNo;
	private String phoneNo;
	private String email;
	private String fax;
	private String address;
	private String postCode;
	private String createUser;
	private String createTime;
	
	public SupplierUserManageEntity() {
		super();
	}
	
	
	public SupplierUserManageEntity(String id, String manageNo,
			String userName, String telNo, String phoneNo, String email,
			String fax, String address, String postCode, String createUser,
			String createTime) {
		super();
		this.id = id;
		this.manageNo = manageNo;
		this.userName = userName;
		this.telNo = telNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.fax = fax;
		this.address = address;
		this.postCode = postCode;
		this.createUser = createUser;
		this.createTime = createTime;
	}


	public SupplierUserManageEntity(String id, String manageNo,
			String userName, String telNo, String phoneNo, String email,
			String fax, String address, String postCode) {
		super();
		this.id = id;
		this.manageNo = manageNo;
		this.userName = userName;
		this.telNo = telNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.fax = fax;
		this.address = address;
		this.postCode = postCode;
	}

	public SupplierUserManageEntity(String manageNo, String userName,
			String telNo, String phoneNo, String email, String fax,
			String address, String postCode) {
		super();
		this.manageNo = manageNo;
		this.userName = userName;
		this.telNo = telNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.fax = fax;
		this.address = address;
		this.postCode = postCode;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
		return "SupplierUserManageEntity [manageNo=" + manageNo + ", userName="
				+ userName + ", telNo=" + telNo + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", fax=" + fax + ", address=" + address
				+ ", postCode=" + postCode + ", createUser=" + createUser
				+ ", createTime=" + createTime + "]";
	}
	
}

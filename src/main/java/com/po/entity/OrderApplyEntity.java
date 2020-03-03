package main.java.com.po.entity;

public class OrderApplyEntity {
	
	private String id;
	private String orederNo;
	private String applyNo;
	private String applyUser;
	private String applyTime;
	private String applyRemarks;
	private String approveUser;
	private String approveTime;
	private String approveRemarks;
	private String createUser;
	private String createTime;
	
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
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getApplyRemarks() {
		return applyRemarks;
	}
	public void setApplyRemarks(String applyRemarks) {
		this.applyRemarks = applyRemarks;
	}
	public String getApproveUser() {
		return approveUser;
	}
	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}
	public String getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
	}
	public String getApproveRemarks() {
		return approveRemarks;
	}
	public void setApproveRemarks(String approveRemarks) {
		this.approveRemarks = approveRemarks;
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
		return "OrderApplyEntity [id=" + id + ", orederNo=" + orederNo
				+ ", applyNo=" + applyNo + ", applyUser=" + applyUser
				+ ", applyTime=" + applyTime + ", applyRemarks=" + applyRemarks
				+ ", approveUser=" + approveUser + ", approveTime="
				+ approveTime + ", approveRemarks=" + approveRemarks
				+ ", createUser=" + createUser + ", createTime=" + createTime
				+ "]";
	}
	
}

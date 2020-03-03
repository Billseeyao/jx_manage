package main.java.com.po.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String passWord;
	private String email;
	private Long type;
	private String createTime;
	private String updateTime;
	private String state;
	private String flag;
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", passWord="
				+ passWord + ", email=" + email + ", nickName="
				+ ", type=" + type + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", state=" + state + "]";
	}

	
//	public UserEntity(Long id, String name, String passWord, String email, 
//			Long type, String createTime, String updateTime,String state) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.passWord = passWord;
//		this.email = email;
//		this.type = type;
//		this.createTime = createTime;
//		this.updateTime = updateTime;
//		this.state = state;
//	}
	
	
}

package main.java.com.po.entity;

/**
 * 搜索查询Entity
 * @author ylyao
 *
 */
public class SearchEntity {

	private int offset;
	private int limit;
	private String orderNo;
	
	
	public SearchEntity() {
		super();
	}
	
	public SearchEntity(int offset, int limit, String orderNo) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.orderNo = orderNo;
	}
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
}

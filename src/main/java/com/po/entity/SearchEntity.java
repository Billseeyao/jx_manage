package main.java.com.po.entity;

/**
 * 搜索查询Entity
 * @author ylyao
 *
 */
public class SearchEntity {

	private int offset;
	private int limit;
	private String orederNo;
	
	
	public SearchEntity() {
		super();
	}
	
	public SearchEntity(int offset, int limit, String orederNo) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.orederNo = orederNo;
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
	public String getorederNo() {
		return orederNo;
	}
	public void setorederNo(String orederNo) {
		this.orederNo = orederNo;
	}
	
	
}

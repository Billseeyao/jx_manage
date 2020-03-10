package main.java.com.po.entity;
public class EmailSendInfoEntity{
	/**主键自增编号*/
	private Integer id;
	/**附件路径*/
	private String appendixPath;
	/**主题*/
	private String subject;
	/**发送人邮箱*/
	private String fromemail;
	/**抄送人邮箱*/
	private String cccopy;
	/**送达人邮箱*/
	private String toemail;
	/**发送时间*/
	private String sendtime;
	public EmailSendInfoEntity(){
		super();
	}
	public EmailSendInfoEntity(String appendixPath,String subject,String fromemail,String cccopy,String toemail,String sendtime){
		this.appendixPath=appendixPath;
		this.subject=subject;
		this.fromemail=fromemail;
		this.cccopy=cccopy;
		this.toemail=toemail;
		this.sendtime=sendtime;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setAppendixPath(String appendixPath){
		this.appendixPath=appendixPath;
	}
	public String getAppendixPath(){
		return this.appendixPath;
	}
	public void setSubject(String subject){
		this.subject=subject;
	}
	public String getSubject(){
		return this.subject;
	}
	public void setFromemail(String fromemail){
		this.fromemail=fromemail;
	}
	public String getFromemail(){
		return this.fromemail;
	}
	public void setCccopy(String cccopy){
		this.cccopy=cccopy;
	}
	public String getCccopy(){
		return this.cccopy;
	}
	public void setToemail(String toemail){
		this.toemail=toemail;
	}
	public String getToemail(){
		return this.toemail;
	}
	public void setSendtime(String sendtime){
		this.sendtime=sendtime;
	}
	public String getSendtime(){
		return this.sendtime;
	}
}
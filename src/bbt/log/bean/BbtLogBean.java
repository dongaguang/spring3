package bbt.log.bean;

import java.io.Serializable;
import java.util.Date;

public class BbtLogBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int loginLogId;
	private int userId;
	private String ip;
	private Date loginTime;
	
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
}

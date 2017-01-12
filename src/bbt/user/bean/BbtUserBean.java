package bbt.user.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * T_USER表对应的数据域
 * @author Administrator
 *
 */
public class BbtUserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String passWord;
	private int credit;
	private Date lastLoginTime;
	private String lastIpAddress;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastIpAddress() {
		return lastIpAddress;
	}
	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}
}

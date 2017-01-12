package bbt.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbt.log.bean.BbtLogBean;
import bbt.log.dao.BbtLogDao;
import bbt.user.bean.BbtUserBean;
import bbt.user.dao.BbtUserDao;

/**
 * 具体的业务层
 * @author Administrator
 *
 */
@Service //将BbtUserService标注成一个业务层(服务层)的Bean
public class BbtUserService {
	@Autowired
	private BbtUserDao userDao;
	
	@Autowired
	private BbtLogDao logDao;
	
	/**
	 * 判断用户输入的用户名和密码的是否正确
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return
	 */
	public boolean hasMatchUser(String userName, String passWord){
		int macthCount = userDao.getMatchCount(userName, passWord);
		return macthCount > 0;
	}
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName 用户名
	 * @return
	 */
	public BbtUserBean findUserByUserName(String userName){
		return userDao.findUserByUserName(userName);
	}
	
	/**
	 * 登陆成功，用户积分+5
	 * 记录用户登陆日志
	 * @param user
	 */
	public void loginSuccess(BbtUserBean user){
		user.setCredit(user.getCredit() + 5 );
		BbtLogBean log = new BbtLogBean();
		log.setLoginLogId(user.getUserId());
		log.setIp(user.getLastIpAddress());
		log.setLoginTime(user.getLastLoginTime());
		userDao.updateUserLoginInfo(user);
		logDao.insertLoginLog(log);
	}
}

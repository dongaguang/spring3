package bbt.log.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bbt.log.bean.BbtLogBean;

/**
 * 用户登陆的日志表相关的数据库操作
 * @author Administrator
 *
 */
@Repository
public class BbtLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 用户登陆插入日志表
	 * @param log
	 */
	public void insertLoginLog(BbtLogBean log){
		String sqlStr = "INSERT INTO T_LOGIN_LOG(USER_ID,IP,LOGIN_TIME) VALUES(?, ?, ?)";
		Object[] args = {log.getUserId(), log.getIp(), log.getLoginTime()};
		jdbcTemplate.update(sqlStr, args);
	}
}

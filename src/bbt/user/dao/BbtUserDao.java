package bbt.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import bbt.user.bean.BbtUserBean;

/**
 * 用户登陆的数据库相关操作
 * @author Administrator
 *
 */
@Repository //通过Spring注解的方式定义一个DAO
public class BbtUserDao{
	
	@Autowired //自动注入JdbcTemplate的Bean
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 获得数据库中和用户名密码匹配的数量
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return
	 */
	public int getMatchCount(String userName,String passWord){
		String sqlStr = "SELECT COUNT(*) FROM T_USER T WHERE T.USER_NAME = ? AND T.PASSWORD = ?";
		return jdbcTemplate.queryForObject(sqlStr, Integer.class, new Object[]{userName, passWord});
	}
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public BbtUserBean findUserByUserName(String userName){
		String sqlStr = "SELECT USER_ID,USER_NAME,CREDIT FROM T_USER WHERE USER_NAME = ?";
		final BbtUserBean user = new BbtUserBean();
		jdbcTemplate.query(sqlStr, new Object[]{userName},
				new RowCallbackHandler() {
					//匿名类方式实现的回调函数
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("USER_ID"));
						user.setUserName(rs.getString("USER_NAME"));
						user.setCredit(rs.getInt("credit"));
					}
				});
		return user;
	}
	
	public void updateUserLoginInfo(BbtUserBean user){
		String sqlStr = "UPDATE T_USER SET LAST_LOGIN_TIME = ?, LAST_IP_ADDRESS = ?, CREDIT = ? WHERE USER_ID = ?";
		jdbcTemplate.update(sqlStr, new Object[]{user.getLastLoginTime(), user.getLastIpAddress(), user.getCredit(), user.getUserId()});
	}
}

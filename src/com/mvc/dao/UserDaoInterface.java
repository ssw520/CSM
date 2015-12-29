package com.mvc.dao;

import java.util.Map;

import com.mvc.bean.User;

/**
 * @description 用户管理服务
 * @author Kevin
 * 
 */
public interface UserDaoInterface {
	public abstract void add(User user);

	public abstract void delete(String id);

	public abstract void update(User user);

	/**
	 * 根据Id获得用户信息
	 * 
	 * @param id
	 * @return 返回用户
	 */
	public abstract User getUserByID(String id);


	/**
	 * @return 返回所有的用户
	 */
	public abstract Map<String, User> getAllUser();

	/**
	 * 超级管理员
	 * 
	 * @param user
	 *            要更改的用户
	 * @param Power
	 *            更改为的权限
	 */
	public abstract void changeUserPower(User user, int Power);
	/**
	 * @description 存数据到数据库
	 */
	public abstract void saveUserDate();
}

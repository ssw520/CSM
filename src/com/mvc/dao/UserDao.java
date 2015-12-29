package com.mvc.dao;

import java.util.Map;

import com.mvc.bean.User;
import com.mvc.util.sql.UserSql;

public class UserDao implements UserDaoInterface {
	UserSql userSql = new UserSql();
	@Override
	public void add(User user) {
		userSql.save(user);
	}

	@Override
	public void delete(String id) {
		userSql.delet(userSql.getUserByID(id).getAccount().getId());
	}

	@Override
	public void update(User user) {
		userSql.update(user);
	}

	@Override
	public User getUserByID(String id) {
		User user = userSql.getUserByID(id);
		if (user != null) {
			return user;
		}
		System.out.println("未找到ID为：" + id + "的用户");
		return null;
	}

	@Override
	public Map<String, User> getAllUser() {
		Map<String, User> userMap = userSql.getAllUser();
		if (!userMap.isEmpty()) {
			return userMap;
		}
		System.out.println("没有用户");
		return null;
	}

	@Override
	public void changeUserPower(User user, int power) {
		user.getAccount().setPower(power);
		userSql.update(user);
	}
	@Override
	public  void saveUserDate(){
		
	//	userSql.save(userMap);
	}
}

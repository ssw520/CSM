package com.mvc.services;

import java.util.Map;

import com.mvc.bean.User;
import com.mvc.dao.UserDao;

public class UserService implements UserServicesInterface {

	private UserDao userDao = new UserDao();
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User getUserByID(String id) {
		return userDao.getUserByID(id);
	}

	@Override
	public Map<String, User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public void changeUserPower(User user, int power) {
		// TODO Auto-generated method stub
		userDao.changeUserPower(user, power);
	}
	@Override
	public void saveUserDate(){
		userDao.saveUserDate();
	}
}
